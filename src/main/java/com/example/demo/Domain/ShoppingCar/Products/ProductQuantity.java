package com.example.demo.Domain.ShoppingCar.Products;

import java.util.Objects;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateQuantity;

public class ProductQuantity {
    private final Integer quantity;

    public ProductQuantity(Integer quantity) {
        ValidateQuantity(quantity);

        this.quantity = quantity;
    }
}
