package utils;

import controller.Controller;

public class Holder {
    private static Controller controller;

    public static Controller getController() {
        return controller;
    }
    public static void setController(Controller controller) {
        Holder.controller = controller;
    }
}
