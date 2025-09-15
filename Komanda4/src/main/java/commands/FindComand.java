package commands;

import classes.Product;
import classes.User;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import multiFind.FindCountElements;
import utils.Holder;

import java.util.List;

public class FindComand  implements Command{
    @Override
    public void execute() throws ReadWriteException {
        //Логика для получения элемента

        // var el = Holder.getController().getModel().getTag();
        User element= null;//заглушка
        List<User> userList = null;
        try {
            FindCountElements.find(userList, element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
