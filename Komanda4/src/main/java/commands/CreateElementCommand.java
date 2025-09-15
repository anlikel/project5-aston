package commands;

import classfillers.Filling;
import classfillers.FillingFactory;
import controller.Controller;
import enums.ClassTags;
import exceptions.ReadWriteException;
import model.Model;
import utils.Holder;
import utils.Util;

import javax.swing.*;
import java.util.List;

public class CreateElementCommand implements Command{
    @Override
    public void execute() throws ReadWriteException {
        Controller controller= Holder.getController();
        Model model=controller.getModel();
        if(model==null){
            throw new ReadWriteException("Исключение: Сначала необходимо создать коллекцию для поиска");
        }
        ClassTags tag=model.getTag();
            Filling filling = FillingFactory.getFiller(tag);
            List element = filling.manualFill(1);
            model.setElementList(element);
            controller.setModel(model);
            Util.writeMessage(String.format("элемент %s успешно создан", element.get(0)));
    }
}
