package menu;

import commands.CommandFactory;
import controller.Controller;
import enums.Action;
import exceptions.ReadWriteException;
import model.Model;
import utils.Holder;

import java.util.List;

import static utils.Util.writeMessage;

public class SortMenuHandler {
    public static void mainSortMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        Model model= controller.getModel();
        switch(choose){
            case "1":
                List list=model.getList();
                list.sort(null);
                model.setList(list);
                controller.setModel(model);
                break;
            case "2":
                writeMessage("2-Сортировка по выбору (Comparator)");
                break;
            case "3":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            default:
                throw new ReadWriteException("исключение: некоректный выбор пункта меню");
        }
    }
}
