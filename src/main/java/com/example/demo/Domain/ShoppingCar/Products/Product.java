package com.example.demo.Domain.ShoppingCar.Products;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateProduct;

public class Product {
    private ProductName productName;
    private ProductPrice productPrice;
    private ProductId productId;
    private ProductDescription productDescription;
    private ProductQuantity productquantity;

    public Product(
            ProductName productName,
            ProductPrice productPrice,
            ProductId productId,
            ProductDescription productDescription,
            ProductQuantity productQuantity
    ) {

        ValidateProduct( productName, productPrice, productId, productDescription, productQuantity);

        this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productId;
        this.productDescription = productDescription;
        this.productquantity = productQuantity;
    }

    public ProductQuantity getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(ProductQuantity productquantity) {
        this.productquantity = productquantity;
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
