package com.example.demo.Domain.ShoppingCar.Products;

import com.example.demo.Domain.ShoppingCar.Money;

import java.math.BigDecimal;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidatePrice;
/*
  USD = 3991.03COP
  USD = 0.88EUR
  COP = 0.00025USD
  COP = 0.00022EUR
  EUR = 4543,31COP
  EUR = 1,13USD
   */
public class ProductPrice {
    private Money value;
    private String productType;


    public ProductPrice(String divisa, BigDecimal valor) {
        ValidatePrice(new Money(divisa, valor));
        divisa.toUpperCase();
        this.productType = ProductType(divisa, valor);
        this.value = new Money(divisa, valor);
    }

    public String ProductType(String divisa, BigDecimal valor){
        switch (divisa) {
            case "USD":
                if (valor.compareTo(new BigDecimal("0")) < 50) {
                    productType = "barato";
                } else if (valor.compareTo(new BigDecimal("0")) < 200) {
                    productType = "normal";
                } else if (valor.compareTo(new BigDecimal("0")) > 199) {
                    productType = "caro";
                }
                break;
            case "EUR":
                valor = valor.multiply(new BigDecimal("1.13"));
                if (valor.compareTo(new BigDecimal("0")) < 50) {
                    productType = "barato";
                } else if (valor.compareTo(new BigDecimal("0")) < 200) {
                    productType = "normal";
                } else if (valor.compareTo(new BigDecimal("0")) > 199) {
                    productType = "caro";
                }
                break;
            case "COP":
                valor = valor.multiply(new BigDecimal("0.00025"));
                if (valor.compareTo(new BigDecimal("0")) < 50) {
                    productType = "barato";
                } else if (valor.compareTo(new BigDecimal("0")) < 200) {
                    productType = "normal";
                } else if (valor.compareTo(new BigDecimal("0")) > 199) {
                    productType = "caro";
                }
                break;
        }
        return productType;
    }

    public Money getValue() {
        return value;
    }

}
