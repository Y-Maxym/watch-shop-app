package com.watch.shop.app.model.service;

import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.repository.WatchStore;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;

public class WatchServiceImpl implements WatchService {

    public static final String PRICE_PARAMETER = "price";
    public static final String COLOR_PARAMETER = "color";
    public static final String ARRIVAL_DATE_PARAMETER = "arrival date";

    private final WatchStore watchStore = new WatchStore();

    public List<Watch> getWatches() {
        return Collections.unmodifiableList(watchStore.getWatches());
    }

    public List<Watch> sortWatchesByParam(String param) {
        if (isNull(param) || param.isBlank()) {
            throw new IllegalArgumentException("Param cannot be empty");
        }

        List<Watch> watches = watchStore.getWatches();
        Comparator<Watch> comparator = resolveComparator(param);

        watches.sort(comparator);

        return watches;
    }

    public BigDecimal getTotalCost() {
        return watchStore.getWatches().stream()
                .map(Watch::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void insertWatch(Watch watch) {
        watchStore.addWatch(watch);
    }

    private Comparator<Watch> resolveComparator(String param) {
        return switch (param) {
            case PRICE_PARAMETER -> Comparator.comparing(Watch::getPrice);
            case COLOR_PARAMETER -> Comparator.comparing(watch -> watch.getColor().name());
            case ARRIVAL_DATE_PARAMETER -> Comparator.comparing(Watch::getArrivalDate);
            default -> throw new IllegalArgumentException("Unknown parameter: " + param);
        };
    }
}
