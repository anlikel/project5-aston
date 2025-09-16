package commands;

import exceptions.ReadWriteException;
import menu.MenuPrinter;
import menu.SortMenuPrinter;
import utils.Holder;
import utils.Util;

import java.util.List;

public class SortCommand implements Command{
    @Override
    public void execute() {
        try {
            if (Holder.getController().getModel() == null) {
                throw new ReadWriteException("исключение: модель не инициализирована");
            }
            List list = Holder.getController().getList();
            if (list == null || list.isEmpty()) {
                throw new ReadWriteException("исключение: лист пустой нечего сортировать");
            }
        }
        catch(ReadWriteException e){
            Util.writeMessage(e.getMessage().toString());
            MenuPrinter.mainMenu();
        }
        SortMenuPrinter.mainSortMenu();
    }
}
