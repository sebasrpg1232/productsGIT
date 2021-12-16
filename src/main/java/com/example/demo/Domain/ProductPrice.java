package com.example.demo.Domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import static java.lang.Integer.parseInt;

public class ProductPrice {
    private BigDecimal value;

    public ProductPrice(BigDecimal value) {

        if(parseInt(value.toString()) <= 0) {
        throw new IllegalArgumentException("El precio no puede ser 0 o negativo");
        }
        this.value = value;
    }

    public BigDecimal asBigDecimal(){
    return value;
    }


}
