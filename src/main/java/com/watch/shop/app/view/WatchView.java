package com.watch.shop.app.view;

import com.watch.shop.app.model.Color;
import com.watch.shop.app.model.Watch;
import com.watch.shop.app.model.WatchType;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class WatchView {

    private final Scanner scanner = new Scanner(System.in);

    public Integer getUserChoice() {
        String menu = """
                Choose an action:
                1. Display all watches
                2. Sort by parameter and display all watches
                3. Display total cost of watches
                4. Add a new watch
                5. Exit
                """;
        System.out.println(menu);
        return scanner.nextInt();
    }

    public Integer sortByParam() {
        String menu = """
                Choose a parameter:
                1. Price
                2. Color
                3. Arrival Date
                4. Exit
                """;
        System.out.println(menu);
        return scanner.nextInt();
    }

    public void displayAllWatches(List<Watch> watches) {
        System.out.println("_".repeat(67));
        System.out.printf("|%-12s| %-10s| %-10s| %-10s| %-10s| %-10s|%n", "Brand", "Model", "Color", "Type", "Price", "Arrival Date");
        System.out.printf("|%-12s|%-10s|%-10s|%-10s|%-10s|%-10s|%n", "_".repeat(12), "_".repeat(11), "_".repeat(11), "_".repeat(11), "_".repeat(11), "_".repeat(11));
        watches.forEach(w -> System.out.printf("|%-12s| %-25s| %-10s| %-10s| %-10s| %-10s|%n", w.getBrand(), w.getModel(), w.getColor(), w.getType(), w.getPrice(), w.getArrivalDate()));
        System.out.println("|" + "_".repeat(65) + "|");
    }

    public void displayTotalCost(Double totalCost) {
        String message = """
                Total cost:
                %.2f
                """.formatted(totalCost);
        System.out.println(message);
    }

    public Watch addNewWatch() {
        System.out.println("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.println("Enter Model: ");
        String model = scanner.nextLine();

        System.out.println("Enter Color (WHITE, SILVER, GOLD, BLUE, RED, BLACK): ");
        String color = scanner.nextLine();

        System.out.println("Enter Type (QUARTZ, MECHANICAL, SOLAR, SMART): ");
        String type = scanner.nextLine();

        System.out.println("Enter Price: ");
        Double price = scanner.nextDouble();

        System.out.println("Enter Arrival Date (YYYY-MM-DD): ");
        String arrivalDate = scanner.nextLine();

        return Watch.builder()
                .brand(brand)
                .model(model)
                .color(Color.valueOf(color))
                .type(WatchType.valueOf(type))
                .price(price)
                .arrivalDate(LocalDate.parse(arrivalDate))
                .build();
    }

}
