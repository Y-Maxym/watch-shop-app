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
            String choice = watchView.getUserChoice();
            switch (choice) {
                case "1" -> watchView.displayAllWatches(watchService.getWatches());
                case "2" -> sortChoice();
                case "3" -> watchView.displayTotalCost(watchService.getTotalCost());
                case "4" -> {
                    try {
                        Watch watch = watchView.addNewWatch();
                        watchService.insertWatch(watch);
                    } catch (Exception e) {
                        System.out.println("\nInvalid input");
                    }
                }
                case "5" -> running = false;
                default -> System.out.println("\nInvalid choice");
            }
        }
    }

    private void sortChoice() {
        boolean running = true;
        while (running) {
            String param = watchView.sortByParam();
            switch (param) {
                case "1" -> watchView.displayAllWatches(watchService.sortWatchesByParam("price"));
                case "2" -> watchView.displayAllWatches(watchService.sortWatchesByParam("color"));
                case "3" -> watchView.displayAllWatches(watchService.sortWatchesByParam("arrival date"));
                case "4" -> running = false;
                default -> System.out.println("\nInvalid choice");
            }
        }
    }
}
