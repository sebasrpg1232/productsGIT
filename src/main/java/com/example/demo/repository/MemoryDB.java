package com.example.demo.repository;

import com.example.demo.Domain.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryDB implements ProductRepository{
    private final Map<String, Product> database = new HashMap<>();

    @Override
    public List<Product> list() {
        Collection<Product> values = database.values();
        return new ArrayList<>(values);
    }

    @Override
    public Product getter(String id) {
        return database.get(id);
    }

    @Override
    public void create(Product product) {
Product productFound = database.get(product.getId());
if (productFound != null) throw new IllegalArgumentException("The product with the id: " + product.getId() + " already exists.");

database.put(product.getId(), product);
    }

    @Override
    public void update(String id, Product product) {
Product productFound = database.get(id);
if (productFound == null) throw new IllegalArgumentException("not found");

database.put(id, product);
    }

    @Override
    public void delete(String id) {
Product productFound =database.get(id);
if (productFound == null) throw new IllegalArgumentException("not found");
    database.remove(id);
    }

}
