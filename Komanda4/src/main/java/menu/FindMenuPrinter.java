package menu;

import exceptions.ReadWriteException;
import utils.Util;

public class FindMenuPrinter {
    public static void mainFindMenu() throws ReadWriteException {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Поиск по элементу из модели");
        Util.writeMessage("2-Поиск по своему элементу из модели");
        try {
            String choose = Util.readMessage();
            FindMenuHandler.mainFindMenuHandler(choose);
        }
        catch (ReadWriteException e){
            Util.writeMessage(e.getMessage().toString());
            mainFindMenu();
        }
    }
}
