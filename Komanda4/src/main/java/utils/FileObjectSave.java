package utils;

import java.util.List;

public class FileObjectSave {
    private String fileName="src/properties/list.txt";

    public static void saveListToFile(){

    }

    private static void getListFromModel(){
        List list=Holder.getController().getModel().getList();
    }
}
