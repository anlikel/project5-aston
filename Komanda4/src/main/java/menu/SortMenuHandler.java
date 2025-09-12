package menu;

import commands.CommandFactory;
import comparators.ComparatorFabric;
import comparators.Filter;
import controller.Controller;
import enums.Action;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import utils.Holder;

import java.util.Comparator;
import java.util.List;

import static utils.Util.writeMessage;

public class SortMenuHandler {
    public static void mainSortMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        Model model= controller.getModel();
        List list=model.getList();
        switch(choose){
            case "1":
                list.sort(null);
                model.setList(list);
                controller.setModel(model);
                break;
            case "2":
                ClassTags tag=model.getTag();
                Comparator comp=ComparatorFabric.getComparator(tag);
                Filter f=(Filter)comp;
                f.setFilter();
                list.sort((Comparator)f);
                model.setList(list);
                controller.setModel(model);
                break;
            case "3":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            default:
                throw new ReadWriteException("исключение: некоректный выбор пункта меню");
        }
    }
}
