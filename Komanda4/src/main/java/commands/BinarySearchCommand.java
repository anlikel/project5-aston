package commands;

import menu.SortMenuPrinter;

public class BinarySearchCommand implements Command{
    @Override
    public void execute() {
        SortMenuPrinter.binarySearchMenu();
    }
}
