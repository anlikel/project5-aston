package classfillers;

import enums.ClassTags;
import java.util.HashMap;

public class FillingFactory {
    private static HashMap<ClassTags,Filling> map;

    public static Filling getFiller(ClassTags tag){
        if(map==null){
            initFillerMap();
        }
        return map.get(tag);
    }

    private static void initFillerMap(){
        map=new HashMap<>();
        map.put(ClassTags.PRODUCT,new ProductFilling());
        map.put(ClassTags.USER,new UserFilling());
        map.put(ClassTags.FLIGHT,new FlightFilling());
    }
}
