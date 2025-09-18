package comparators;


import classes.Flight;
import classes.Product;
import exceptions.ReadWriteException;
import utils.Util;


import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class FlightComparator implements Comparator<Flight>,Filter {

    private String sortField;

    @Override
    public int compare(Flight f1, Flight f2) {
        switch (sortField) {
            case "name":
                return f1.getNameFlight().compareTo(f2.getNameFlight());
            case "date":
                return f1.getDate().truncatedTo(ChronoUnit.MINUTES)
                    .compareTo(f2.getDate().truncatedTo(ChronoUnit.MINUTES));
            case "price":
                double price1 = Math.round(f1.getPrice() * 100.0) / 100.0;
                double price2 = Math.round(f2.getPrice() * 100.0) / 100.0;
                int priceCompare = Double.compare(price1, price2);
                if (priceCompare != 0) {
                    return priceCompare;
                }
            default:
                return f1.compareTo(f2);
        }
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public void setFilter() throws ReadWriteException {
        try{
            Util.writeMessage("введите поле для сортировки");
            Util.writeMessage("name date price");
            sortField=Util.readMessage();
        }
        catch (ReadWriteException e){
            throw new ReadWriteException("некорректный ввод");
        }
    }

}
