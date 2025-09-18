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

    public static String readName() throws ReadWriteException{
        while (true) {
            try {
                String name = bufferedReader.readLine();
                if(name.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidName(name)) {
                    return name;
                } else {
                    throw new IOException("некорректное имя");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("Имя с большой буквы");
            }
        }
    }

    public static String readCity() throws ReadWriteException{
        while (true) {
            try {
                String city = bufferedReader.readLine();
                if(city.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidCity(city)) {
                    return city;
                } else {
                    throw new IOException("некорректное название города");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("Город с большой буквы");
            }
        }
    }

    public static String readTitle() throws ReadWriteException{
        while (true) {
            try {
                String title = bufferedReader.readLine();
                if(title.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidTitle(title)) {
                    return title;
                } else {
                    throw new IOException("некорректное название");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
            }
        }
    }

    public static String readDate() throws ReadWriteException{
        while (true) {
            try {
                String date = bufferedReader.readLine();
                if(date.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidDate(date)) {
                    return date;
                } else {
                    throw new IOException("некорректная дата");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("дата в формате dd.MM.yyyy HH:mm");
            }
        }
    }

    public static String readEmail() throws ReadWriteException{
        while (true) {
            try {
                String eml = bufferedReader.readLine();
                if(eml.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidEmail(eml)) {
                    return eml;
                } else {
                    throw new IOException("некорректная почта");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
            }
        }
    }

    public static String readAge() throws ReadWriteException{
        while (true) {
            try {
                String age = bufferedReader.readLine();
                if(age.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidAge(age)) {
                    return age;
                } else {
                    throw new IOException("некорректный возраст");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("возраст от 0 до 100");
            }
        }
    }

    public static String readQuantity() throws ReadWriteException{
        while (true) {
            try {
                String q = bufferedReader.readLine();
                if(q.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidQuantity(q)) {
                    return q;
                } else {
                    throw new IOException("некорректное число");
                }
            } catch (IOException  e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
            }
        }
    }

    public static String readPrice() throws ReadWriteException{
        while (true) {
            try {
                String p = bufferedReader.readLine();
                if(p.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidPrice(p)) {
                    return p;
                } else {
                    throw new IOException("некорректное число");
                }
            } catch (IOException e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("нужно дробное число");
            }
        }
    }

    public static String readRating() throws ReadWriteException{
        while (true) {
            try {
                String r = bufferedReader.readLine();
                if(r.equals("exit")){throw new ReadWriteException("вышли в предыдущее меню");}
                if (Validator.isValidRating(r)) {
                    return r;
                } else {
                    throw new IOException("некорректное число");
                }
            } catch (IOException  e) {
                Util.writeMessage("исключение: неправильный ввод данных повторите");
                Util.writeMessage("нужно дробное число от 0 до 5");
            }
        }
    }

}
