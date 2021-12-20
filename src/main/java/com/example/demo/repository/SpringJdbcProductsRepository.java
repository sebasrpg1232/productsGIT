package com.example.demo.repository;

import com.example.demo.Domain.ShoppingCar.Products.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJdbcProductsRepository implements ProductRepository{
    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcProductsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Product> rowMapper = (resultSet, rowNum) -> {
        ProductId productId = ProductId.fromString(
                resultSet.getString("id_number")
        );
        ProductName productName = new ProductName(resultSet.getString("|"));
        ProductDescription productDescription = new ProductDescription(resultSet.getString("description"));
        ProductPrice productPrice = new ProductPrice(new BigDecimal(resultSet.getString("price")));
        return new Product(
                productName,
                productPrice,
                productId,
                productDescription
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
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, id.toString());
    }

    @Override
    public void create(Product product) {
        String sqlQuery = "insert into products(id_number, name, price, description) values(?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps ->{
            ps.setString(1, product.getId().toString());
            ps.setString(2, product.getName().toString());
            ps.setBigDecimal(3, new BigDecimal(String.valueOf(product.getPrice())));
            ps.setString(4, product.getDescription().toString());
        });
    }

    @Override
    public void update(String id, Product product) {
        String sqlQuery = "update products set id_number = ?, name = ?, price = ?, description = ? where id_number = ?";
        jdbcTemplate.update(sqlQuery, ps ->{
            ps.setString(1, product.getId().toString());
            ps.setString(2, product.getName().toString());
            ps.setBigDecimal(3, new BigDecimal(String.valueOf(product.getPrice())));
            ps.setString(4, product.getDescription().toString());
            ps.setString(5, id.toString());
        });
    }

    @Override
    public void delete(String id) {
        String sqlQuery = "delete from products where id_number = ?";
        jdbcTemplate.update(sqlQuery, id);
        }


}
