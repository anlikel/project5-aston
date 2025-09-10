package utils;



import classes.Product;
import classes.User;
import classfillers.Filling;
import classfillers.ProductFilling;
import classfillers.UserFilling;
import commands.Action;
import commands.CommandFactory;
import controller.Controller;
import exceptions.ReadWriteException;
import model.Model;


import java.util.List;

public class MenuHandler {
    public static void mainMenuHandler(String choose) throws ReadWriteException {
        switch(choose){
            case "1":
                Util.classMenu();
                break;
            case "2":
                CommandFactory.getCommand(Action.Exit);
                break;
            default:
                Util.mainMenu();
        }
    }

    public static void classMenuHandler(String choose) throws ReadWriteException {
        Controller controller=Holder.getController();
        switch(choose){
            case "1":
                controller.setModel(new <User>Model());
                Util.fillMenu(new UserFilling());
                break;
            case "2":
                controller.setModel(new <Product>Model());
                Util.fillMenu(new ProductFilling());
                break;
            case "3":
                CommandFactory.getCommand(Action.Exit);
                break;
            default:
                Util.classMenu();
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
                }
                catch (Exception e){
                    Util.amountMenu();
                }
            case "2":
                CommandFactory.getCommand(Action.Exit);
        }
        return amount;
    }

    public static void fillMenuHandler(String choose, Filling filling) throws ReadWriteException {
        int size=0;
        Model model;
        switch(choose){
            case "1":
                size=Util.amountMenu();
//                Util.writeMessage("*************");
//                filling.manualFill(size).forEach(System.out::println);
//                Util.writeMessage("*************");
                model=Holder.getController().getModel();
                model.setList(filling.manualFill(size));
                Holder.getController().setModel(model);
                break;
            case "2":
                size=Util.amountMenu();
//                Util.writeMessage("*************");
//                filling.randomFill(size).forEach(System.out::println);
//                Util.writeMessage("*************");
                model=Holder.getController().getModel();
                model.setList(filling.randomFill(size));
                Holder.getController().setModel(model);
                break;
            case "3":
//                Util.writeMessage("*************");
//                filling.autoFill().forEach(System.out::println);
//                Util.writeMessage("*************");
                model=Holder.getController().getModel();
                model.setList(filling.autoFill());
                Holder.getController().setModel(model);
                break;
            case "4":
                CommandFactory.getCommand(Action.Exit);
                break;
            default:
                Util.fillMenu(filling);
        }
    }
}
