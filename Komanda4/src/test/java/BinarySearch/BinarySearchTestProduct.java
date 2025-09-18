package BinarySearch;

import classes.Product;
import comparators.ProductComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BinarySearcher;
import utils.MyArrayListImpl;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTestProduct {

    @Test
    @DisplayName("Products Binary Search Test NullComp")
    public void productsBinarySearchNullComp(){
        Product productFind = new Product("Laptop", 999.99, 5);

        Product product1 = new Product("Book", 19.99, 10);
        Product product2 = new Product("Laptop", 999.99, 5);
        Product product3 = new Product("Mouse", 25.50, 15);
        Product product4 = new Product("Keyboard", 49.99, 8);
        Product product5 = new Product("Monitor", 299.99, 3);
        Product product6 = new Product("Headphones", 79.99, 12);

        Comparator comp = null;
        List<Product> products1 = new MyArrayListImpl<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products1.add(product4);
        products1.add(product5);
        products1.add(product6);
        products1.sort(comp);
        int result = BinarySearcher.binarySearch(productFind, products1, comp);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Products Binary Search Test TitleComp")
    public void productsBinarySearchTitleComp(){
        Product productFind = new Product("Laptop", 999.99, 5);

        Product product1 = new Product("Book", 19.99, 10);
        Product product2 = new Product("Laptop", 999.99, 5);
        Product product3 = new Product("Mouse", 25.50, 15);
        Product product4 = new Product("Keyboard", 49.99, 8);
        Product product5 = new Product("Monitor", 299.99, 3);
        Product product6 = new Product("Headphones", 79.99, 12);

        ProductComparator productComparator = new ProductComparator();
        productComparator.setSortField("title");
        Comparator comp = productComparator;
        List<Product> products1 = new MyArrayListImpl<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products1.add(product4);
        products1.add(product5);
        products1.add(product6);
        products1.sort(comp);
        int result = BinarySearcher.binarySearch(productFind, products1, comp);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Products Binary Search Test PriceComp")
    public void productsBinarySearchPriceComp(){
        Product productFind = new Product("Laptop", 999.99, 5);

        Product product1 = new Product("Book", 19.99, 10);
        Product product2 = new Product("Laptop", 999.99, 5);
        Product product3 = new Product("Mouse", 25.50, 15);
        Product product4 = new Product("Keyboard", 49.99, 8);
        Product product5 = new Product("Monitor", 299.99, 3);
        Product product6 = new Product("Headphones", 79.99, 12);

        ProductComparator productComparator = new ProductComparator();
        productComparator.setSortField("price");
        Comparator comp = productComparator;
        List<Product> products1 = new MyArrayListImpl<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products1.add(product4);
        products1.add(product5);
        products1.add(product6);
        products1.sort(comp);
        int result = BinarySearcher.binarySearch(productFind, products1, comp);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Products Binary Search Test QuantityComp")
    public void productsBinarySearchQuantityComp(){
        Product productFind = new Product("Laptop", 999.99, 5);

        Product product1 = new Product("Book", 19.99, 10);
        Product product2 = new Product("Laptop", 999.99, 5);
        Product product3 = new Product("Mouse", 25.50, 15);
        Product product4 = new Product("Keyboard", 49.99, 8);
        Product product5 = new Product("Monitor", 299.99, 3);
        Product product6 = new Product("Headphones", 79.99, 12);

        ProductComparator productComparator = new ProductComparator();
        productComparator.setSortField("quantity");
        Comparator comp = productComparator;
        List<Product> products1 = new MyArrayListImpl<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products1.add(product4);
        products1.add(product5);
        products1.add(product6);
        products1.sort(comp);
        int result = BinarySearcher.binarySearch(productFind, products1, comp);
        assertEquals(1, result);
    }
}