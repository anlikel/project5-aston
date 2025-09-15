package commands;

import menu.MenuPrinter;

public class CreateCommand implements Command{
    @Override
    public void execute() {
            MenuPrinter.classMenu();
    }
}
