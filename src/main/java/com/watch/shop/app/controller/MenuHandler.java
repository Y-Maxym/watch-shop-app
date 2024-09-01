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
import com.watch.shop.app.view.InputHandler;
import com.watch.shop.app.view.WatchView;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;

import static com.watch.shop.app.util.Constants.END_SEPARATOR;
import static com.watch.shop.app.util.Constants.ENTER_ARRIVAL_DATE_MESSAGE;
import static com.watch.shop.app.util.Constants.ENTER_BRAND_MESSAGE;
import static com.watch.shop.app.util.Constants.ENTER_COLOR_MESSAGE;
import static com.watch.shop.app.util.Constants.ENTER_MODEL_MESSAGE;
import static com.watch.shop.app.util.Constants.ENTER_PRICE_MESSAGE;
import static com.watch.shop.app.util.Constants.ENTER_TYPE_MESSAGE;
import static com.watch.shop.app.util.Constants.FORMAT_HEADER;
import static com.watch.shop.app.util.Constants.FORMAT_ROW;
import static com.watch.shop.app.util.Constants.FORMAT_SEPARATOR;
import static com.watch.shop.app.util.Constants.HAS_HEART_RATE_MONITOR_MESSAGE;
import static com.watch.shop.app.util.Constants.IS_AUTOMATIC_MESSAGE;
import static com.watch.shop.app.util.Constants.LUMINOUS_HANDS_MESSAGE;
import static com.watch.shop.app.util.Constants.MAX_CHARGE_TIME_MESSAGE;
import static com.watch.shop.app.util.Constants.MENU;
import static com.watch.shop.app.util.Constants.OPERATION_SYSTEM_MESSAGE;
import static com.watch.shop.app.util.Constants.POWER_RESERVE_MESSAGE;
import static com.watch.shop.app.util.Constants.SEPARATOR;
import static com.watch.shop.app.util.Constants.SORT_MENU;
import static com.watch.shop.app.util.Constants.START_SEPARATOR;
import static com.watch.shop.app.util.Constants.TOTAL_COST_MESSAGE;

@RequiredArgsConstructor
public class MenuHandler {

    private static final String BRAND = "Brand";
    private static final String MODEL = "Model";
    private static final String COLOR = "Color";
    private static final String TYPE = "Type";
    private static final String PRICE = "Price";
    private static final String ARRIVAL_DATE = "Arrival Date";

    private final WatchView view;
    private final InputHandler inputHandler = new InputHandler();

    public String printMainMenu() {
        view.printMessage(MENU);

        return inputHandler.readLineFromConsole();
    }

    public String printSortMenu() {
        view.printMessage(SORT_MENU);

        return inputHandler.readLineFromConsole();
    }

    public void displayAllWatches(List<Watch> watches) {
        view.printMessage(START_SEPARATOR);
        view.printFormattedMessage(FORMAT_HEADER, BRAND, MODEL, COLOR, TYPE, PRICE, ARRIVAL_DATE);
        view.printFormattedMessage(FORMAT_SEPARATOR, SEPARATOR.repeat(13), SEPARATOR.repeat(27), SEPARATOR.repeat(12), SEPARATOR.repeat(12), SEPARATOR.repeat(12), SEPARATOR.repeat(14));

        watches.forEach(this::printFormattedWatch);

        view.printMessage(END_SEPARATOR);
    }

    public void displayTotalCost(BigDecimal totalCost) {
        view.printFormattedMessage(TOTAL_COST_MESSAGE, totalCost);
    }

    public Watch printNewWatchMenu() {
        view.printMessage(ENTER_BRAND_MESSAGE);
        String brand = inputHandler.readLineFromConsole();

        view.printMessage(ENTER_MODEL_MESSAGE);
        String model = inputHandler.readLineFromConsole();

        view.printFormattedMessage(ENTER_COLOR_MESSAGE, extractEnumValues(Color.class));
        String color = inputHandler.readLineFromConsole().toUpperCase();

        view.printFormattedMessage(ENTER_TYPE_MESSAGE, extractEnumValues(WatchType.class));
        String type = inputHandler.readLineFromConsole().toUpperCase();

        view.printMessage(ENTER_PRICE_MESSAGE);
        String price = inputHandler.readLineFromConsole();

        view.printMessage(ENTER_ARRIVAL_DATE_MESSAGE);
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

    private void printFormattedWatch(Watch watch) {
        view.printFormattedMessage(
                FORMAT_ROW,
                watch.getBrand(),
                watch.getModel(),
                watch.getColor(),
                watch.getType(),
                watch.getPrice(),
                watch.getArrivalDate());
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
        view.printMessage(LUMINOUS_HANDS_MESSAGE);
        String luminousHands = inputHandler.readLineFromConsole();

        return QuartzWatch.builder()
                .hasLuminousHands(Boolean.parseBoolean(luminousHands));
    }

    private MechanicalWatchBuilder<?, ?> createMechanicalWatchBuilder() {
        view.printMessage(POWER_RESERVE_MESSAGE);
        String powerReserve = inputHandler.readLineFromConsole();

        view.printMessage(IS_AUTOMATIC_MESSAGE);
        String isAutomatic = inputHandler.readLineFromConsole();

        return MechanicalWatch.builder()
                .powerReserve(Integer.parseInt(powerReserve))
                .isAutomatic(Boolean.parseBoolean(isAutomatic));
    }

    private SolarWatchBuilder<?, ?> createSolarWatchBuilder() {
        view.printMessage(MAX_CHARGE_TIME_MESSAGE);
        String charge = inputHandler.readLineFromConsole();

        return SolarWatch.builder()
                .maxChargeTime(Duration.ofHours(Long.parseLong(charge)));
    }

    private SmartWatchBuilder<?, ?> createSmartWatchBuilder() {
        view.printMessage(HAS_HEART_RATE_MONITOR_MESSAGE);
        String hasHeartRateMonitor = inputHandler.readLineFromConsole();

        view.printFormattedMessage(OPERATION_SYSTEM_MESSAGE, extractEnumValues(OperationSystem.class));
        String operationSystem = inputHandler.readLineFromConsole().toUpperCase();

        return SmartWatch.builder()
                .hasHeartRateMonitor(Boolean.parseBoolean(hasHeartRateMonitor))
                .operationSystem(OperationSystem.valueOf(operationSystem));
    }

    @SuppressWarnings("all")
    private <E extends Enum<E>> String extractEnumValues(Class<E> enumClass) {
        return EnumSet.allOf(enumClass).toString();
    }
}
