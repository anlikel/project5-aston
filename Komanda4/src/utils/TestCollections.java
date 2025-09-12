package utils;

import classes.Product;
import classes.User;
import comparators.ComparatorFabric;
import comparators.ProductComparator;
import enums.ClassTags;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        MyArrayListImpl<Product> products=new MyArrayListImpl<>();
        Product pr1=new Product.ProductBuilder()
                .setTitle("Laptop")
                .setPrice(999.99)
                .setQuantity(5)
                .build();

        Product pr2=new Product.ProductBuilder()
                .setTitle("Mouse")
                .setPrice(25.50)
                .setQuantity(20)
                .build();

        Product pr3=new Product.ProductBuilder()
                .setTitle("Laptop") // Такое же название как у первого
                .setPrice(899.99)   // Но другая цена
                .setQuantity(3)
                .build();
        products.add(pr1);
        products.add(pr2);
        products.add(pr3);
        Comparator comp=ComparatorFabric.getComparator(ClassTags.PRODUCT);
        ProductComparator productComparator=(ProductComparator)comp;
        productComparator.setSortField("price");
        comp=productComparator;
        products.sort(null);
        products.forEach(System.out::println);
        int index=products.binarySearch(pr2,null);
        System.out.println(index);
    }
}
