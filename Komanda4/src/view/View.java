package view;

import controller.Controller;
import exceptions.ReadWriteException;
import utils.Util;

public class View {
    private Controller controller;

    public View (Controller controller){
        this.controller=controller;
    }

    public void printMenu() throws ReadWriteException {
        Util.mainMenu();
    }
}
