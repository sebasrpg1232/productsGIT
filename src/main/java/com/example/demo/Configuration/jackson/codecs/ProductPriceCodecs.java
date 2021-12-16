package com.example.demo.Configuration.jackson.codecs;

import com.example.demo.Domain.ProductPrice;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class ProductPriceCodecs {


        public static class Serializer extends JsonSerializer<ProductPrice> {
            @Override
            public void serialize(ProductPrice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            BigDecimal number = new BigDecimal(String.valueOf(value));
                gen.writeNumber(number);
            }

            public static class Deserializer extends JsonDeserializer<ProductPrice> {


                @Override
                public ProductPrice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                    return new ProductPrice(new BigDecimal(String.valueOf(p)));

            }
        }
    }

}
