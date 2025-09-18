package classfillers;

import classes.Product;
import commands.Command;
import commands.CommandFactory;
import commands.ReadCommand;
import enums.Action;
import exceptions.ReadWriteException;
import utils.FileObjectLoad;
import utils.Holder;
import utils.MyArrayListImpl;
import utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductFilling implements Filling<Product> {
    private String title;
    private double price;
    private int quantity;

    @Override
    public List<Product> manualFill(int size) throws ReadWriteException {
//        List<Product>products=new MyArrayListImpl<>();
//        for (int i=0;i<size;i++) {
//            Util.writeMessage("input product title or exit");
//            title= Util.readTitle();
//            Util.writeMessage("input product price or exit");
//            String price1=Util.readPrice();
//            price=Double.parseDouble(price1);
//            Util.writeMessage("input product quantity or exit");
//            String quantity1=Util.readQuantity();
//            quantity=Integer.parseInt(quantity1);
//            Product product=new Product.ProductBuilder()
//                    .setTitle(title)
//                    .setPrice(price)
//                    .setQuantity(quantity)
//                    .build();
//            products.add(product);
//        }
//        return products;
//        *****************************************************************************
        String[] titles = new String[size];
        double[] prices = new double[size];
        int[] quantities = new int[size];

        for (int i = 0; i < size; i++) {
            Util.writeMessage("input product title or exit");
            titles[i] = Util.readTitle();

            Util.writeMessage("input product price or exit");
            String priceStr = Util.readPrice();
            prices[i] = Double.parseDouble(priceStr);

            Util.writeMessage("input product quantity or exit");
            String quantityStr = Util.readQuantity();
            quantities[i] = Integer.parseInt(quantityStr);
        }

        return IntStream.range(0, size)
                .mapToObj(i -> new Product.ProductBuilder()
                        .setTitle(titles[i])
                        .setPrice(prices[i])
                        .setQuantity(quantities[i])
                        .build())
                .collect(Collectors.toCollection(MyArrayListImpl::new));
    }

    @Override
    public List<Product> randomFill(int size) {
//        List<Product>products=new ArrayList<>();
//        Random random = new Random();
//        for (int i=0;i<size;i++) {
//            Product product = new Product.ProductBuilder()
//                    .setTitle("Product" + random.nextInt(1000))
//                    .setPrice(random.nextDouble() * 100)
//                    .setQuantity(random.nextInt(100))
//                    .build();
//            products.add(product);
//        }
//        return products;
//        ***********************************************************************
        String[] titles = new String[size];
        double[] prices = new double[size];
        int[] quantities = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            titles[i] = "Product" + random.nextInt(1000);
            prices[i] = random.nextDouble() * 100;
            quantities[i] = random.nextInt(100);
        }

        return IntStream.range(0, size)
                .mapToObj(i -> new Product.ProductBuilder()
                        .setTitle(titles[i])
                        .setPrice(prices[i])
                        .setQuantity(quantities[i])
                        .build())
                .collect(Collectors.toCollection(MyArrayListImpl::new));
    }

    @Override
    public List<Product> autoFill() throws ReadWriteException {
        Command command= CommandFactory.getCommand(Action.READ);
        command.execute();
        return Holder.getController().getTempList();
    }
}
