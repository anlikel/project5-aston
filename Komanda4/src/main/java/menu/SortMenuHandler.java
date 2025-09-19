package menu;

import classfillers.FillingFactory;
import commands.CommandFactory;
import comparators.ComparatorFabric;
import comparators.ComparatorFabricParity;
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
        List list=controller.getList();
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                list.sort(null);
                controller.setList(list);
                break;
            case "2":
                ClassTags tag1=controller.getTag();
                Comparator comp1= ComparatorFabric.getComparator(tag1);
                Filter f1=(Filter)comp1;
                f1.setFilter();
                list.sort((Comparator)f1);
                controller.setList(list);
                break;
            case "3":
                ClassTags tag2=controller.getTag();
                Comparator comp2= ComparatorFabricParity.getComparator(tag2);
                list.sort(comp2);
                controller.setList(list);
                break;

            default:
                throw new ReadWriteException("исключение: некорректный выбор пункта меню");
        }
    }

    public static void binarySearchMenuHandler(String choose) throws ReadWriteException {
        Controller controller= Holder.getController();
        if(controller.getModel()==null){
            throw new ReadWriteException("исключение: модель не иницализирована");
        }
        List list=controller.getList();
        if(list==null){
            throw new ReadWriteException("исключение: список не создан");
        }
        if(list.isEmpty()){
            throw new ReadWriteException("исключение: список пуст");
        }
        Util.writeMessage("********************************************");
        Util.writeMessage("*******несортированный список объектов******");
        list.forEach(System.out::println);
        Util.writeMessage("********************************************");
        ClassTags tag=controller.getTag();
        int index=-1;
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
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
                throw new ReadWriteException("возврат в меню");
            case "2":
                Comparator comp= ComparatorFabric.getComparator(tag);
                Filter f=(Filter)comp;
                f.setFilter();
                list.sort((Comparator)f);
                Util.writeMessage("********************************************");
                Util.writeMessage("*******отсортированный список объектов******");
                list.forEach(System.out::println);
                Util.writeMessage("********************************************");
                List obj2=FillingFactory.getFiller(tag).manualFill(1);
                System.out.println("************Ищем объект"+obj2.get(0)+"****");
                index=BinarySearcher.binarySearch(obj2.get(0),list,comp);
                if(index>=0){
                    Util.writeMessage(String.format("номер найденного элемента %d",index));}
                else {
                    Util.writeMessage("элемент не найден");
                }
                throw new ReadWriteException("возврат в меню");
            default:
                throw new ReadWriteException("исключение: некоректный выбор пункта меню");
        }
    }
}
