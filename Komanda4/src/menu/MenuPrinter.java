package menu;

import classfillers.Filling;
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
        String choose = Util.readMessage();
        MenuHandler.mainMenuHandler(choose);
    }

    public static void classMenu() {
        String choose = null;
        try {
            writeMessage("Выберите класс");
            writeMessage("1-User");
            writeMessage("2-Product");
            writeMessage("3-Выход");
            choose = Util.readMessage();
            MenuHandler.classMenuHandler(choose);
        } catch (ReadWriteException e) {
            writeMessage(e.toString());
            classMenu();
        }
    }

    public static void fillMenu() {
        String choose = null;
        try {
            writeMessage("1-заполняем из консоли");
            writeMessage("2-рандомное заполнение");
            writeMessage("3-читаем из файла");
            writeMessage("4-Выход");
            choose = Util.readMessage();
            MenuHandler.fillMenuHandler(choose);
        } catch (ReadWriteException e) {
            writeMessage(e.toString());
            MenuPrinter.fillMenu();
        }
    }

    public static int amountMenu() {
        String choose = null;
        try {
            writeMessage("1-Указать количество элементов коллекции");
            writeMessage("2-Выход");
            choose = Util.readMessage();
            return MenuHandler.amountMenuHandler(choose);
        } catch (ReadWriteException e) {
            writeMessage(e.toString());
            MenuPrinter.amountMenu();
            return 0;
        }
    }
}
