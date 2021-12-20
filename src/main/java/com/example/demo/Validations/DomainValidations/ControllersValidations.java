package com.example.demo.Validations.DomainValidations;

import com.example.demo.Domain.ShoppingCar.Money;
import com.example.demo.Domain.ShoppingCar.Products.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class ControllersValidations {

    public static void ValidateProduct(
            ProductName unSafeproductName,
            ProductPrice unSafeproductPrice,
            ProductId unSafeproductId,
            ProductDescription unSafeproductDescription,
            ProductQuantity unSafeproductQuantity) {

        Objects.requireNonNull(unSafeproductDescription,"La descripcion debe ser null");
        Objects.requireNonNull(unSafeproductName,"El nombre No debe ser null");
        Objects.requireNonNull(unSafeproductPrice,"El precio No debe ser null");
        Objects.requireNonNull(unSafeproductId,"El id No debe ser null");
        Objects.requireNonNull(unSafeproductQuantity,"La cantidad No debe ser null");
    }

    public static void ValidateName(String unSafeValue) {
        Objects.requireNonNull(unSafeValue, "El nombre no puede ser null");
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{10,64}$");
        unSafeValue.trim();

        if (unSafeValue.equals("")) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if (unSafeValue.length() > 500) {
            throw new IllegalArgumentException("el nombre no puede ser superior a 500 caracteres");
        }

        boolean valid = pattern.matcher(unSafeValue).matches();

        if (!valid) {
            throw new IllegalArgumentException("El nombre tiene caracteres especiales");
        }
    }

    public static void ValidateQuantity(Integer unSafeValue) {
        Objects.requireNonNull(unSafeValue);
        boolean quantityBeenZeroOrLess = unSafeValue <= 0;
        if (quantityBeenZeroOrLess) throw new IllegalArgumentException("The Quantity Cant Be Less Than Zero");
    }

    public static void ValidateDesciption(String unSafeValue) {
        Objects.requireNonNull(unSafeValue);
        unSafeValue.trim();
        if(unSafeValue.equals("")){
            throw new IllegalArgumentException("The description cant be empty");
        }  }

    public static void ValidatePrice(Money moneyUnSafeValue) {
        String unSafedDivisa = moneyUnSafeValue.getDivisa();
        BigDecimal unSafedValue = moneyUnSafeValue.getValorActual();

        Objects.requireNonNull(unSafedDivisa, "La divisa no debe ser null");
        Objects.requireNonNull(unSafedValue, "El precio no debe ser null");

        boolean validDivisa = false;
        switch (unSafedDivisa.toUpperCase()) {
            case "USD":
            case "COP":
            case "EUR":
                validDivisa = true;
                break;
        }
        if (!validDivisa) throw new IllegalArgumentException("La divisa debe ser USD, COP o EUR");

        //boolean validPrice = false;
        if (unSafedValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio del producto no debe ser 0 o negativo,");
        }
    }

    public static void ValidateId(UUID unSafeValue) {
        Objects.requireNonNull(unSafeValue, "El id no debe ser null");
    }

    public static void ValidateLastUpdateDate(LocalDateTime unSafeValue, LocalDateTime creationDate) {
        Objects.requireNonNull(unSafeValue, "El id no debe ser null");
        if(creationDate.isBefore(unSafeValue)){
            throw new IllegalArgumentException("La ultima fecha de actualizacion no debe ser antes de la fecha de creacion");
        }
    }

    public static void ValidateMoney(String unSafeDivisa, BigDecimal unSafeValue) {
        Objects.requireNonNull(unSafeValue, "El valor no debe ser null");
        Objects.requireNonNull(unSafeDivisa, "La divisa no debe ser null");

        boolean valorActualNegativo = unSafeValue.compareTo(new BigDecimal("0.00")) <= 0;
        if (valorActualNegativo) {
            throw new IllegalArgumentException("The money value cant be zero or less");
        }
        boolean validDivisa = false;
        switch (unSafeDivisa.toUpperCase()) {
            case "USD":
            case "COP":
            case "EUR":
                validDivisa = true;
                break;
        }
        if (!validDivisa) {
            throw new IllegalArgumentException("La divisa debe ser USD, COP o EUR, la divisa es invalida.");
        }
    }

}
