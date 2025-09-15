package menu;

import exceptions.ReadWriteException;
import utils.Util;

public class MenuPrinter {

    public static void mainMenu() throws ReadWriteException {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Создать коллекцию");
        Util.writeMessage("2-Сортировать коллекцию");
        Util.writeMessage("3-Бинарный поиск по коллекции");
        Util.writeMessage("4-Записать коллекцию в файл");
        Util.writeMessage("5-Распечать коллекцию на экран");
        String choose = Util.readMessage();
        MenuHandler.mainMenuHandler(choose);
    }

    public static void classMenu() {
        String choose = null;
        try {
            Util.writeMessage("Выберите класс");
            Util.writeMessage("0-Выход");
            Util.writeMessage("1-User");
            Util.writeMessage("2-Product");
            Util.writeMessage("3-Flight");
            Util.writeMessage("4-Hotel");
            choose = Util.readMessage();
            MenuHandler.classMenuHandler(choose);
        } catch (ReadWriteException e) {
            Util.writeMessage(e.toString());
            classMenu();
        }
    }

    public static void fillMenu() {
        String choose = null;
        try {
            Util.writeMessage("1-заполняем из консоли");
            Util.writeMessage("2-рандомное заполнение");
            Util.writeMessage("3-читаем из файла");
            Util.writeMessage("4-Выход");
            choose = Util.readMessage();
            MenuHandler.fillMenuHandler(choose);
        } catch (ReadWriteException e) {
            Util.writeMessage(e.toString());
            MenuPrinter.fillMenu();
        }
    }

    public static int amountMenu() {
        String choose = null;
        try {
            Util.writeMessage("1-Указать количество элементов коллекции");
            Util.writeMessage("2-Выход");
            choose = Util.readMessage();
            return MenuHandler.amountMenuHandler(choose);
        } catch (ReadWriteException e) {
            Util.writeMessage(e.toString());
            MenuPrinter.amountMenu();
            return 0;
        }
    }
}
