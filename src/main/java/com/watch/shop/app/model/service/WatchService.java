package com.watch.shop.app.model.service;

import com.watch.shop.app.model.entity.Watch;

import java.math.BigDecimal;
import java.util.List;

public interface WatchService {

    List<Watch> getWatches();

    List<Watch> getSortedWatchesByPrice();

    List<Watch> getSortedWatchesByColor();

    List<Watch> getSortedWatchesByArrivalDate();

    BigDecimal getTotalCost();

    void insertWatch(Watch watch);
}
