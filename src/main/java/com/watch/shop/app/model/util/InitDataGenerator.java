package com.watch.shop.app.model.util;

import com.watch.shop.app.model.entity.Color;
import com.watch.shop.app.model.entity.MechanicalWatch;
import com.watch.shop.app.model.entity.OS;
import com.watch.shop.app.model.entity.QuartzWatch;
import com.watch.shop.app.model.entity.SmartWatch;
import com.watch.shop.app.model.entity.SolarWatch;
import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.entity.WatchType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitDataGenerator {

    public static List<Watch> initializeWatchStore() {
        return new ArrayList<>() {{
            add(QuartzWatch.builder()
                    .price(new BigDecimal("199.99"))
                    .color(Color.BLACK)
                    .arrivalDate(LocalDate.of(2023, 8, 1))
                    .type(WatchType.QUARTZ)
                    .brand("Casio")
                    .model("G-Shock")
                    .luminousHands(true)
                    .build());

            add(MechanicalWatch.builder()
                    .price(new BigDecimal("299.99"))
                    .color(Color.SILVER)
                    .arrivalDate(LocalDate.of(2023, 7, 15))
                    .type(WatchType.MECHANICAL)
                    .brand("Seiko")
                    .model("Prospex")
                    .isAutomatic(true)
                    .powerReserve(24)
                    .build());

            add(SolarWatch.builder()
                    .price(new BigDecimal("149.99"))
                    .color(Color.GOLD)
                    .arrivalDate(LocalDate.of(2023, 6, 25))
                    .type(WatchType.SOLAR)
                    .brand("Citizen")
                    .model("Eco-Drive")
                    .maxChargeTime(Duration.ofHours(2))
                    .build());

            add(SmartWatch.builder()
                    .price(new BigDecimal("399.99"))
                    .color(Color.BLUE)
                    .arrivalDate(LocalDate.of(2023, 5, 10))
                    .type(WatchType.SMART)
                    .brand("Apple")
                    .model("Apple Watch Series 7")
                    .hasHeartRateMonitor(true)
                    .os(OS.WATCH_OS)
                    .build());

            add(QuartzWatch.builder()
                    .price(new BigDecimal("249.99"))
                    .color(Color.RED)
                    .arrivalDate(LocalDate.of(2023, 4, 5))
                    .type(WatchType.QUARTZ)
                    .brand("Fossil")
                    .model("Hybrid HR")
                    .luminousHands(false)
                    .build());
        }};
    }
}
