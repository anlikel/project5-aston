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

public class ProductFilling implements Filling<Product> {
    private String title;
    private double price;
    private int quantity;

    @Override
    public List<Product> manualFill(int size) throws ReadWriteException {
        List<Product>products=new MyArrayListImpl<>();
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
        return products;
    }

    @Override
    public List<Product> autoFill() throws ReadWriteException {
        Command command= CommandFactory.getCommand(Action.READ);
        command.execute();
        ReadCommand readCommand=(ReadCommand) command;
        return readCommand.getList();
    }
}
