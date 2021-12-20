package com.example.demo.Domain.ShoppingCar;

import java.time.Instant;
import java.time.LocalDateTime;

public class CreationDate {
    private final LocalDateTime creationDate;

    public CreationDate() {
        Instant creationDateV = Instant.now();
        this.creationDate = LocalDateTime.from(creationDateV);
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
