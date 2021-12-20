package com.example.demo.Domain.ShoppingCar;

import com.example.demo.Domain.ShoppingCar.Products.ProductId;

import java.util.Objects;
import java.util.UUID;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateId;

public class ClientId {
    private final UUID value;


    public ClientId(UUID value) {
        ValidateId(value);
        this.value = value;
    }

    public static ClientId CreateANewId() {
        return new ClientId(UUID.randomUUID());
    }

    public static ClientId fromString(String unsafeId) {
        return new ClientId(UUID.fromString(unsafeId));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
