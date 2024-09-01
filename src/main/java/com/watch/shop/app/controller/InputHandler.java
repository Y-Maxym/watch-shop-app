package com.watch.shop.app.controller;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public String readLineFromConsole() {
        return scanner.nextLine();
    }
}
