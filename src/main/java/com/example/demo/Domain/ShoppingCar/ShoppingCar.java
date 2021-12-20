package com.example.demo.Domain.ShoppingCar;

import com.example.demo.Domain.ShoppingCar.Products.Product;
import com.example.demo.Domain.ShoppingCar.Products.ProductPrice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/*
atributos:
identificador del cliente --
fecha de creacion --
fecha de ultima actualizacion --
productos y cantidades --
    identificador del producto --
    precio del producto --
        Money --
    cantidad Del producto --
Total a pagar (calculado) --
    Money --
        Valor es un bigdecimal --
        Divisa Es un Enum[EUR, USD, COP] --

Producto:
    id ---
    name ---
    descripcion ---
    precio: ---
        moneda ---

reglas:
    los precios de los productos pueden clasificarse como:
        baratos: x < 50 USD --
        Normales: x < 199 USD --
        Caros x > 199 USD --
    No se pueden tener mas de una unidad de un producto caro
    No se pueden tener mas de 10 unidades de productos normales
    Por cada 3 unidades del mismo producto se descuenta un 10% acumulable hasta 3 descuentos
    Si el total supera los 500 USD, se descuenta 10% sobre el total

 */

public class ShoppingCar {
    private List<Product> products;
    private ClientId id;
    private LocalDateTime fechaDeCreacion;
    private LocalDateTime fechaDeLaUltimaActualizacion;
    private Money totalCost;

    public ShoppingCar(List<Product> products, ClientId id, LocalDateTime fechaDeCreacion, LocalDateTime fechaDeLaUltimaActualizacion, Money totalCost) {
        this.products = products;
        this.id = id;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeLaUltimaActualizacion = fechaDeLaUltimaActualizacion;


    }

    public Money GetTotalPrice(List<Product> products) {

        List<BigDecimal> valores = (Money.getValuesWithDivisa((products.stream()
                .map(Product::getPrice)
                .map(ProductPrice::getValue)).collect(Collectors.toList())));
        String usd = "USD";
        return new Money(usd , valores.stream().reduce(BigDecimal.ZERO, (BigDecimal a, BigDecimal b) -> b.add(a)));
        // .reduce(BigDecimal.ZERO, (BigDecimal a, BigDecimal b) -> b.add(a));
        //Money money = new Money(products.stream().reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    public List<Product> getProducts() {
        return products;
    }

    public ClientId getId() {
        return id;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public LocalDateTime getFechaDeLaUltimaActualizacion() {
        return fechaDeLaUltimaActualizacion;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setFechaDeLaUltimaActualizacion(LocalDateTime fechaDeLaUltimaActualizacion) {
        this.fechaDeLaUltimaActualizacion = fechaDeLaUltimaActualizacion;
    }

 //   public Money getTotalCost(){
   //     return
    //}

}
