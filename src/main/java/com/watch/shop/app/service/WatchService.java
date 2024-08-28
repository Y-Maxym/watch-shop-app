package com.watch.shop.app.service;

import com.watch.shop.app.model.Watch;

import java.util.List;

public interface WatchService {

    List<Watch> getWatches();

    List<Watch> sortWatchesByParam(String param);

    Double getAllPrices();

    void insertWatch(Watch watch);
}
