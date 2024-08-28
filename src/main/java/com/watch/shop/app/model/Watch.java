package com.watch.shop.app.model;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Watch {
    private final UUID id = UUID.randomUUID();
    private Double price;
    private Color color;
    private LocalDate arrivalDate;
    private WatchType type;
    private String brand;
    private String model;
}
