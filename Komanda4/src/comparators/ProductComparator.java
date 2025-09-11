package comparators;

import classes.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    private String sortField;

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortField() {
        return sortField;
    }

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
}
