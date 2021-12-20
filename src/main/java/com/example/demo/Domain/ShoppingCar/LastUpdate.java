package com.example.demo.Domain.ShoppingCar;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.example.demo.Validations.DomainValidations.ControllersValidations.ValidateLastUpdateDate;

public class LastUpdate {
    private final LocalDateTime ultimaActalizacion;

    public LastUpdate(LocalDateTime fechaDeCreacion) {
        ValidateLastUpdateDate(fechaDeCreacion, LocalDateTime.from(Instant.now()));
            this.ultimaActalizacion = fechaDeCreacion;
    }
}
