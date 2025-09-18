package utils;

import controller.Controller;

public class Holder {
    private static Controller controller;
    public static String flightsFile="src/main/resources/flight.txt";
    public static String productsFile="src/main/resources/product.txt";
    public static String usersFile="src/main/resources/user.txt";
    public static String hotelsFile="src/main/resources/hotel.txt";
    public static String listFile="src/main/resources/list.txt";

    public static Controller getController() {
        return controller;
    }
    public static void setController(Controller controller) {
        Holder.controller = controller;
    }
}
