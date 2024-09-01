package com.watch.shop.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(of = "id")
public abstract class Watch {
    private final UUID id = UUID.randomUUID();
    private final String brand;
    private final String model;
    private final Color color;
    private final WatchType type;
    private final BigDecimal price;
    private final LocalDate arrivalDate;
}
