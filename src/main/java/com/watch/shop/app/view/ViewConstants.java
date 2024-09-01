package com.watch.shop.app.view;

public class ViewConstants {

    public static final String START_SEPARATOR = "_".repeat(97);
    public static final String END_SEPARATOR = "|" + "_".repeat(95) + "|";
    public static final String FORMAT_HEADER = "| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n";
    public static final String FORMAT_SEPARATOR = "| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n";
    public static final String FORMAT_ROW = "| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n";

    public static final String MENU = """
            \nChoose an action:
             1. Display all watches
             2. Sort by parameter and display all watches
             3. Display total cost of watches
             4. Add a new watch
             5. Exit
            """;
    public static final String SORT_MENU = """
            \nChoose a parameter:
             1. Price
             2. Color
             3. Arrival Date
             4. Exit
            """;
}
