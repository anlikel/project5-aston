package Comporators;

import classes.Product;
import classes.User;
import comparators.ProductComporatorParity;
import comparators.UserComporatorParity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductComporatorParityTest {

    @BeforeEach
    public void setUp(){
    }

    @Test
    @DisplayName("Тест Компоратора ProductComporatorParity")
    public void testSort() {
        ProductComporatorParity comporatorParity = new ProductComporatorParity();
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product("Qwer1",1,10);
        Product product2 = new Product("Qwer2",2,10);
        Product product3 = new Product("Qwer3",3,10);
        Product product4 = new Product("Qwer4",4,10);
        Product product5 = new Product("Qwer5",5,10);
        Product product6 = new Product("Qwer6",6,10);
        Product product7 = new Product("Qwer7",7,10);

        productList.add(product4);
        productList.add(product1);
        productList.add(product7);
        productList.add(product6);
        productList.add(product2);
        productList.add(product5);
        productList.add(product3);

        System.out.println("before sort");
        productList.forEach(t->System.out.println(t));
        productList.sort(comporatorParity);
        System.out.println("after sort");
        productList.forEach(t->System.out.println(t));

        assertEquals(4, productList.get(0).getPrice());
        assertEquals(1, productList.get(1).getPrice());
        assertEquals(7, productList.get(2).getPrice());
        assertEquals(2, productList.get(3).getPrice());
        assertEquals(6, productList.get(4).getPrice());
        assertEquals(5, productList.get(5).getPrice());
        assertEquals(3, productList.get(6).getPrice());
    }
}
