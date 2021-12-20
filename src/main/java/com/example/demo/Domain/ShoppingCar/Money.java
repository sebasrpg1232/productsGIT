package com.example.demo.Domain.ShoppingCar;

import com.example.demo.Domain.ShoppingCar.Products.Product;
import com.example.demo.Domain.ShoppingCar.Products.ProductPrice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateMoney;
import static java.lang.String.valueOf;
import static java.util.Arrays.stream;

public class Money {
    private String divisa;
    private String cambioDeMoneda;
    private BigDecimal valorActual;


    /*
    USD = 3991.03COP
    USD = 0.88EUR
    COP = 0.00025USD
    COP = 0.00022EUR
    EUR = 4543,31COP
    EUR = 1,13USD
     */
    public Money(String divisa, BigDecimal valorActual) {
        ValidateMoney(divisa, valorActual);

        this.divisa = divisa;
        this.cambioDeMoneda = null;
        this.valorActual = valorActual;
    }

    public static List<BigDecimal> getValuesWithDivisa(List<Money> valor) {

        List<String> divisas = (valor.stream().map(Money::getDivisa)).collect(Collectors.toList());
        List<BigDecimal> unSafeValue= (valor.stream().map(Money::getValorActual)).collect(Collectors.toList());

        List<BigDecimal> safeValue = null;

        for (int i = 0; i < valor.size(); i++) {

            switch (divisas.get(i)){
                case "EUR":
                    safeValue.add(unSafeValue.get(i).multiply((new BigDecimal(0.88))));
                    break;
                case "COP":
                    safeValue.add(unSafeValue.get(i).multiply((new BigDecimal(3991.03))));
                    break;
            }

        }
        return safeValue;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public void setCambioDeMoneda(String cambioDeMoneda) {
        this.cambioDeMoneda = cambioDeMoneda;
    }

    public BigDecimal getValorActual() {
        return valorActual;
    }

    public void setValorActual(BigDecimal valorActual) {
        valorActual = valorActual;
    }
}
