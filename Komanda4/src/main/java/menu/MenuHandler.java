package menu;

import classes.Flight;
import classes.Hotel;
import classes.Product;
import classes.User;
import classfillers.Filling;
import classfillers.FillingFactory;
import classfillers.UniversalFiller;
import commands.CommandFactory;
import controller.Controller;
import enums.Action;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import utils.Holder;
import utils.Util;

import java.io.IOException;
import java.util.List;

public class MenuHandler {
    public static void mainMenuHandler(String choose) throws ReadWriteException {
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                CommandFactory.getCommand(Action.CREATE).execute();
                break;
            case "2":
                CommandFactory.getCommand(Action.SORT).execute();
                break;
            case "3":
                CommandFactory.getCommand(Action.BINARY_SEARCH).execute();
                break;
            case "4":
                CommandFactory.getCommand(Action.WRITE).execute();
                break;
            case "5":
                CommandFactory.getCommand(Action.DISPLAY).execute();
                break;
            case "6":
                CommandFactory.getCommand(Action.FIND).execute();
                break;
            case "7":
                CommandFactory.getCommand(Action.CREATE_ELEMENT).execute();
                break;
            default:
                MenuPrinter.mainMenu();
        }
    }

    public static void classMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                controller.setModel(new <User>Model(ClassTags.USER));
                MenuPrinter.fillMenu();
                break;
            case "2":
                controller.setModel(new <Product>Model(ClassTags.PRODUCT));
                MenuPrinter.fillMenu();
                break;
            case "3":
                controller.setModel(new <Flight>Model(ClassTags.FLIGHT));
                MenuPrinter.fillMenu();
                break;
            case "4":
                controller.setModel(new <Hotel>Model(ClassTags.HOTEL));
                MenuPrinter.fillMenu();
                break;
            default:
                MenuPrinter.classMenu();
        }
    }

    public static void fillMenuHandler(String choose) throws ReadWriteException {
        int size=0;
        ClassTags tag=Holder.getController().getTag();
        Filling filling= FillingFactory.getFiller(tag);
        Controller controller=Holder.getController();
        UniversalFiller universalFiller=new UniversalFiller(filling);
        switch(choose){
            case "1":
                size=MenuPrinter.amountMenu();
                controller.setList(universalFiller.manualFill(size));
//                Util.writeMessage("Коллекция успешно создана");
                break;
            case "2":
                size=MenuPrinter.amountMenu();
                controller.setList(universalFiller.randomFill(size));
//                Util.writeMessage("Коллекция успешно создана");
                break;
            case "3":
                controller.setList(universalFiller.autoFill());
//                Util.writeMessage("Коллекция успешно создана");
                break;
            case "4":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            default:
                MenuPrinter.fillMenu();
        }
    }

    public static int amountMenuHandler(String choose) throws ReadWriteException {
        int amount=0;
        Util.writeMessage("введите количество объектов");
        switch(choose){
            case "1":
                String number=Util.readMessage();
                try {
                    amount=Integer.parseInt(number);
                    if(amount<0){
                        throw new IOException();
                    }
                }
                catch (Exception e){
                    throw new ReadWriteException("некорректно введено количество элементов коллекции");
                }
            case "2":
                CommandFactory.getCommand(Action.EXIT);
        }
        return amount;
    }

    public static void  displayMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        if(controller.getModel()==null){
            Util.writeMessage("исключение: модель не инициализирована");
            return;
        }
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                Util.writeMessage("************************************************");
                List list=controller.getList();
                if(list==null || list.isEmpty())
                {
                    Util.writeMessage("исключение: коллекция не создана или пуста");
                    return;
                }
                list.forEach(System.out::println);
                Util.writeMessage("************************************************");
                break;
            case "2":
                Util.writeMessage("************************************************");
                List elementList=Holder.getController().getElementList();
                if(elementList==null || elementList.isEmpty())
                {
                    Util.writeMessage("исключение: элемент отсутствует");
                    return;
                }
                elementList.forEach(System.out::println);
                Util.writeMessage("************************************************");
                break;
            case "3":
                Util.writeMessage("************************************************");
                List foundedList=controller.getFoundedList();
                if(foundedList==null || foundedList.isEmpty())
                {
                    Util.writeMessage("исключение: нет найденных элементов отсутствует");
                    return;
                }
                foundedList.forEach(System.out::println);
                Util.writeMessage("************************************************");
                break;
            default:
                throw new ReadWriteException("некорректный выбор пункта меню");
        }
    }

}
