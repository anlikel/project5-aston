package commands;

import exceptions.ReadWriteException;
import menu.ReadWriteMenuHandler;
import menu.ReadWriteMenuPrinter;
import utils.Util;

import java.util.List;

public class ReadCommand implements Command{
    private List list;
    @Override
    public void execute() throws ReadWriteException {
        ReadWriteMenuPrinter.mainReadMenu();
        String choose=Util.readMessage();
        list=ReadWriteMenuHandler.mainReadMenuHandler(choose);
    }
    public List getList() {
        return list;
    }
}
