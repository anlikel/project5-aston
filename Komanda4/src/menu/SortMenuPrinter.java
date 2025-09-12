package menu;

import exceptions.ReadWriteException;
import utils.Util;

import static utils.Util.writeMessage;

public class SortMenuPrinter {
    public static void mainSortMenu(){
        String choose = null;
        try {
        writeMessage("1-Сортировка natural order(Comparable)");
        writeMessage("2-Сортировка по выбору (Comparator)");
        writeMessage("3-Выход");
        choose = Util.readMessage();
        SortMenuHandler.mainSortMenuHandler(choose);
        } catch (ReadWriteException e) {
            writeMessage(e.toString());
            SortMenuPrinter.mainSortMenu();
        }
    }
}
