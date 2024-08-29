package com.watch.shop.app.service;

import com.watch.shop.app.model.Watch;

import java.util.List;

public interface WatchService {

    List<Watch> getWatches();

    List<Watch> sortWatchesByParam(String param);

    Double getTotalCost();

    void insertWatch(Watch watch);
}
