package menu;

import classes.Flight;
import classes.Hotel;
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
import multiFind.FindCountElements;
import utils.Holder;
import utils.Util;

import java.util.List;

public class FindMenuHandler {
    public static void mainFindMenuHandler(String choose) throws ReadWriteException {
        Controller controller=Holder.getController();
        List list=controller.getList();
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                List elementList=controller.getElementList();
                if(elementList==null){
                    throw new ReadWriteException("Исключение: элемен в модели отсутствует");
                }
                try {
                    FindCountElements.find(list,elementList.get(0));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "2":
                Model model=controller.getModel();
                if(model==null){
                    throw new ReadWriteException("Исключение: Сначала необходимо создать коллекцию для поиска");
                }
                ClassTags tag=controller.getTag();
                Filling filling = FillingFactory.getFiller(tag);
                List element = filling.manualFill(1);
                Util.writeMessage(String.format("элемент %s успешно создан", element.get(0)));
                try {
                    FindCountElements.find(list,element.get(0));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                Util.writeMessage("выбран некорректный пункт меню");
                FindMenuPrinter.mainFindMenu();
        }
    }
}
