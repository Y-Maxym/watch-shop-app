package com.watch.shop.app.model.repository;

import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.util.InitDataGenerator;

import java.util.ArrayList;
import java.util.List;

public class WatchStore {

    private final List<Watch> watches = InitDataGenerator.initializeWatchStore();

    public List<Watch> getWatches() {
        return new ArrayList<>(watches);
    }

    public void addWatch(Watch watch) {
        watches.add(watch);
    }
}
