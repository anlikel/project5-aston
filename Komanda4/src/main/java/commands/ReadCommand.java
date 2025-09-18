package commands;

import exceptions.ReadWriteException;
import menu.ReadWriteMenuHandler;
import menu.ReadWriteMenuPrinter;
import utils.Util;

import java.util.List;

public class ReadCommand implements Command{
    @Override
    public void execute(){
        ReadWriteMenuPrinter.mainReadMenu();
    }
}
