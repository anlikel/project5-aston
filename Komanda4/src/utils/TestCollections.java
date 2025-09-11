package utils;

import java.util.ArrayList;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<Integer> list=new MyArrayListImpl<>();
        list.addAll(List.of(1,5,7,3,65,1,99));
        list.sort(null);
        list.forEach(System.out::println);
    }
}
