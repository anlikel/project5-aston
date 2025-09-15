package commands;

import exceptions.ReadWriteException;
import menu.ReadWriteMenuHandler;
import menu.ReadWriteMenuPrinter;
import utils.Util;

public class WriteCommand implements commands.Command {
    @Override
    public void execute() throws ReadWriteException {
        ReadWriteMenuPrinter.mainWriteMenu();
        String choose= Util.readMessage();
        ReadWriteMenuHandler.mainWriteMenuHandler(choose);
    }
}
