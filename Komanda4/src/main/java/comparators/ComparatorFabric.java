package comparators;

import enums.ClassTags;
import exceptions.ReadWriteException;
import java.util.Comparator;
import java.util.HashMap;

public class ComparatorFabric {
    private static HashMap<ClassTags,Comparator>map;

    public static Comparator getComparator(ClassTags tag) throws ReadWriteException {
        if(map==null){
            initMap();
        }
        return map.get(tag);
    }

    private static void initMap() throws ReadWriteException {
        map=new HashMap<>();
        map.put(ClassTags.PRODUCT,new ProductComparator());
        map.put(ClassTags.USER,new UserComparator());
        map.put(ClassTags.FLIGHT,new FlightComparator());
        map.put(ClassTags.HOTEL,new HotelComparator());
    }
}
