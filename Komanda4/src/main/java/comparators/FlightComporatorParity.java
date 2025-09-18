package comparators;

import classes.Flight;

import java.time.ZoneOffset;
import java.util.Comparator;

public class FlightComporatorParity implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {

        int one = o1.getDate().getDayOfYear();
        int two = o1.getDate().getDayOfYear();
        if ( one % 2 == 0 && two % 2 == 0) {
            return o1.getDate().compareTo(o2.getDate());
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
