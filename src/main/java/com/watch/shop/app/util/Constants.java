package com.watch.shop.app.util;

public class Constants {

    public static final String ENTER_BRAND_MESSAGE = "Enter Brand:";
    public static final String ENTER_MODEL_MESSAGE = "Enter Model:";
    public static final String ENTER_COLOR_MESSAGE = "Enter Color %s:\n";
    public static final String ENTER_TYPE_MESSAGE = "Enter Type %s:\n";
    public static final String ENTER_PRICE_MESSAGE = "Enter Price:";
    public static final String ENTER_ARRIVAL_DATE_MESSAGE = "Enter Arrival Date (YYYY-MM-DD):";
    public static final String LUMINOUS_HANDS_MESSAGE = "Does it have luminous hands? (true or false):";
    public static final String POWER_RESERVE_MESSAGE = "How much power reserve? (hours):";
    public static final String IS_AUTOMATIC_MESSAGE = "Is it automatic? (true or false):";
    public static final String MAX_CHARGE_TIME_MESSAGE = "How long does it take to charge? (hours):";
    public static final String HAS_HEART_RATE_MONITOR_MESSAGE = "Does it have a heart rate monitor? (true or false):";
    public static final String OPERATION_SYSTEM_MESSAGE = "Enter OS %s:\n";

    public static final String START_SEPARATOR = "_".repeat(97);
    public static final String END_SEPARATOR = "|" + "_".repeat(95) + "|";
    public static final String FORMAT_HEADER = "| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n";
    public static final String FORMAT_SEPARATOR = "|%-12s|%-26s|%-11s|%-11s|%-11s|%-13s|%n";
    public static final String FORMAT_ROW = "| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n";
    public static final String SEPARATOR = "_";

    public static final String INVALID_CHOICE_MESSAGE = "\nInvalid choice";
    public static final String INVALID_INPUT_MESSAGE = "\nInvalid input";

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
    public static final String TOTAL_COST_MESSAGE = """
            \nTotal cost:
            %.2f
            """;
}
