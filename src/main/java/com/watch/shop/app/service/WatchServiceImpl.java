package com.watch.shop.app.service;

import com.watch.shop.app.model.Watch;
import com.watch.shop.app.model.WatchStore;

import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;

public class WatchServiceImpl implements WatchService {

    private final WatchStore watchStore = WatchStore.getInstance();

    public List<Watch> getWatches() {
        return watchStore.getWatches();
    }

    public List<Watch> sortWatchesByParam(String param) {
        if (isNull(param) || param.isBlank()) throw new IllegalArgumentException("Param cannot be empty");

        if ("price".equals(param)) {
            watchStore.getWatches().sort(Comparator.comparing(Watch::getPrice));
        } else if ("color".equalsIgnoreCase(param)) {
            watchStore.getWatches().sort(Comparator.comparing(Watch::getColor));
        } else if ("arrival date".equalsIgnoreCase(param)) {
            watchStore.getWatches().sort(Comparator.comparing(Watch::getArrivalDate));
        } else throw new IllegalArgumentException("Unknown parameter: " + param);

        return watchStore.getWatches();
    }

    public Double getAllPrices() {
        return watchStore.getWatches().stream()
                .mapToDouble(Watch::getPrice)
                .sum();
    }

    public void insertWatch(Watch watch) {
        watchStore.addWatch(watch);
    }
}
