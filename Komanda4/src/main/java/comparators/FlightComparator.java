package comparators;


import classes.Flight;
import classes.Product;
import exceptions.ReadWriteException;
import utils.Util;


import java.util.Comparator;

public class FlightComparator implements Comparator<Flight>,Filter {

    private String sortField;

    @Override
    public int compare(Flight f1, Flight f2) {
        switch (sortField) {
            case "name":
                return f1.getNameFlight().compareTo(f2.getNameFlight());
            case "date":
                return f1.getDate().compareTo(f2.getDate());
            case "price":
                return Double.compare(f1.getPrice(), f2.getPrice());
            default:
                return f1.compareTo(f2);
        }
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
