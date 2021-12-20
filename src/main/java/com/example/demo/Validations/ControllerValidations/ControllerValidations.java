package com.example.demo.Validations.ControllerValidations;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class ControllerValidations {
public static void ValidateProduct(String productName, String productDescription, String productId, String productQuantity, String productPrice, String productDivisa){
    Objects.requireNonNull(productDescription,"La descripcion del producto no puede ser null");
    Objects.requireNonNull(productId,"el id del producto no puede ser null");
    Objects.requireNonNull(productName,"el nombre del producto no puede ser null");
    Objects.requireNonNull(productPrice,"el precio delproducto no puede ser null");
    Objects.requireNonNull(productQuantity,"la cantidad del producto no puede ser null");
    ValidateName(productName);
    ValidateId(productId);
    ValidatePrice(productPrice);
    ValidateQuantity(productQuantity);
}

public static void ValidateName(String productName){
    Pattern pattern = Pattern.compile("^[a-zA-Z\\s:]{10,64}$");
    productName.trim();
    boolean valid = pattern.matcher(productName).matches();
    if(productName.equals("")){
        throw new IllegalArgumentException("El nombre del producto no debe estar vacio");
    }
    if (!valid){
        throw new IllegalArgumentException("El nombre tiene caracteres especiales.");
    }
}

public static void ValidateId(String productId){
    try{
        UUID validProductId = UUID.fromString(productId);
    }catch (Exception e){
        throw new IllegalArgumentException("El productId no es valido, debe ser del tipo UUID");
    }

}
    public static void ValidateQuantity(String quantity){
        try{
            int safeQuantity = Integer.parseInt(quantity);
        }catch (Exception e){
            throw new IllegalArgumentException("El productQuantity no es valido, debe ser del tipo Entero");
        }

    }
    public static void ValidatePrice(String productPrice){
        try{
            BigDecimal safeValue = new BigDecimal(productPrice);
        }catch (Exception e){
            throw new IllegalArgumentException("El productPrice no es valido, debe ser del tipo Numero");
        }

    }



}
