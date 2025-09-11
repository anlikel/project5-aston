package commands;


import controller.Controller;

public class CommandFactory {
    private static Controller controller;

    public static Command getCommand(Action action) {
        Command command = null;
        switch (action) {
            case Exit:
                command = new ExitCommand();
                command.execute();
                break;
        }
        return command;
    }

    public static void setController(Controller controller) {
        CommandFactory.controller = controller;
    }
}
