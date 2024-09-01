package com.watch.shop.app.model.service;

import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.repository.WatchStore;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WatchServiceImpl implements WatchService {

    private final WatchStore store = new WatchStore();

    @Override
    public List<Watch> getWatches() {
        return Collections.unmodifiableList(store.getWatches());
    }

    @Override
    public List<Watch> getSortedWatchesByPrice() {
        return getSortedWatchesByParam(Comparator.comparing(Watch::getPrice));
    }

    @Override
    public List<Watch> getSortedWatchesByColor() {
        return getSortedWatchesByParam(Comparator.comparing(watch -> watch.getColor().name()));
    }

    @Override
    public List<Watch> getSortedWatchesByArrivalDate() {
        return getSortedWatchesByParam(Comparator.comparing(Watch::getArrivalDate));
    }

    @Override
    public BigDecimal getTotalCost() {
        return store.getWatches().stream()
                .map(Watch::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void insertWatch(Watch watch) {
        store.addWatch(watch);
    }

    private List<Watch> getSortedWatchesByParam(Comparator<? super Watch> comparator) {
        return store.getWatches().stream()
                .sorted(comparator)
                .toList();
    }
}
