package com.example.demo.Domain.ShoppingCar.Products;

import java.util.Objects;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateDesciption;

public class ProductDescription {
    final private String value;
    public ProductDescription(String value){
        ValidateDesciption(value);

        this.value = value;
}
}
