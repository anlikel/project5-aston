package comparators;

import enums.ClassTags;
import exceptions.ReadWriteException;

import java.util.Comparator;
import java.util.HashMap;

public class ComparatorFabricParity {
    private static HashMap<ClassTags, Comparator> map;

    public static Comparator getComparator(ClassTags tag){
        if(map==null){
            initMap();
        }
        return map.get(tag);
    }

    private static void initMap(){
        map=new HashMap<>();
        map.put(ClassTags.PRODUCT,new ProductComporatorParity());
        map.put(ClassTags.USER,new UserComporatorParity());
        map.put(ClassTags.FLIGHT,new FlightComporatorParity());
        map.put(ClassTags.HOTEL,new HotelComporatorParity());
    }
}
