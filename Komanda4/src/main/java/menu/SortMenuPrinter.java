package menu;

import exceptions.ReadWriteException;
import utils.Util;

public class SortMenuPrinter {
    public static void mainSortMenu(){
        String choose = null;
        try {
        Util.writeMessage("1-Сортировка natural order(Comparable)");
        Util.writeMessage("2-Сортировка по выбору (Comparator)");
        Util.writeMessage("3-Выход");
        choose = Util.readMessage();
        SortMenuHandler.mainSortMenuHandler(choose);
        } catch (ReadWriteException e) {
            Util.writeMessage(e.toString());
            SortMenuPrinter.mainSortMenu();
        }
    }
}
