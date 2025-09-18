package create;

import classes.Flight;
import classes.Hotel;
import classes.Product;
import classes.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectsCreateTest {

    @Test
    @DisplayName("User creation test")
    public void createUser(){
        User user1=new User("Aa",10,"aaa@aaa.com");
        User user2= new User.UserBuilder().setName("Aa").setAge(10).setEmail("aaa@aaa.com").build();
        boolean result=user1.equals(user2);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Hotel creation test")
    public void createHotel(){
        Hotel hotel1=new Hotel("Hotelx","Cityx",3.2);
        Hotel hotel2= new Hotel.HotelBuilder().setName("Hotelx").setCity("Cityx").setRaiting(3.2).build();
        boolean result=hotel1.equals(hotel2);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Product creation test")
    public void createProduct(){
        Product product1=new Product("titlex",10.2,12343);
        Product product2= new Product.ProductBuilder().setTitle("titlex").setPrice(10.2).setQuantity(12343).build();
        boolean result=product1.equals(product2);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Flight creation test")
    public void createFlight(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime date1=LocalDateTime.parse("12.02.2000 00:00",formatter);
        LocalDateTime date2=LocalDateTime.parse("12.02.2000 00:00",formatter);
        Flight flight1=new Flight("Flightx",date1,123.456);
        Flight flight2= new Flight.FlightBuilder().setNameFlight("Flightx").setDate(date2).setPrice(123.456).build();
        boolean result=flight1.equals(flight2);
        assertEquals(true, result);
    }
}
