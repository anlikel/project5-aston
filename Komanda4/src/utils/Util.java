package utils;



import classfillers.Filling;
import exceptions.ReadWriteException;
import menu.MenuHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    private static BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readMessage() throws ReadWriteException {
        String str=null;
        try{
            str=bufferedReader.readLine();
        } catch (IOException e) {
            throw new ReadWriteException("исключение: ошибка чтения из консоли");
        }
        return str;
    }

    public static void mainMenu() throws ReadWriteException {
        writeMessage("1-Выберите класс");
        writeMessage("2-Выход");
        String choose=Util.readMessage();
        MenuHandler.mainMenuHandler(choose);
    }

    public static void classMenu() throws ReadWriteException {
        writeMessage("1-User");
        writeMessage("2-Product");
        writeMessage("2-Выход");
        String choose=Util.readMessage();
        MenuHandler.classMenuHandler(choose);
    }

    public static int amountMenu() throws ReadWriteException {
        writeMessage("1-продолжить");
        writeMessage("2-Выход");
        String choose=Util.readMessage();
        return MenuHandler.amountMenuHandler(choose);
    }

    public static void fillMenu(Filling filler) throws ReadWriteException {
        writeMessage("1-заполняем из консоли");
        writeMessage("2-рандомное заполнение");
        writeMessage("3-читаем из файла");
        writeMessage("4-Выход");
        String choose=Util.readMessage();
        MenuHandler.fillMenuHandler(choose,filler);
    }

}
