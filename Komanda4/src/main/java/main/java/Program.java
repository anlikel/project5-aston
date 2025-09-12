package main.java;

import main.java.controller.Controller;
import main.java.exceptions.ReadWriteException;
import main.java.menu.MenuPrinter;
import main.java.utils.Holder;

public class Program {
    private Controller controller;

    public Program(){
    }

    public void init (){
        controller=new Controller();
        Holder.setController(controller);
    }
    public void start() throws ReadWriteException {
        MenuPrinter.mainMenu();
    }
}
