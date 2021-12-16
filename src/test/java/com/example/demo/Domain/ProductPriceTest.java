package com.example.demo.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductPriceTest {

    private DynamicTest BigToTesting(BigDecimal value){
    String testName = "The number: " + value + " should work";
    return DynamicTest.dynamicTest(testName, () ->{
        //act
        ProductPrice productPrice = new ProductPrice(value);
        //assert
        assertEquals(value, productPrice.asBigDecimal());
    });

    }


    @TestFactory
    @DisplayName("valid Values")
    Stream<DynamicTest> validValues() {
        return IntStream.range(1, 100).mapToObj(value -> BigToTesting(new BigDecimal(value)));
    }

    @Test
    @DisplayName("price been negative")
    void priceBeenNegative() {
        //arrage

        BigDecimal value = new BigDecimal(-1);
        //act
        Executable executable = () -> new ProductPrice(value);
        //assert
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("price not been 0")
        void priceBeenZero() {
            //arrage
            BigDecimal value = new BigDecimal(0);
            //act
            Executable executable = () -> new ProductPrice(value);
            //assert
            assertThrows(IllegalArgumentException.class, executable);
        }

    }


