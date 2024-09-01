package com.watch.shop.app.controller;

import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.service.WatchService;
import com.watch.shop.app.view.WatchView;
import lombok.RequiredArgsConstructor;

import static com.watch.shop.app.util.Constants.INVALID_CHOICE_MESSAGE;
import static com.watch.shop.app.util.Constants.INVALID_INPUT_MESSAGE;

@RequiredArgsConstructor
public class WatchController {

    private final WatchService watchService;
    private final WatchView watchView;
    private final MenuHandler menuHandler;

    public void run() {
        boolean running = true;

        while (running) {
            String choice = menuHandler.printMainMenu();

            switch (choice) {
                case "1" -> menuHandler.displayAllWatches(watchService.getWatches());
                case "2" -> sortChoice();
                case "3" -> menuHandler.displayTotalCost(watchService.getTotalCost());
                case "4" -> {
                    try {
                        Watch watch = menuHandler.printNewWatchMenu();
                        watchService.insertWatch(watch);
                    } catch (Exception e) {
                        watchView.printMessage(INVALID_INPUT_MESSAGE);
                    }
                }
                case "5" -> running = false;
                default -> watchView.printMessage(INVALID_CHOICE_MESSAGE);
            }
        }
    }

    private void sortChoice() {
        boolean running = true;

        while (running) {
            String param = menuHandler.printSortMenu();

            switch (param) {
                case "1" -> menuHandler.displayAllWatches(watchService.getSortedWatchesByPrice());
                case "2" -> menuHandler.displayAllWatches(watchService.getSortedWatchesByColor());
                case "3" -> menuHandler.displayAllWatches(watchService.getSortedWatchesByArrivalDate());
                case "4" -> running = false;
                default -> watchView.printMessage(INVALID_CHOICE_MESSAGE);
            }
        }
    }
}
