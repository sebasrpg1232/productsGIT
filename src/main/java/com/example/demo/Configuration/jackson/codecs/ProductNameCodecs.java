package com.example.demo.Configuration.jackson.codecs;

import com.example.demo.Domain.ShoppingCar.Products.ProductName;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductNameCodecs {
    public static class Serializer extends JsonSerializer<ProductName> {
        @Override
        public void serialize(ProductName value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }
        public static class Deserializer extends JsonDeserializer<ProductName> {

            @Override
            public ProductName deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                return new ProductName(p.getValueAsString());
            }
        }
    }

