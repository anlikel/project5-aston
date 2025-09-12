package commands;

import utils.Holder;
import utils.Util;

public class DisplayCommand implements Command{
    @Override
    public void execute() {
        Util.writeMessage("************************************************");
        Holder.getController().getModel().getList().forEach(System.out::println);
        Util.writeMessage("************************************************");
    }
}
