package menu;

import classfillers.FillingFactory;
import commands.CommandFactory;
import comparators.ComparatorFabric;
import comparators.Filter;
import controller.Controller;
import enums.Action;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import utils.BinarySearcher;
import utils.Holder;
import utils.MyArrayListImpl;
import utils.Util;

import java.util.Comparator;
import java.util.List;

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
                Comparator comp= ComparatorFabric.getComparator(tag);
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

    public static void binarySearchMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        Model model= controller.getModel();
        List list=model.getList();
        Util.writeMessage("********************************************");
        Util.writeMessage("*******несортированный список объектов******");
        list.forEach(System.out::println);
        Util.writeMessage("********************************************");
        ClassTags tag=model.getTag();
//        List obj=List.of(list.get(5));
        int index=-1;
        switch(choose){
            case "1":
                list.sort(null);
                Util.writeMessage("********************************************");
                Util.writeMessage("*******отсортированный список объектов******");
                list.forEach(System.out::println);
                Util.writeMessage("********************************************");
                List obj=FillingFactory.getFiller(tag).manualFill(1);
                System.out.println("************Ищем объект"+obj.get(0)+"****");
                index=BinarySearcher.binarySearch(obj.get(0),list,null);
                Util.writeMessage("индекс "+index);
                if(index>=0){
                        Util.writeMessage(String.format("номер найденного элемента %d",index));}
                else {
                    Util.writeMessage("элемент не найден");
                }
                break;
            case "2":
                Comparator comp= ComparatorFabric.getComparator(tag);
                Filter f=(Filter)comp;
                f.setFilter();
                list.sort((Comparator)f);
                index=BinarySearcher.binarySearch(FillingFactory.getFiller(tag).manualFill(1).get(0),list,null);
                if(index>=0){
                    Util.writeMessage(String.format("номер найденного элемента %d",index));}
                else {
                    Util.writeMessage("элемент не найден");
                }
                break;
            case "3":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            default:
                throw new ReadWriteException("исключение: некоректный выбор пункта меню");
        }
    }
}
