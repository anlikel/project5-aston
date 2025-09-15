package commands;

import classes.Product;
import classes.User;
import controller.Controller;
import enums.ClassTags;
import exceptions.ReadWriteException;
import menu.FindMenuPrinter;
import model.Model;
import multiFind.FindCountElements;
import utils.Holder;

import java.util.List;

public class FindComand  implements Command{
    @Override
    public void execute() throws ReadWriteException {
        Controller controller= Holder.getController();
        Model model=controller.getModel();
        if(model==null){
            throw new ReadWriteException("Исключение: Сначала необходимо создать коллекцию для поиска");
        }
        FindMenuPrinter.mainFindMenu();
    }
}
