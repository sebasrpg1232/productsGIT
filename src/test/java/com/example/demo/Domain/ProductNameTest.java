package com.example.demo.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ProductNameTest {
    @Test
    @DisplayName("Name been null")
    void NameBeenNull(){
        //arrage
        String value = null;
        //act
        Executable executable =() -> new ProductName(value);
        //assert
        assertThrows(NullPointerException.class, executable);
    }
    @Test
    @DisplayName("Name been empty")
    void NameBeenEmpty(){
        //arrage
        String value ="";
        //act
        Executable executable = () -> new ProductName(value);
        //assert
        assertThrows(IllegalArgumentException.class, executable);
    }
    @Test
    @DisplayName("Name been bigger than 500 digits")
    void NameBeenBigger(){
        //arrage
        String value = "2".repeat(501);
        //act
        Executable executable = () -> new ProductName(value);
        //assert
        assertThrows(IllegalArgumentException.class, executable);
    }


}