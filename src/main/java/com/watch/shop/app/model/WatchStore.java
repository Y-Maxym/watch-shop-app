package com.watch.shop.app.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class WatchStore {

    private static WatchStore instance;

    @Setter(AccessLevel.NONE)
    private List<Watch> watches;

    private WatchStore() {
        initializeStore();
    }

    public static WatchStore getInstance() {
        if (instance == null) {
            instance = new WatchStore();
        }
        return instance;
    }

    public List<Watch> getWatches() {
        return new ArrayList<>(watches);
    }

    public void addWatch(Watch watch) {
        watches.add(watch);
    }

    private void initializeStore() {
        watches = new ArrayList<>() {{
            add(Watch.builder()
                    .price(199.99)
                    .color(Color.BLACK)
                    .arrivalDate(LocalDate.of(2023, 8, 1))
                    .type(WatchType.QUARTZ)
                    .brand("Casio")
                    .model("G-Shock")
                    .build());

            add(Watch.builder()
                    .price(299.99)
                    .color(Color.SILVER)
                    .arrivalDate(LocalDate.of(2023, 7, 15))
                    .type(WatchType.MECHANICAL)
                    .brand("Seiko")
                    .model("Prospex")
                    .build());

            add(Watch.builder()
                    .price(149.99)
                    .color(Color.GOLD)
                    .arrivalDate(LocalDate.of(2023, 6, 25))
                    .type(WatchType.SOLAR)
                    .brand("Citizen")
                    .model("Eco-Drive")
                    .build());

            add(Watch.builder()
                    .price(399.99)
                    .color(Color.BLUE)
                    .arrivalDate(LocalDate.of(2023, 5, 10))
                    .type(WatchType.SMART)
                    .brand("Apple")
                    .model("Apple Watch Series 7")
                    .build());

            add(Watch.builder()
                    .price(249.99)
                    .color(Color.RED)
                    .arrivalDate(LocalDate.of(2023, 4, 5))
                    .type(WatchType.QUARTZ)
                    .brand("Fossil")
                    .model("Hybrid HR")
                    .build());
        }};
    }
}
