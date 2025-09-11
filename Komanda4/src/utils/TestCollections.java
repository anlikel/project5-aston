package utils;

import classes.Product;
import classes.User;

import java.util.ArrayList;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<Product> products=new MyArrayListImpl<>();
        products.add(new Product.ProductBuilder()
                .setTitle("Laptop")
                .setPrice(999.99)
                .setQuantity(5)
                .build());

        products.add(new Product.ProductBuilder()
                .setTitle("Mouse")
                .setPrice(25.50)
                .setQuantity(20)
                .build());

        products.add(new Product.ProductBuilder()
                .setTitle("Laptop") // Такое же название как у первого
                .setPrice(899.99)   // Но другая цена
                .setQuantity(3)
                .build());
        products.sort(null);
        products.forEach(System.out::println);
    }
}
