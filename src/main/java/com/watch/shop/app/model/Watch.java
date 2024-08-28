package com.watch.shop.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Watch {
    private Double price;
    private Color color;
    private LocalDateTime arrivalDate;
    private WatchType type;
    private String brand;
    private String model;
}
