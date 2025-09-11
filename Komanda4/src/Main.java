import controller.Controller;
import exceptions.ReadWriteException;
import utils.Holder;
import utils.Util;
import view.View;

public class Main
{
    private Controller controller;
    private View view;

    public Main(Controller controller,View view){
        this.controller=controller;
        this.view=view;
    }

    public static void main( String[] args ) throws ReadWriteException {
        Controller controller=new Controller();
        View view=new View(controller);
        Main main=new Main(controller,view);
        Holder.setController(controller);
        try {
            main.start();
        }catch (NullPointerException e){
            // new ReadWriteException("");
            e.printStackTrace();
        }


    }

    public void start() throws ReadWriteException {
        view.printMenu();
        Util.writeMessage("method main*************");
        controller.getModel().getList().forEach(System.out::println);
        Util.writeMessage("method*************");
    }
}