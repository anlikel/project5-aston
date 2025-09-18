package BinarySearch;

import classes.Hotel;
import comparators.HotelComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BinarySearcher;
import utils.MyArrayListImpl;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTestHotel {

    @Test
    @DisplayName("Hotels Binary Search Test NullComp")
    public void hotelsBinarySearchNullComp(){
        Hotel hotelFind = new Hotel("Grand Hotel", "Paris", 4.5);

        Hotel hotel1 = new Hotel("Seaside Resort", "Miami", 4.8);
        Hotel hotel2 = new Hotel("City Inn", "Chicago", 3.2);
        Hotel hotel3 = new Hotel("Grand Hotel", "Paris", 4.5);
        Hotel hotel4 = new Hotel("Mountain View", "Denver", 4.1);
        Hotel hotel5 = new Hotel("Ocean Palace", "Miami", 4.7);
        Hotel hotel6 = new Hotel("Central Plaza", "New York", 4.3);

        Comparator comp = null;
        List<Hotel> hotels1 = new MyArrayListImpl<>();
        hotels1.add(hotel1);
        hotels1.add(hotel2);
        hotels1.add(hotel3);
        hotels1.add(hotel4);
        hotels1.add(hotel5);
        hotels1.add(hotel6);
        hotels1.sort(comp);
        int result = BinarySearcher.binarySearch(hotelFind, hotels1, comp);
        assertEquals(2, result); // После сортировки по natural order (name -> city -> rating)
    }

    @Test
    @DisplayName("Hotels Binary Search Test NameComp")
    public void hotelsBinarySearchNameComp(){
        Hotel hotelFind = new Hotel("Grand Hotel", "Paris", 4.5);

        Hotel hotel1 = new Hotel("Seaside Resort", "Miami", 4.8);
        Hotel hotel2 = new Hotel("City Inn", "Chicago", 3.2);
        Hotel hotel3 = new Hotel("Grand Hotel", "Paris", 4.5);
        Hotel hotel4 = new Hotel("Mountain View", "Denver", 4.1);
        Hotel hotel5 = new Hotel("Ocean Palace", "Miami", 4.7);
        Hotel hotel6 = new Hotel("Central Plaza", "New York", 4.3);

        HotelComparator hotelComparator = new HotelComparator();
        hotelComparator.setSortField("name");
        Comparator comp = hotelComparator;
        List<Hotel> hotels1 = new MyArrayListImpl<>();
        hotels1.add(hotel1);
        hotels1.add(hotel2);
        hotels1.add(hotel3);
        hotels1.add(hotel4);
        hotels1.add(hotel5);
        hotels1.add(hotel6);
        hotels1.sort(comp);
        int result = BinarySearcher.binarySearch(hotelFind, hotels1, comp);
        assertEquals(2, result); // После сортировки по name: Central Plaza, City Inn, Grand Hotel, Mountain View, Ocean Palace, Seaside Resort
    }

    @Test
    @DisplayName("Hotels Binary Search Test CityComp")
    public void hotelsBinarySearchCityComp(){
        Hotel hotelFind = new Hotel("Grand Hotel", "Paris", 4.5);

        Hotel hotel1 = new Hotel("Seaside Resort", "Miami", 4.8);
        Hotel hotel2 = new Hotel("City Inn", "Chicago", 3.2);
        Hotel hotel3 = new Hotel("Grand Hotel", "Paris", 4.5);
        Hotel hotel4 = new Hotel("Mountain View", "Denver", 4.1);
        Hotel hotel5 = new Hotel("Ocean Palace", "Miami", 4.7);
        Hotel hotel6 = new Hotel("Central Plaza", "New York", 4.3);

        HotelComparator hotelComparator = new HotelComparator();
        hotelComparator.setSortField("city");
        Comparator comp = hotelComparator;
        List<Hotel> hotels1 = new MyArrayListImpl<>();
        hotels1.add(hotel1);
        hotels1.add(hotel2);
        hotels1.add(hotel3);
        hotels1.add(hotel4);
        hotels1.add(hotel5);
        hotels1.add(hotel6);
        hotels1.sort(comp);
        int result = BinarySearcher.binarySearch(hotelFind, hotels1, comp);
        assertEquals(5, result); // После сортировки по city: Chicago, Denver, Miami, Miami, New York, Paris
    }

    @Test
    @DisplayName("Hotels Binary Search Test RatingComp")
    public void hotelsBinarySearchRatingComp(){
        Hotel hotelFind = new Hotel("Grand Hotel", "Paris", 4.5);

        Hotel hotel1 = new Hotel("Seaside Resort", "Miami", 4.8);
        Hotel hotel2 = new Hotel("City Inn", "Chicago", 3.2);
        Hotel hotel3 = new Hotel("Grand Hotel", "Paris", 4.5);
        Hotel hotel4 = new Hotel("Mountain View", "Denver", 4.1);
        Hotel hotel5 = new Hotel("Ocean Palace", "Miami", 4.7);
        Hotel hotel6 = new Hotel("Central Plaza", "New York", 4.3);

        HotelComparator hotelComparator = new HotelComparator();
        hotelComparator.setSortField("rating");
        Comparator comp = hotelComparator;
        List<Hotel> hotels1 = new MyArrayListImpl<>();
        hotels1.add(hotel1);
        hotels1.add(hotel2);
        hotels1.add(hotel3);
        hotels1.add(hotel4);
        hotels1.add(hotel5);
        hotels1.add(hotel6);
        hotels1.sort(comp);
        int result = BinarySearcher.binarySearch(hotelFind, hotels1, comp);
        assertEquals(3, result); // После сортировки по rating: 3.2, 4.1, 4.3, 4.5, 4.7, 4.8
    }
}