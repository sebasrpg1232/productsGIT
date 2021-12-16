package com.example.demo.Configuration.jackson.codecs;

import com.example.demo.Domain.ProductId;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductIdCodecs {
    public static class Serializer extends JsonSerializer<ProductId> {
        @Override
        public void serialize(ProductId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }

        public static class Deserializer extends JsonDeserializer<ProductId> {

            @Override
            public ProductId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                return ProductId.fromString(p.getValueAsString());
            }
        }
    }
}
