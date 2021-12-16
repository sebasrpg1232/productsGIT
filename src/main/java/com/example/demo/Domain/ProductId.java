package com.example.demo.Domain;

import java.util.Objects;
import java.util.UUID;

public class ProductId {
    private final UUID value;


    public ProductId(UUID value) {
        Objects.requireNonNull(value, "El id no debe ser null");
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
