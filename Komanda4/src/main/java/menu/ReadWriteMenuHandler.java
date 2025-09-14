package menu;

import classes.Flight;
import classes.Product;
import classes.User;
import commands.CommandFactory;
import controller.Controller;
import enums.Action;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import utils.FileObjectLoad;
import utils.FileObjectSave;
import utils.Holder;
import utils.Util;

import java.util.List;

public class ReadWriteMenuHandler {
    public static List mainReadMenuHandler(String choose) throws ReadWriteException {
        List list=null;
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                String file= Util.getFileName();
                list= FileObjectLoad.getFileList(file);
                break;
            case "2":
                Util.writeMessage("введите имя файла для чтения");
                String file2= Util.readMessage();
                //проверить файл корректность
                list= FileObjectLoad.getFileList(file2);
                break;
            default:
                Util.writeMessage("некорректный выбор пункта меню");
                ReadWriteMenuPrinter.mainReadMenu();
        }
        return list;
    }

    public static void mainWriteMenuHandler(String choose) throws ReadWriteException {
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                String file1= Holder.listFile;
                FileObjectSave.saveListToFile(file1);
                break;
            case "2":
                Util.writeMessage("введите имя файла для чтения");
                String file2= Util.readMessage();
                //проверить файл корректность
                FileObjectLoad.getFileList(file2);
                break;
            default:
                Util.writeMessage("некорректный выбор пункта меню");
                ReadWriteMenuPrinter.mainReadMenu();
        }
    }

}
