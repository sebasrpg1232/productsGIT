package com.example.demo.repository;

import com.example.demo.Domain.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcProductsRepository implements ProductRepository{
    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> rowMapper = (resultSet, rowNum) -> {
        String productId = resultSet.getString("id_number");
        String productName = resultSet.getString("name");
        double productPrice = resultSet.getDouble("price");
        return new Product(
                productName,
                productPrice,
                productId
        );
    };

    @Override
    public List<Product> list() {
        String sqlQuery = "select * from products";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Product getter(String id) {
        String sqlQuery = "select * from products where id_number = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id);
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "insert into products(id_number, name, price) values(?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps ->{
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
        });
    }

    @Override
    public void update(String id, Product product) {
        String sqlQuery = "update products set id_number = ?, name = ?, price = ? where id_number = ?";
        jdbcTemplate.update(sqlQuery, ps ->{
            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, id);
        });
    }

    @Override
    public void delete(String id) {
        String sqlQuery = "delete from products where id_number = ?";
        jdbcTemplate.update(sqlQuery, id);
        }


}
