package utils;


import controller.Controller;
import model.Model;

public class Holder {
    private static Controller controller;
    private static Model model;

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        Holder.controller = controller;
    }

    public static Model getModel() {
        return model;
    }

    public static void setModel(Model model) {
        Holder.model = model;
    }
}
