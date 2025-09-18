package comparators;

import classes.Product;
import classes.User;

import java.util.Comparator;

public class ProductComporatorParity implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        int one = (int)Math.round(p1.getPrice());
        int two = (int)Math.round(p2.getPrice());
        if ( one % 2 == 0 && two % 2 == 0) {
            if ( one > two) {
                return 1;
            } else if (one < two) {
                return -1;
            }
            return 0;
        }

//        if (one % 2 != 0 && two % 2 != 0) {
//            return 0;
//        }
//
//        if (one % 2 == 0 && two % 2 != 0) {
//            return -1;
//        }

        return 0;
    }
}
