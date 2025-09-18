package menu;

import exceptions.ReadWriteException;
import utils.Util;

public class MenuPrinter {

    public static void mainMenu()  {
        String choose;
        try {
            Util.writeMessage("0-Выход");
            Util.writeMessage("1-Создать коллекцию");
            Util.writeMessage("2-Сортировать коллекцию");
            Util.writeMessage("3-Бинарный поиск по коллекции");
            Util.writeMessage("4-Запись в файл");
            Util.writeMessage("5-Печать");
            Util.writeMessage("6-Поиск количества совпадающих объектов в коллекции");
            Util.writeMessage("7-Создать отдельный элемент для поиска по коллекции");
            choose = Util.readMessage();
            MenuHandler.mainMenuHandler(choose);
        }
        catch(ReadWriteException e){
            Util.writeMessage(e.getMessage().toString());
            MenuPrinter.mainMenu();
        }
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
            Util.writeMessage(e.getMessage().toString());
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

    public static void displayMenuPrinter()  {
        String choose = null;
        try {
            Util.writeMessage("0-Выход");
            Util.writeMessage("1-Печать коллекции");
            Util.writeMessage("2-Печать элемента для поиска из модели");
            Util.writeMessage("3-Печать списка найденных совпадений");
            choose = Util.readMessage();
            MenuHandler.displayMenuHandler(choose);
        }
        catch (ReadWriteException e) {
            Util.writeMessage(e.getMessage().toString());
            MenuPrinter.mainMenu();
        }
    }
}
