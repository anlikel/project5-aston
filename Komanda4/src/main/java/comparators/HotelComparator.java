package comparators;

import classes.Hotel;
import exceptions.ReadWriteException;
import utils.Util;
import utils.Validator;

import java.util.Comparator;

public class HotelComparator implements Comparator<Hotel>, Filter {
    private String sortField;

    @Override
    public int compare(Hotel h1, Hotel h2) {
        switch (sortField) {
            case "name":
                return h1.getName().compareTo(h2.getName());

            case "city":
                return h1.getCity().compareTo(h2.getCity());

            case "rating":
                double rating1 = Math.round(h1.getRating() * 100.0) / 100.0;
                double rating2 = Math.round(h2.getRating() * 100.0) / 100.0;
                int ratingCompare = Double.compare(rating1, rating2);
                if (ratingCompare != 0) {
                    return ratingCompare;
                }

            default:
                return h1.compareTo(h2);
        }
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public void setFilter() throws ReadWriteException {
        try {
            Util.writeMessage("введите поле для сортировки");
            Util.writeMessage("name city rating");
            sortField = Util.readMessage();
            Validator.checkSortFieldForHotel(sortField);
        } catch (ReadWriteException e) {
            Util.writeMessage(e.getMessage().toString());
            throw new ReadWriteException("некорректный ввод");
        }
    }
}
