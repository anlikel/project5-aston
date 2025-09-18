import controller.Controller;
import exceptions.ReadWriteException;
import menu.MenuPrinter;
import utils.Holder;

public class Program {
    private Controller controller;

    public Program(){
    }

    public void init (){
        controller=new Controller();
        Holder.setController(controller);
    }
    public void start() throws ReadWriteException {
        MenuPrinter.mainMenu();
    }
}
