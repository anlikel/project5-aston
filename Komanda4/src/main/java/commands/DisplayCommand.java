package commands;

import exceptions.ReadWriteException;
import menu.MenuPrinter;
import utils.Holder;
import utils.Util;

public class DisplayCommand implements Command{
    @Override
    public void execute() {
            MenuPrinter.displayMenuPrinter();
    }
}
