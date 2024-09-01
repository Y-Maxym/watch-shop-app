package com.watch.shop.app.view;

import com.watch.shop.app.model.entity.Color;
import com.watch.shop.app.model.entity.MechanicalWatch;
import com.watch.shop.app.model.entity.MechanicalWatch.MechanicalWatchBuilder;
import com.watch.shop.app.model.entity.OS;
import com.watch.shop.app.model.entity.QuartzWatch;
import com.watch.shop.app.model.entity.QuartzWatch.QuartzWatchBuilder;
import com.watch.shop.app.model.entity.SmartWatch;
import com.watch.shop.app.model.entity.SmartWatch.SmartWatchBuilder;
import com.watch.shop.app.model.entity.SolarWatch;
import com.watch.shop.app.model.entity.SolarWatch.SolarWatchBuilder;
import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.entity.Watch.WatchBuilder;
import com.watch.shop.app.model.entity.WatchType;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static com.watch.shop.app.view.ViewConstants.END_SEPARATOR;
import static com.watch.shop.app.view.ViewConstants.FORMAT_HEADER;
import static com.watch.shop.app.view.ViewConstants.FORMAT_ROW;
import static com.watch.shop.app.view.ViewConstants.FORMAT_SEPARATOR;
import static com.watch.shop.app.view.ViewConstants.MENU;
import static com.watch.shop.app.view.ViewConstants.SORT_MENU;
import static com.watch.shop.app.view.ViewConstants.START_SEPARATOR;

public class WatchView {

    private final InputHandler inputHandler = new InputHandler();

    public String getUserChoice() {
        printMessage(MENU);

        return inputHandler.readLineFromConsole();
    }

    public String sortByParam() {
        printMessage(SORT_MENU);

        return inputHandler.readLineFromConsole();
    }

    public void displayAllWatches(List<Watch> watches) {
        printMessage(START_SEPARATOR);
        printFormattedMessage(FORMAT_HEADER, "Brand", "Model", "Color", "Type", "Price", "Arrival Date");
        printFormattedMessage(FORMAT_SEPARATOR, "_".repeat(12), "_".repeat(26), "_".repeat(11), "_".repeat(11), "_".repeat(11), "_".repeat(13));
        watches.forEach(w -> printFormattedMessage(FORMAT_ROW, w.getBrand(), w.getModel(), w.getColor(), w.getType(), w.getPrice(), w.getArrivalDate()));
        printMessage(END_SEPARATOR);
    }

    public void displayTotalCost(BigDecimal totalCost) {
        String message = """
                \nTotal cost:
                 %.2f""".formatted(totalCost);
        printMessage(message);
    }

    public Watch addNewWatch() {

        printMessage("Enter Brand:");
        String brand = inputHandler.readLineFromConsole();

        printMessage("Enter Model:");
        String model = inputHandler.readLineFromConsole();

        printMessage("Enter Color (WHITE, SILVER, GOLD, BLUE, RED, BLACK):");
        String color = inputHandler.readLineFromConsole().toUpperCase();

        printMessage("Enter Type (QUARTZ, MECHANICAL, SOLAR, SMART):");
        String type = inputHandler.readLineFromConsole().toUpperCase();

        printMessage("Enter Price: ");
        String price = inputHandler.readLineFromConsole();

        printMessage("Enter Arrival Date (YYYY-MM-DD):");
        String arrivalDate = inputHandler.readLineFromConsole();

        return createWatchBuilderByType(WatchType.valueOf(type))
                .brand(brand)
                .model(model)
                .color(Color.valueOf(color))
                .type(WatchType.valueOf(type))
                .price(new BigDecimal(price))
                .arrivalDate(LocalDate.parse(arrivalDate))
                .build();
    }

    public void printFormattedMessage(String message, Object... args) {
        System.out.printf(message, args);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private WatchBuilder<? extends Watch, ?> createWatchBuilderByType(WatchType type) {
        return switch (type) {
            case QUARTZ -> createQuartzWatchBuilder();
            case MECHANICAL -> createMechanicalWatchBuilder();
            case SOLAR -> createSolarWatchBuilder();
            case SMART -> createSmartWatchBuilder();
        };
    }

    private QuartzWatchBuilder<?, ?> createQuartzWatchBuilder() {
        printMessage("Does it have luminous hands? (true or false)");
        String luminousHands = inputHandler.readLineFromConsole();

        return QuartzWatch.builder()
                .luminousHands(Boolean.parseBoolean(luminousHands));
    }

    private MechanicalWatchBuilder<?, ?> createMechanicalWatchBuilder() {
        printMessage("How much power reserve (hours)?");
        String powerReserve = inputHandler.readLineFromConsole();

        printMessage("Is it automatic? (true or false)");
        String isAutomatic = inputHandler.readLineFromConsole();

        return MechanicalWatch.builder()
                .powerReserve(Integer.parseInt(powerReserve))
                .isAutomatic(Boolean.parseBoolean(isAutomatic));
    }

    private SolarWatchBuilder<?, ?> createSolarWatchBuilder() {
        printMessage("How long does it take to charge (hours)?");
        String charge = inputHandler.readLineFromConsole();

        return SolarWatch.builder()
                .maxChargeTime(Duration.ofHours(Long.parseLong(charge)));
    }

    private SmartWatchBuilder<?, ?> createSmartWatchBuilder() {
        printMessage("Does it have a heart rate monitor? (true or false)");
        String hasHeartRateMonitor = inputHandler.readLineFromConsole();

        printMessage("Enter OS (WEAR_OS, TIZEN_OS, WATCH_OS):");
        String os = inputHandler.readLineFromConsole().toUpperCase();

        return SmartWatch.builder()
                .hasHeartRateMonitor(Boolean.parseBoolean(hasHeartRateMonitor))
                .os(OS.valueOf(os));
    }
}