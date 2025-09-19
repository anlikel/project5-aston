package Comporators;

import classes.Flight;
import comparators.FlightComporatorParity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightComporatorParityTest {
    @BeforeEach
    public void setUp(){
    }


    @Test
    @DisplayName("Тест Компоратора FlightComporatorParity")
    public void testSort(){
        FlightComporatorParity comporatorParity = new FlightComporatorParity();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime date1=LocalDateTime.parse("12.02.2000 00:00",formatter);
        LocalDateTime date2=LocalDateTime.parse("13.02.2000 00:00",formatter);
        LocalDateTime date3=LocalDateTime.parse("14.02.2000 00:00",formatter);
        LocalDateTime date4=LocalDateTime.parse("15.02.2000 00:00",formatter);
        LocalDateTime date5=LocalDateTime.parse("16.02.2000 00:00",formatter);

        Flight flight1 = new Flight("Flightx",date1,123.456);
        Flight flight2 = new Flight("Flightx2",date2,124.456);
        Flight flight3 = new Flight("Flightx3",date3,125.456);
        Flight flight4 = new Flight("Flightx4",date4,126.456);
        Flight flight5 = new Flight("Flightx5",date5,127.456);

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight5);
        flightList.add(flight2);
        flightList.add(flight4);
        flightList.add(flight3);
        System.out.println("before sort");
        flightList.forEach(t->System.out.println(t));
        flightList.sort(comporatorParity);
        System.out.println("after sort");
        flightList.forEach(t->System.out.println(t));

        assertEquals(12, flightList.get(0).getDate().getDayOfMonth());
        assertEquals(13, flightList.get(1).getDate().getDayOfMonth());
        assertEquals(15, flightList.get(2).getDate().getDayOfMonth());
        assertEquals(16, flightList.get(3).getDate().getDayOfMonth());
        assertEquals(14, flightList.get(4).getDate().getDayOfMonth());

    }
}
