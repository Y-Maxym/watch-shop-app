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
    private String brand;
    private String model;
    private Color color;
    private WatchType type;
    private Double price;
    private LocalDate arrivalDate;
}
