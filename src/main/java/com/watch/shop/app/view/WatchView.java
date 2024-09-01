package com.watch.shop.app.view;

public class WatchView {

    public void printFormattedMessage(String message, Object... args) {
        System.out.printf(message, args);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}