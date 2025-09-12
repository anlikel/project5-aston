package commands;

import enums.Action;
import java.util.HashMap;

public class CommandFactory {
    private static HashMap<Action,Command>map;

    public static Command getCommand(Action action) {
        if(map==null)
        {
            initActionMap();
        }
        return map.get(action);
    }
    private static void initActionMap(){
        map=new HashMap<>();
        map.put(Action.EXIT,new ExitCommand());
        map.put(Action.CREATE,new CreateCommand());
        map.put(Action.SORT,new SortCommand());
        map.put(Action.BINARY_SEARCH,new BinarySearchCommand());
        map.put(Action.WRITE,new WriteCommand());
        map.put(Action.DISPLAY,new DisplayCommand());
    }


}
