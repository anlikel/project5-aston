package comparators;

import classes.Hotel;

import java.util.Comparator;

public class HotelComporatorParity implements Comparator<Hotel> {
    @Override
    public int compare(Hotel h1, Hotel h2) {
        int one = (int)Math.round(h1.getRating());
        int two = (int)Math.round(h2.getRating());
        if ( one % 2 == 0 && two % 2 == 0) {
            if ( one > two) {
                return 1;
            } else if (one < two) {
                return -1;
            }
            return 0;
        }

        if (one % 2 != 0 && two % 2 != 0) {
            return 0;
        }

        if (one % 2 == 0 && two % 2 != 0) {
            return -1;
        }
        return 1;
    }
}
