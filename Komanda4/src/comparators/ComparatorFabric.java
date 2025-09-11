package comparators;

import enums.ClassTags;

import java.util.Comparator;
import java.util.HashMap;

public class ComparatorFabric {
    private static HashMap<ClassTags,Comparator>map;

    public static Comparator getComparator(ClassTags tag){
        if(map==null){
            initMap();
        }
        return map.get(tag);
    }

    private static void initMap(){
        map=new HashMap<>();
        map.put(ClassTags.Product,new ProductComparator());
        map.put(ClassTags.User,new UserComparator());
    }
}
