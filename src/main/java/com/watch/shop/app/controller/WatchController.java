package com.watch.shop.app.controller;

import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.service.WatchService;
import com.watch.shop.app.view.WatchView;

import static com.watch.shop.app.util.Constants.INVALID_CHOICE_MESSAGE;
import static com.watch.shop.app.util.Constants.INVALID_INPUT_MESSAGE;

public class WatchController {

    private final WatchService service;
    private final WatchView view;
    private final MenuHandler menuHandler;

    public WatchController(WatchService service, WatchView view) {
        this.service = service;
        this.view = view;
        this.menuHandler = new MenuHandler(view);
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            String choice = menuHandler.printMainMenu();

            switch (choice) {
                case "1" -> menuHandler.displayAllWatches(service.getWatches());
                case "2" -> sortChoice();
                case "3" -> menuHandler.displayTotalCost(service.getTotalCost());
                case "4" -> {
                    try {
                        Watch watch = menuHandler.printNewWatchMenu();
                        service.insertWatch(watch);
                    } catch (Exception e) {
                        view.printMessage(INVALID_INPUT_MESSAGE);
                    }
                }
                case "5" -> isRunning = false;
                default -> view.printMessage(INVALID_CHOICE_MESSAGE);
            }
        }
    }

    private void sortChoice() {
        boolean isRunning = true;

        while (isRunning) {
            String param = menuHandler.printSortMenu();

            switch (param) {
                case "1" -> menuHandler.displayAllWatches(service.getSortedWatchesByPrice());
                case "2" -> menuHandler.displayAllWatches(service.getSortedWatchesByColor());
                case "3" -> menuHandler.displayAllWatches(service.getSortedWatchesByArrivalDate());
                case "4" -> isRunning = false;
                default -> view.printMessage(INVALID_CHOICE_MESSAGE);
            }
        }
    }
}
