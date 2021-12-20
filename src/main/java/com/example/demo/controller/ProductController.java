package com.example.demo.controller;

import com.example.demo.Domain.ShoppingCar.Products.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.Validations.ControllerValidations.ControllerValidations.ValidateProduct;


@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Product> listProduct() {
        return repository.list();
    }


    @PostMapping
    public Product createAProduct(
            @PathVariable("productName")String productName,
            @PathVariable("productId")String productId,
            @PathVariable("productPrice")String productPrice,
            @PathVariable("productDescription")String productDescription,
            @PathVariable("productDivisa")String productDivisa,
            @PathVariable("productQuantity")String productQuantity
            @RequestBody createProductInput unSafeInput
    ) {
        ValidateProduct( productName, productDescription, productId, productQuantity,  productPrice, productDivisa);
      //  repository.create(product);
      //  return product;
    }


    @GetMapping(value = "/{id}")
    public Product getById(
            @PathVariable("id") String productId
    ) {
        return repository.getter(productId);
    }

    @DeleteMapping(value = "/{id}")
    public Product delete(
            @PathVariable("id") String productId
    ) {
        Product productFound = repository.getter(productId);
        repository.delete(productId);
        return productFound;
    }

    @PutMapping(value = "/{id}")
    public Product updateProduct(
            @PathVariable("id") String productId,
            @RequestBody Product product
    ) {
        repository.update(productId, product);
        return repository.getter(productId);
    }

}
