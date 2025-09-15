package commands;

import classes.Product;
import classes.User;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import multiFind.FindCountElements;
import utils.Holder;

public class FindComand  implements Command{
    @Override
    public void execute() throws ReadWriteException {
        //Логика для получения элемента

        // var el = Holder.getController().getModel().getTag();
        User element= null;//заглушка

        try {
            FindCountElements.find(element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
