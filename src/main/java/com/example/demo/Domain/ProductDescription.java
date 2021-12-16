package com.example.demo.Domain;

import java.util.Objects;

public class ProductDescription {
    final private String value;
    public ProductDescription(String unTrimedValue){
        Objects.requireNonNull(unTrimedValue);
    String value = unTrimedValue.trim();
        if(value.equals("")){
        throw new IllegalArgumentException("The description cant be empty");
    }
        this.value = value;
}
}
