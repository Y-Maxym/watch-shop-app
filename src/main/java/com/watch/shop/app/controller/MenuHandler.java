package com.watch.shop.app.controller;

import com.watch.shop.app.model.entity.Color;
import com.watch.shop.app.model.entity.MechanicalWatch;
import com.watch.shop.app.model.entity.MechanicalWatch.MechanicalWatchBuilder;
import com.watch.shop.app.model.entity.OperationSystem;
import com.watch.shop.app.model.entity.QuartzWatch;
import com.watch.shop.app.model.entity.QuartzWatch.QuartzWatchBuilder;
import com.watch.shop.app.model.entity.SmartWatch;
import com.watch.shop.app.model.entity.SmartWatch.SmartWatchBuilder;
import com.watch.shop.app.model.entity.SolarWatch;
import com.watch.shop.app.model.entity.SolarWatch.SolarWatchBuilder;
import com.watch.shop.app.model.entity.Watch;
import com.watch.shop.app.model.entity.Watch.WatchBuilder;
import com.watch.shop.app.model.entity.WatchType;
import com.watch.shop.app.view.WatchView;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static com.watch.shop.app.controller.MenuConstants.END_SEPARATOR;
import static com.watch.shop.app.controller.MenuConstants.FORMAT_HEADER;
import static com.watch.shop.app.controller.MenuConstants.FORMAT_ROW;
import static com.watch.shop.app.controller.MenuConstants.FORMAT_SEPARATOR;
import static com.watch.shop.app.controller.MenuConstants.MENU;
import static com.watch.shop.app.controller.MenuConstants.SORT_MENU;
import static com.watch.shop.app.controller.MenuConstants.START_SEPARATOR;
import static com.watch.shop.app.controller.MenuConstants.TOTAL_COST_MESSAGE;

@RequiredArgsConstructor
public class MenuHandler {

    private final WatchView watchView;
    private final InputHandler inputHandler = new InputHandler();

    public String printMainMenu() {
        watchView.printMessage(MENU);

        return inputHandler.readLineFromConsole();
    }

    public String printSortMenu() {
        watchView.printMessage(SORT_MENU);

        return inputHandler.readLineFromConsole();
    }

    public void displayAllWatches(List<Watch> watches) {
        watchView.printMessage(START_SEPARATOR);
        watchView.printFormattedMessage(FORMAT_HEADER, "Brand", "Model", "Color", "Type", "Price", "Arrival Date");
        watchView.printFormattedMessage(FORMAT_SEPARATOR, "_".repeat(13), "_".repeat(27), "_".repeat(12), "_".repeat(12), "_".repeat(12), "_".repeat(14));

        watches.forEach(w -> watchView.printFormattedMessage(FORMAT_ROW, w.getBrand(), w.getModel(), w.getColor(), w.getType(), w.getPrice(), w.getArrivalDate()));

        watchView.printMessage(END_SEPARATOR);
    }

    public void displayTotalCost(BigDecimal totalCost) {
        String message = TOTAL_COST_MESSAGE.formatted(totalCost);
        watchView.printMessage(message);
    }

    public Watch printNewWatchMenu() {
        watchView.printMessage("Enter Brand:");
        String brand = inputHandler.readLineFromConsole();

        watchView.printMessage("Enter Model:");
        String model = inputHandler.readLineFromConsole();

        watchView.printMessage("Enter Color (WHITE, SILVER, GOLD, BLUE, RED, BLACK):");
        String color = inputHandler.readLineFromConsole().toUpperCase();

        watchView.printMessage("Enter Type (QUARTZ, MECHANICAL, SOLAR, SMART):");
        String type = inputHandler.readLineFromConsole().toUpperCase();

        watchView.printMessage("Enter Price: ");
        String price = inputHandler.readLineFromConsole();

        watchView.printMessage("Enter Arrival Date (YYYY-MM-DD):");
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

    private WatchBuilder<?, ?> createWatchBuilderByType(WatchType type) {
        return switch (type) {
            case QUARTZ -> createQuartzWatchBuilder();
            case MECHANICAL -> createMechanicalWatchBuilder();
            case SOLAR -> createSolarWatchBuilder();
            case SMART -> createSmartWatchBuilder();
        };
    }

    private QuartzWatchBuilder<?, ?> createQuartzWatchBuilder() {
        watchView.printMessage("Does it have luminous hands? (true or false)");
        String luminousHands = inputHandler.readLineFromConsole();

        return QuartzWatch.builder()
                .hasLuminousHands(Boolean.parseBoolean(luminousHands));
    }

    private MechanicalWatchBuilder<?, ?> createMechanicalWatchBuilder() {
        watchView.printMessage("How much power reserve (hours)?");
        String powerReserve = inputHandler.readLineFromConsole();

        watchView.printMessage("Is it automatic? (true or false)");
        String isAutomatic = inputHandler.readLineFromConsole();

        return MechanicalWatch.builder()
                .powerReserve(Integer.parseInt(powerReserve))
                .isAutomatic(Boolean.parseBoolean(isAutomatic));
    }

    private SolarWatchBuilder<?, ?> createSolarWatchBuilder() {
        watchView.printMessage("How long does it take to charge (hours)?");
        String charge = inputHandler.readLineFromConsole();

        return SolarWatch.builder()
                .maxChargeTime(Duration.ofHours(Long.parseLong(charge)));
    }

    private SmartWatchBuilder<?, ?> createSmartWatchBuilder() {
        watchView.printMessage("Does it have a heart rate monitor? (true or false)");
        String hasHeartRateMonitor = inputHandler.readLineFromConsole();

        watchView.printMessage("Enter OS (WEAR_OS, TIZEN_OS, WATCH_OS):");
        String os = inputHandler.readLineFromConsole().toUpperCase();

        return SmartWatch.builder()
                .hasHeartRateMonitor(Boolean.parseBoolean(hasHeartRateMonitor))
                .operationSystem(OperationSystem.valueOf(os));
    }
}
