package create;

import classes.Flight;
import classes.Hotel;
import classes.Product;
import classes.User;
import classfillers.Filling;
import classfillers.FillingFactory;
import enums.ClassTags;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectsListRandomCreateTest {

    @Test
    @DisplayName("Users List creation test")
    public void createUserListRandom(){
        ClassTags tag=ClassTags.USER;
        Filling f= FillingFactory.getFiller(tag);
        List<User> users=f.randomFill(20);

        int listSizeResult=users.size();
        assertEquals(20, listSizeResult);

        Class clResult=users.get(0).getClass();
        assertEquals(User.class, clResult);
    }

    @Test
    @DisplayName("Products List creation test")
    public void createProductListRandom(){
        ClassTags tag = ClassTags.PRODUCT;
        Filling f = FillingFactory.getFiller(tag);
        List<Product> products = f.randomFill(20);

        int listSizeResult = products.size();
        assertEquals(20, listSizeResult);

        Class clResult = products.get(0).getClass();
        assertEquals(Product.class, clResult);
    }

    @Test
    @DisplayName("Flights List creation test")
    public void createFlightListRandom(){
        ClassTags tag = ClassTags.FLIGHT;
        Filling f = FillingFactory.getFiller(tag);
        List<Flight> flights = f.randomFill(20);

        int listSizeResult = flights.size();
        assertEquals(20, listSizeResult);

        Class clResult = flights.get(0).getClass();
        assertEquals(Flight.class, clResult);
    }

    @Test
    @DisplayName("Hotels List creation test")
    public void createHotelListRandom(){
        ClassTags tag = ClassTags.HOTEL;
        Filling f = FillingFactory.getFiller(tag);
        List<Hotel> hotels = f.randomFill(20);

        int listSizeResult = hotels.size();
        assertEquals(20, listSizeResult);

        Class clResult = hotels.get(0).getClass();
        assertEquals(Hotel.class, clResult);
    }
}
