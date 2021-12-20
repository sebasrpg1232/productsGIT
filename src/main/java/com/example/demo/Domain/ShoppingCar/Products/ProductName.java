package com.example.demo.Domain.ShoppingCar.Products;

import java.util.Objects;
import java.util.regex.Pattern;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateName;

public class ProductName {
    private final String productName;
    //private static final Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{10,64}$");

    public ProductName(String productName) {
        ValidateName(productName);
        this.productName = productName;
    }
}
