package com.example.demo.repository;

import com.example.demo.Domain.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
public class ProgressProductsRepository implements ProductRepository{
    private final DataSource dataSource;

    public ProgressProductsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> list() {
        List<Product> result = new ArrayList<>();
        String sqlQuery = "select * from products";

        try(
                Connection connection = dataSource.getConnection();
                Statement statement =connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
        ){
            while(resultSet.next()){
                String productId = resultSet.getString("id_number");
                String productName = resultSet.getString("name");
                double productPrice = resultSet.getDouble("price");
                Product product = new Product(
                        productName,
                        productPrice,
                        productId
                );
               // System.out.println(product.toString());
                result.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Product getter(String id) {
        Product product = null;
        String sqlQuery = "select * from products where id_number = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ){
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String productId = resultSet.getString("id_number");
                String productName = resultSet.getString("name");
                double productPrice = resultSet.getDouble("price");
                product = new Product(
                        productName,
                        productPrice,
                        productId
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "insert into products(id_number, name, price) values(?, ?, ?)";
        try(
                Connection connection =dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());

            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, Product product) {
        String sqlQuery = "update products set id_number = ?, name = ?, price = ? where id_number = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ) {
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sqlQuery = "delete from products where id_number = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ) {
            ps.setString(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

