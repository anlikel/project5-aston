package menu;

import classes.Product;
import classes.User;
import classfillers.Filling;
import classfillers.FillingFactory;
import commands.CommandFactory;
import controller.Controller;
import enums.Action;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import utils.Holder;
import utils.Util;

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
            default:
                MenuPrinter.mainMenu();
        }
    }

    public static void classMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        switch(choose){
            case "1":
                controller.setModel(new <User>Model(ClassTags.USER));
                MenuPrinter.fillMenu();
                break;
            case "2":
                controller.setModel(new <Product>Model(ClassTags.PRODUCT));
                MenuPrinter.fillMenu();
                break;
            case "3":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            default:
                MenuPrinter.classMenu();
        }
    }

    public static void fillMenuHandler(String choose) throws ReadWriteException {
        int size=0;
        ClassTags tag=Holder.getController().getModel().getTag();
        Filling filling= FillingFactory.getFiller(tag);
        Model model=Holder.getController().getModel();
        switch(choose){
            case "1":
                size=MenuPrinter.amountMenu();
//                Util.writeMessage("*************");
//                filling.manualFill(size).forEach(System.out::println);
//                Util.writeMessage("*************");
                model.setList(filling.manualFill(size));
                Holder.getController().setModel(model);
                Util.writeMessage("Коллекция успешно создана");
                break;
            case "2":
                size=MenuPrinter.amountMenu();
//                Util.writeMessage("*************");
//                filling.randomFill(size).forEach(System.out::println);
//                Util.writeMessage("*************");
                model.setList(filling.randomFill(size));
                Holder.getController().setModel(model);
                Util.writeMessage("Коллекция успешно создана");
                break;
            case "3":
//                Util.writeMessage("*************");
//                filling.autoFill().forEach(System.out::println);
//                Util.writeMessage("*************");
                model.setList(filling.autoFill());
                Holder.getController().setModel(model);
                Util.writeMessage("Коллекция успешно создана");
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
                    //нужна проверка на отрицатедьный ввод элементов коллекции
                }
                catch (Exception e){
                    throw new ReadWriteException("некорректно введено количество элементов коллекции");
                }
            case "2":
                CommandFactory.getCommand(Action.EXIT);
        }
        return amount;
    }


}
