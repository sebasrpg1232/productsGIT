package com.example.demo.repository;

import com.example.demo.Domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> list();

    Product getter(String id);

    void create(Product product);

    void update(String id, Product product);

    void delete(String id);
}