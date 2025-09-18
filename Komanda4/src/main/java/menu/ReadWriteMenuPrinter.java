package menu;

import exceptions.ReadWriteException;
import utils.Util;


public class ReadWriteMenuPrinter {
    public static void mainReadMenu() {
        String choose;
        try {
            Util.writeMessage("0-Выход");
            Util.writeMessage("1-Чтение из файла по умолчанию");
            Util.writeMessage("2-Чтение из определенного файла");
            choose = Util.readMessage();
            ReadWriteMenuHandler.mainReadMenuHandler(choose);
        }
        catch(ReadWriteException e){
            Util.writeMessage(e.getMessage().toString());
            MenuPrinter.mainMenu();
        }
    }

    public static void mainWriteMenu() {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Перезапись файла");
        Util.writeMessage("2-Дозапись в конец файла");
    }

    public static void mainWriteTargetMenu() {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Запись в файл по умолчанию");
        Util.writeMessage("2-Запись в определенный файл");
    }

    public static void objectWriteMenu() {
        String choose = null;
        try {
            Util.writeMessage("0-Выход");
            Util.writeMessage("1-Запись основной колекции");
            Util.writeMessage("2-Запись элемента из модели");
            Util.writeMessage("3-Запись найденных значений");
            choose = Util.readMessage();
            ReadWriteMenuHandler.objectWriteMenuHandler(choose);
        }
        catch (ReadWriteException e) {
            Util.writeMessage(e.getMessage().toString());
            MenuPrinter.mainMenu();
        }
    }
}
