package commands;

import exceptions.ReadWriteException;
import menu.MenuPrinter;
import utils.Util;

public class CreateCommand implements Command{
    @Override
    public void execute() {
            MenuPrinter.classMenu();
    }
}
