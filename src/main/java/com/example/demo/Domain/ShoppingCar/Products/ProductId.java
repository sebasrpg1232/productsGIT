package com.example.demo.Domain.ShoppingCar.Products;

import java.util.UUID;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateId;

public class ProductId {
    private final UUID value;


    public ProductId(UUID value) {
        ValidateId(value);
        this.value = value;
    }

    public static ProductId CreateANewId() {
        return new ProductId(UUID.randomUUID());
    }

    public static ProductId fromString(String unsafeId) {
        return new ProductId(UUID.fromString(unsafeId));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
