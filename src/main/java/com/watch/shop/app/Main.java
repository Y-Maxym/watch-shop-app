package com.watch.shop.app;

import com.watch.shop.app.controller.WatchController;
import com.watch.shop.app.service.WatchService;
import com.watch.shop.app.service.WatchServiceImpl;
import com.watch.shop.app.view.WatchView;

public class Main {

    public static void main(String[] args) {
        WatchService service = new WatchServiceImpl();
        WatchView view = new WatchView();
        WatchController controller = new WatchController(service, view);
        controller.run();
    }
}
