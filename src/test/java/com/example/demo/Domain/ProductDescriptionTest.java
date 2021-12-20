package com.example.demo.Domain;

import com.example.demo.Domain.ShoppingCar.Products.ProductDescription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ProductDescriptionTest {

    @Test
    @DisplayName("Checking null argument")
    void checkNull(){
        //arrange
        String value = null;
        //act
        Executable executable = () -> new ProductDescription(value);
        //assert
        assertThrows(NullPointerException.class, executable);
    }
    @Test
    @DisplayName("Checking empty argument")
    void checkEmptiness(){
        //arrange
        String value = "";
        //act
        Executable executable = () -> new ProductDescription(value);
        //assert
        assertThrows(IllegalArgumentException.class, executable);
    }

}