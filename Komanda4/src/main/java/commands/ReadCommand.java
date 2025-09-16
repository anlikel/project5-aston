package commands;

import exceptions.ReadWriteException;
import menu.ReadWriteMenuHandler;
import menu.ReadWriteMenuPrinter;
import utils.Util;

import java.util.List;

public class ReadCommand implements Command{
    @Override
    public void execute() throws ReadWriteException {
        ReadWriteMenuPrinter.mainReadMenu();
        String choose=Util.readMessage();
        ReadWriteMenuHandler.mainReadMenuHandler(choose);
    }
}
