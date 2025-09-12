package comparators;

import classes.Product;
import exceptions.ReadWriteException;
import utils.Util;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product>,Filter {

    private String sortField;

    @Override
    public int compare(Product p1, Product p2) {
        switch (sortField) {
            case "title":
                return p1.getTitle().compareTo(p2.getTitle());
            case "price":
                return Double.compare(p1.getPrice(), p2.getPrice());
            case "quantity":
                return Integer.compare(p1.getQuantity(), p2.getQuantity());
            default:
                return p1.compareTo(p2);
        }
    }

    @Override
    public void setFilter() throws ReadWriteException {
        try{
            Util.writeMessage("введите поле для сортировки");
            Util.writeMessage("title price quantity");
            sortField=Util.readMessage();
        }
        catch (ReadWriteException e){
            throw new ReadWriteException("некорректный ввод");
        }
    }
}
