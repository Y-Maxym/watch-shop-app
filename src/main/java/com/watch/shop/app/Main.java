package com.watch.shop.app;

import com.watch.shop.app.controller.MenuHandler;
import com.watch.shop.app.controller.WatchController;
import com.watch.shop.app.model.service.WatchService;
import com.watch.shop.app.model.service.WatchServiceImpl;
import com.watch.shop.app.view.WatchView;

public class Main {

    public static void main(String[] args) {
        WatchService service = new WatchServiceImpl();
        WatchView view = new WatchView();
        MenuHandler menuHandler = new MenuHandler(view);
        WatchController controller = new WatchController(service, view, menuHandler);

        controller.run();
    }
}
