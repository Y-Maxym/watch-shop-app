package com.watch.shop.app.controller;

import com.watch.shop.app.model.Watch;
import com.watch.shop.app.service.WatchService;
import com.watch.shop.app.view.WatchView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WatchController {

    private final WatchService watchService;
    private final WatchView watchView;

    public void run() {
        boolean running = true;
        while (running) {
            Integer choice = watchView.getUserChoice();
            switch (choice) {
                case 1 -> watchView.displayAllWatches(watchService.getWatches());
                case 2 -> {
                    Integer param = watchView.sortByParam();
                    sortChoice(param);
                }
                case 3 -> watchView.displayTotalCost(watchService.getTotalCost());
                case 4 -> {
                    Watch watch = watchView.addNewWatch();
                    watchService.insertWatch(watch);
                }
                case 5 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void sortChoice(Integer param) {
        boolean running = true;
        while (running) {
            switch (param) {
                case 1 -> watchView.displayAllWatches(watchService.sortWatchesByParam("price"));
                case 2 -> watchView.displayAllWatches(watchService.sortWatchesByParam("color"));
                case 3 -> watchView.displayAllWatches(watchService.sortWatchesByParam("arrival date"));
                case 4 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
