package com.example.demo.model;

import java.math.BigDecimal;

public class CreateProductInput {
    private String name;
    private BigDecimal price;
    private String Description;

    public CreateProductInput(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
