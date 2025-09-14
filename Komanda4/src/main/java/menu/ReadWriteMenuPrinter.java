package menu;

import exceptions.ReadWriteException;
import utils.Util;


public class ReadWriteMenuPrinter {
    public static void mainReadMenu() throws ReadWriteException {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Чтение из файла по умолчанию");
        Util.writeMessage("2-Чтение из определенного файла");
    }

    public static void mainWriteMenu() throws ReadWriteException {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Перезапись файла");
        Util.writeMessage("2-Дозапись в конец файла");
    }

    public static void mainWriteTargetMenu() throws ReadWriteException {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Запись в файл по умолчанию");
        Util.writeMessage("2-Запись в определенный файл");
    }
}
