package com.example.demo;

import com.example.demo.Domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	Product product = new Product("mouse", 150000, "01");
	Product secondProduct = new Product();
}
