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
            case HOTEL:
                filename=Holder.hotelsFile;
                break;
        }
        return filename;
    }

    //ридеры для полей классов

    public static String readName() {
        while (true) {
            try {
                String name = bufferedReader.readLine();
                if (Validator.isValidName(name)) {
                    return name;
                } else {
                    throw new ReadWriteException("некорректное имя");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("Имя с большой буквы");
            }
        }
    }

    public static String readCity() {
        while (true) {
            try {
                String city = bufferedReader.readLine();
                if (Validator.isValidCity(city)) {
                    return city;
                } else {
                    throw new ReadWriteException("некорректное название города");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("Город с большой буквы");
            }
        }
    }

    public static String readTitle() {
        while (true) {
            try {
                String title = bufferedReader.readLine();
                if (Validator.isValidTitle(title)) {
                    return title;
                } else {
                    throw new ReadWriteException("некорректное название");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
            }
        }
    }

    public static String readDate() {
        while (true) {
            try {
                String date = bufferedReader.readLine();
                if (Validator.isValidDate(date)) {
                    return date;
                } else {
                    throw new ReadWriteException("некорректная дата");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("дата в формате dd.MM.yyyy HH:mm");
            }
        }
    }

    public static String readEmail() {
        while (true) {
            try {
                String eml = bufferedReader.readLine();
                if (Validator.isValidEmail(eml)) {
                    return eml;
                } else {
                    throw new ReadWriteException("некорректная почта");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
            }
        }
    }

    public static String readAge() {
        while (true) {
            try {
                String age = bufferedReader.readLine();
                if (Validator.isValidAge(age)) {
                    return age;
                } else {
                    throw new ReadWriteException("некорректный возраст");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("возраст от 0 до 100");
            }
        }
    }

    public static String readQuantity() {
        while (true) {
            try {
                String q = bufferedReader.readLine();
                if (Validator.isValidQuantity(q)) {
                    return q;
                } else {
                    throw new ReadWriteException("некорректное число");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
            }
        }
    }

    public static String readPrice() {
        while (true) {
            try {
                String p = bufferedReader.readLine();
                if (Validator.isValidPrice(p)) {
                    return p;
                } else {
                    throw new ReadWriteException("некорректное число");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("нужно дробное число");
            }
        }
    }

    public static String readRating() {
        while (true) {
            try {
                String r = bufferedReader.readLine();
                if (Validator.isValidRating(r)) {
                    return r;
                } else {
                    throw new ReadWriteException("некорректное число");
                }
            } catch (IOException | ReadWriteException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("нужно дробное число от 0 до 5");
            }
        }
    }

}
