package classfillers;



import exceptions.ReadWriteException;
import utils.FileObjectLoader;
import utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductFilling<Product> implements Filling<Product> {
    private String title;
    private double price;
    private int quantity;
    int fieldCount=3;

    @Override
    public List<Product> manualFill(int size) throws ReadWriteException {
        List<Product>products=new ArrayList<>();
        for (int i=0;i<size;i++) {
            Util.writeMessage("input product title");
            title= Util.readMessage();
            Util.writeMessage("input product price");
            price=Double.parseDouble(Util.readMessage());
            Util.writeMessage("input product quantity");
            quantity=Integer.parseInt(Util.readMessage());
            Product product=new Product.ProductBuilder()
                    .setTitle(title)
                    .setPrice(price)
                    .setQuantity(quantity)
                    .build();
            products.add(product);
        }
//        products.forEach(System.out::println);
        return products;
    }

    @Override
    public List<Product> randomFill(int size) {
        List<Product>products=new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<size;i++) {
            Product product = new Product.ProductBuilder()
                    .setTitle("Product" + random.nextInt(1000))
                    .setPrice(random.nextDouble() * 100)
                    .setQuantity(random.nextInt(100))
                    .build();
            products.add(product);
        }
//        products.forEach(System.out::println);
        return products;
    }

    @Override
    public List<Product> autoFill() throws ReadWriteException {
        List<String> list= FileObjectLoader.getProductList();
        List<Product>products=new ArrayList<>();
        if (list.size() < 3) {
            throw new ReadWriteException("исключяение: слишком аленький список данных для заполнения");
        }
        for(int i=0;i<list.size()/fieldCount;i++) {
            Product product=new Product.ProductBuilder()
                    .setTitle(list.get(i*3))
                    .setPrice(Double.parseDouble(list.get(i*3+1)))
                    .setQuantity(Integer.parseInt(list.get(i*3+2)))
                    .build();
            products.add(product);
        }
//products.forEach(System.out::println);
        return products;
    }
}
