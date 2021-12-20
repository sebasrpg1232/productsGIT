package com.example.demo.Configuration.jackson;

import com.example.demo.Configuration.jackson.codecs.ProductDescriptionCodecs;
import com.example.demo.Configuration.jackson.codecs.ProductIdCodecs;
import com.example.demo.Configuration.jackson.codecs.ProductNameCodecs;
//import com.example.demo.Configuration.jackson.codecs.ProductPriceCodecs;
import com.example.demo.Domain.ShoppingCar.Products.ProductDescription;
import com.example.demo.Domain.ShoppingCar.Products.ProductId;
import com.example.demo.Domain.ShoppingCar.Products.ProductName;
import com.example.demo.Domain.ShoppingCar.Products.ProductPrice;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class InternalModule extends SimpleModule {
 private static final String nombre = "InternalModule";

public InternalModule(){
super(nombre, Version.unknownVersion());

addSerializer(ProductId.class, new ProductIdCodecs.Serializer());
addSerializer(ProductName.class, new ProductNameCodecs.Serializer());
addSerializer(ProductDescription.class, new ProductDescriptionCodecs.Serializer());
//addSerializer(ProductPrice.class, new ProductPriceCodecs.Serializer());

addDeserializer(ProductId.class, new ProductIdCodecs.Deserializer());
addDeserializer(ProductName.class, new ProductNameCodecs.Deserializer());
addDeserializer(ProductDescription.class, new ProductDescriptionCodecs.Deserializer());
//addDeserializer(ProductPrice.class, new ProductPriceCodecs.Deserializer());

}

}
