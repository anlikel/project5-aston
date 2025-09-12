package menu;

import exceptions.ReadWriteException;
import utils.Util;

import static utils.Util.writeMessage;

public class MenuPrinter {

    public static void mainMenu() throws ReadWriteException {
        writeMessage("0-Выход");
        writeMessage("1-Создать коллекцию");
        writeMessage("2-Сортировать коллекцию");
        writeMessage("3-Бинарный поиск по коллекции");
        writeMessage("4-Записать коллекцию в файл");
        writeMessage("5-Распечать коллекцию на экран");
        String choose= Util.readMessage();
        MenuHandler.mainMenuHandler(choose);
    }
}
