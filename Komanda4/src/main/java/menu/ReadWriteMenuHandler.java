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
import utils.*;

import java.util.List;

public class ReadWriteMenuHandler {
    public static void mainReadMenuHandler(String choose) throws ReadWriteException {
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
        Holder.getController().setTempList(list);
    }

    public static void mainWriteMenuHandler(String choose,List list) throws ReadWriteException {
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                ReadWriteMenuPrinter.mainWriteTargetMenu();
                String choose1= Util.readMessage();
                ReadWriteMenuHandler.mainWriteTargetMenuHandlerRewrite(choose1,list);
                break;
            case "2":
                ReadWriteMenuPrinter.mainWriteTargetMenu();
                String choose2= Util.readMessage();
                ReadWriteMenuHandler.mainWriteTargetMenuHandlerAppend(choose2,list);
                break;
            default:
                Util.writeMessage("некорректный выбор пункта меню");
                ReadWriteMenuPrinter.mainReadMenu();
        }
    }

    public static void mainWriteTargetMenuHandlerRewrite(String choose,List list) throws ReadWriteException {
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                String file1= Holder.listFile;
                FileObjectSave.saveListToFile(file1,list);
                break;
            case "2":
                Util.writeMessage("введите имя файла для чтения");
                String file2= Util.readMessage();
                //проверить файл корректность
                FileObjectSave.saveListToFile(file2,list);
                break;
            default:
                Util.writeMessage("некорректный выбор пункта меню");
                ReadWriteMenuPrinter.mainReadMenu();
        }
    }

    public static void mainWriteTargetMenuHandlerAppend(String choose,List list) throws ReadWriteException {
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                String file1= Holder.listFile;
                FileObjectSave.saveListToFileWithAppend(file1,list);
                break;
            case "2":
                Util.writeMessage("введите имя файла для чтения");
                String file2= Util.readMessage();
                //проверить файл корректность
                FileObjectSave.saveListToFileWithAppend(file2,list);
                break;
            default:
                Util.writeMessage("некорректный выбор пункта меню");
                ReadWriteMenuPrinter.mainReadMenu();
        }
    }

    public static void objectWriteMenuHandler(String choose) throws ReadWriteException {
        String choose2;
        List list;
        Controller controller=Holder.getController();
        switch(choose){
            case "0":
                CommandFactory.getCommand(Action.EXIT).execute();
                break;
            case "1":
                ReadWriteMenuPrinter.mainWriteMenu();
                choose2=Util.readMessage();
                list=controller.getList();
                Validator.checkList(list);
                mainWriteMenuHandler(choose2,list);
                break;
            case "2":
                ReadWriteMenuPrinter.mainWriteMenu();
                choose2=Util.readMessage();
                list=controller.getElementList();
                Validator.checkList(list);
                mainWriteMenuHandler(choose2,list);
                break;
            case "3":
                ReadWriteMenuPrinter.mainWriteMenu();
                choose2=Util.readMessage();
                list=controller.getFoundedList();
                Validator.checkList(list);
                mainWriteMenuHandler(choose2,list);
                break;
            default:
                Util.writeMessage("некорректный выбор пункта меню");
                ReadWriteMenuPrinter.objectWriteMenu();
        }
    }
}
