package com.example.demo.Domain;

public class Product {
    private ProductName productName;
    private ProductPrice productPrice;
    private ProductId productId;
    private ProductDescription productDescription;

    public Product(ProductName productName, ProductPrice productPrice, ProductId productId, ProductDescription productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productId;
        this.productDescription = productDescription;
    }

    public Product(){

    }

    public ProductName getName() {
        return productName;
    }

    public ProductPrice getPrice() {
        return productPrice;
    }

    public ProductId getId() {
        return productId;
    }

    public void setId(ProductId productId) {
        this.productId = productId;
    }

    public void setPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }

    public void setName(ProductName productName) {
        this.productName = productName;
    }

    public ProductDescription getDescription() {
        return productDescription;
    }

    public void setDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }
}
