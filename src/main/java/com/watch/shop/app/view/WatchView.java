package com.watch.shop.app.view;

import com.watch.shop.app.model.Color;
import com.watch.shop.app.model.Watch;
import com.watch.shop.app.model.WatchType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class WatchView {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserChoice() {
        String menu = """
                
                Choose an action:
                1. Display all watches
                2. Sort by parameter and display all watches
                3. Display total cost of watches
                4. Add a new watch
                5. Exit
                """;
        System.out.println(menu);
        return scanner.nextLine();
    }

    public String sortByParam() {
        String menu = """
                
                Choose a parameter:
                1. Price
                2. Color
                3. Arrival Date
                4. Exit
                """;
        System.out.println(menu);
        return scanner.nextLine();
    }

    public void displayAllWatches(List<Watch> watches) {
        System.out.println("_".repeat(97));
        System.out.printf("| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n", "Brand", "Model", "Color", "Type", "Price", "Arrival Date");
        System.out.printf("| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n", "_".repeat(12), "_".repeat(26), "_".repeat(11), "_".repeat(11), "_".repeat(11), "_".repeat(13));
        watches.forEach(w -> System.out.printf("| %-12s| %-26s| %-11s| %-11s| %-11s| %-13s|%n", w.getBrand(), w.getModel(), w.getColor(), w.getType(), w.getPrice(), w.getArrivalDate()));
        System.out.println("|" + "_".repeat(95) + "|");
    }

    public void displayTotalCost(Double totalCost) {
        String message = """
                
                Total cost:
                %.2f
                """.formatted(totalCost);
        System.out.print(message);
    }

    public Watch addNewWatch() {

        System.out.println("Enter Brand:");
        String brand = scanner.nextLine();

        System.out.println("Enter Model:");
        String model = scanner.nextLine();

        System.out.println("Enter Color (WHITE, SILVER, GOLD, BLUE, RED, BLACK):");
        String color = scanner.nextLine().toUpperCase();

        System.out.println("Enter Type (QUARTZ, MECHANICAL, SOLAR, SMART):");
        String type = scanner.nextLine().toUpperCase();

        System.out.println("Enter Price: ");
        String price = scanner.nextLine();

        System.out.println("Enter Arrival Date (YYYY-MM-DD):");
        String arrivalDate = scanner.nextLine();

        return Watch.builder()
                .brand(brand)
                .model(model)
                .color(Color.valueOf(color))
                .type(WatchType.valueOf(type))
                .price(Double.parseDouble(price))
                .arrivalDate(LocalDate.parse(arrivalDate))
                .build();
    }
}