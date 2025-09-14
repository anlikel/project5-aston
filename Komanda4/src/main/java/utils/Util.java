package utils;

import enums.ClassTags;
import exceptions.ReadWriteException;

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

    public static String getFileName(){
        String filename = "";
        ClassTags tag=Holder.getController().getModel().getTag();
        switch (tag){
            case PRODUCT:
                filename=Holder.productsFile;
                break;
            case USER:
                filename=Holder.usersFile;
                break;
            case FLIGHT:
                filename=Holder.flightsFile;
                break;
        }
        return filename;
    }
}
