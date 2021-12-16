package com.example.demo.Domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class ProductName {
    private final String productName;
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{10,64}$");

    public ProductName(String productName) {
        String withoutSpacesProductName = productName.trim();
        Objects.requireNonNull(productName, "El nombre no puede ser null");

        if (withoutSpacesProductName.equals("")) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if (withoutSpacesProductName.length() > 500) {
            throw new IllegalArgumentException("el nombre no puede ser superior a 500 caracteres");
        }

        boolean valid = pattern.matcher(withoutSpacesProductName).matches();

        if (!valid) {
            throw new IllegalArgumentException("El nombre tiene caracteres especiales");
        }
        this.productName = productName;
    }
}
