package BinarySearch;

import classes.Flight;
import comparators.FlightComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BinarySearcher;
import utils.MyArrayListImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTestFlight {

    private LocalDateTime createDateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    @Test
    @DisplayName("Flights Binary Search Test NullComp")
    public void flightsBinarySearchNullComp(){
        Flight flightFind = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);

        Flight flight1 = new Flight("AA111", createDateTime("10.01.2024 08:00"), 199.99);
        Flight flight2 = new Flight("BB222", createDateTime("11.01.2024 12:30"), 349.99);
        Flight flight3 = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);
        Flight flight4 = new Flight("DD444", createDateTime("15.03.2024 14:15"), 449.99);
        Flight flight5 = new Flight("EE555", createDateTime("20.04.2024 09:45"), 199.99);
        Flight flight6 = new Flight("FF666", createDateTime("25.05.2024 16:20"), 599.99);

        Comparator comp = null;
        List<Flight> flights1 = new MyArrayListImpl<>();
        flights1.add(flight1);
        flights1.add(flight2);
        flights1.add(flight3);
        flights1.add(flight4);
        flights1.add(flight5);
        flights1.add(flight6);
        flights1.sort(comp);
        int result = BinarySearcher.binarySearch(flightFind, flights1, comp);
        assertEquals(2, result); // После сортировки по natural order (date -> price -> name)
    }

    @Test
    @DisplayName("Flights Binary Search Test NameComp")
    public void flightsBinarySearchNameComp(){
        Flight flightFind = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);

        Flight flight1 = new Flight("AA111", createDateTime("10.01.2024 08:00"), 199.99);
        Flight flight2 = new Flight("BB222", createDateTime("11.01.2024 12:30"), 349.99);
        Flight flight3 = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);
        Flight flight4 = new Flight("DD444", createDateTime("15.03.2024 14:15"), 449.99);
        Flight flight5 = new Flight("EE555", createDateTime("20.04.2024 09:45"), 199.99);
        Flight flight6 = new Flight("FF666", createDateTime("25.05.2024 16:20"), 599.99);

        FlightComparator flightComparator = new FlightComparator();
        flightComparator.setSortField("name");
        Comparator comp = flightComparator;
        List<Flight> flights1 = new MyArrayListImpl<>();
        flights1.add(flight1);
        flights1.add(flight2);
        flights1.add(flight3);
        flights1.add(flight4);
        flights1.add(flight5);
        flights1.add(flight6);
        flights1.sort(comp);
        int result = BinarySearcher.binarySearch(flightFind, flights1, comp);
        assertEquals(5, result); // После сортировки по name: AA111, BB222, DD444, EE555, FF666, NY123
    }

    @Test
    @DisplayName("Flights Binary Search Test DateComp")
    public void flightsBinarySearchDateComp(){
        Flight flightFind = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);

        Flight flight1 = new Flight("AA111", createDateTime("10.01.2024 08:00"), 199.99);
        Flight flight2 = new Flight("BB222", createDateTime("11.01.2024 12:30"), 349.99);
        Flight flight3 = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);
        Flight flight4 = new Flight("DD444", createDateTime("15.03.2024 14:15"), 449.99);
        Flight flight5 = new Flight("EE555", createDateTime("20.04.2024 09:45"), 199.99);
        Flight flight6 = new Flight("FF666", createDateTime("25.05.2024 16:20"), 599.99);

        FlightComparator flightComparator = new FlightComparator();
        flightComparator.setSortField("date");
        Comparator comp = flightComparator;
        List<Flight> flights1 = new MyArrayListImpl<>();
        flights1.add(flight1);
        flights1.add(flight2);
        flights1.add(flight3);
        flights1.add(flight4);
        flights1.add(flight5);
        flights1.add(flight6);
        flights1.sort(comp);
        int result = BinarySearcher.binarySearch(flightFind, flights1, comp);
        assertEquals(2, result); // После сортировки по date: 10.01, 11.01, 12.02, 15.03, 20.04, 25.05
    }

    @Test
    @DisplayName("Flights Binary Search Test PriceComp")
    public void flightsBinarySearchPriceComp(){
        Flight flightFind = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);

        Flight flight1 = new Flight("AA111", createDateTime("10.01.2024 08:00"), 199.99);
        Flight flight2 = new Flight("BB222", createDateTime("11.01.2024 12:30"), 349.99);
        Flight flight3 = new Flight("NY123", createDateTime("12.02.2024 10:00"), 299.99);
        Flight flight4 = new Flight("DD444", createDateTime("15.03.2024 14:15"), 449.99);
        Flight flight5 = new Flight("EE555", createDateTime("20.04.2024 09:45"), 199.99);
        Flight flight6 = new Flight("FF666", createDateTime("25.05.2024 16:20"), 599.99);

        FlightComparator flightComparator = new FlightComparator();
        flightComparator.setSortField("price");
        Comparator comp = flightComparator;
        List<Flight> flights1 = new MyArrayListImpl<>();
        flights1.add(flight1);
        flights1.add(flight2);
        flights1.add(flight3);
        flights1.add(flight4);
        flights1.add(flight5);
        flights1.add(flight6);
        flights1.sort(comp);
        int result = BinarySearcher.binarySearch(flightFind, flights1, comp);
        assertEquals(2, result); // После сортировки по price: 199.99, 199.99, 299.99, 349.99, 449.99, 599.99
    }
}