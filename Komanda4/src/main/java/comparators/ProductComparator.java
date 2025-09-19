package comparators;


import classes.Product;
import exceptions.ReadWriteException;
import utils.Util;
import utils.Validator;


import java.util.Comparator;

public class ProductComparator implements Comparator<Product>,Filter {

    private String sortField;

    @Override
    public int compare(Product p1, Product p2) {
        switch (sortField) {
            case "title":
                return p1.getTitle().compareTo(p2.getTitle());
            case "price":
                double price1 = Math.round(p1.getPrice() * 100.0) / 100.0;
                double price2 = Math.round(p2.getPrice() * 100.0) / 100.0;
                int priceCompare = Double.compare(price1, price2);
                if (priceCompare != 0) {
                    return priceCompare;
                }
            case "quantity":
                return Integer.compare(p1.getQuantity(), p2.getQuantity());
            default:
                return p1.compareTo(p2);
        }
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public void setFilter() throws ReadWriteException {
        try{
            Util.writeMessage("введите поле для сортировки");
            Util.writeMessage("title price quantity");
            sortField=Util.readMessage();
            Validator.checkSortFieldForProduct(sortField);
        }
        catch (ReadWriteException e){
            Util.writeMessage(e.getMessage().toString());
            throw new ReadWriteException("некорректный ввод");
        }
    }
}
