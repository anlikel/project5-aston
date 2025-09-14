package menu;

import exceptions.ReadWriteException;
import utils.Util;

import java.util.List;

public class ReadWriteMenuPrinter {
    public static void mainReadMenu() throws ReadWriteException {
        Util.writeMessage("0-Выход");
        Util.writeMessage("1-Чтение из файла по умолчанию");
        Util.writeMessage("2-Чтение из определенного файла");
    }
}
