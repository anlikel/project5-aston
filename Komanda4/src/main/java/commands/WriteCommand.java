package commands;

import exceptions.ReadWriteException;
import menu.ReadWriteMenuHandler;
import menu.ReadWriteMenuPrinter;
import utils.Util;

public class WriteCommand implements Command {
    @Override
    public void execute() {
        ReadWriteMenuPrinter.objectWriteMenu();
    }
}
