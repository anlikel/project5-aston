package commands;

import menu.SortMenuPrinter;

public class SortCommand implements Command{
    @Override
    public void execute() {
        SortMenuPrinter.mainSortMenu();
    }
}
