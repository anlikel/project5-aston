package Comporators;

import classes.Hotel;
import classes.Product;
import comparators.HotelComporatorParity;
import comparators.ProductComporatorParity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelComporatorParityTest {
    @BeforeEach
    public void setUp(){
    }

    @Test
    @DisplayName("Тест Компоратора ProductComporatorParity")
    public void testSort() {
        HotelComporatorParity comporatorParity = new HotelComporatorParity();
        List<Hotel> hotelList = new ArrayList<>();

        Hotel hotel1 = new Hotel("Qwer1","Qwer",1);
        Hotel hotel2 = new Hotel("Qwer2","Qwer",2);
        Hotel hotel3 = new Hotel("Qwer3","Qwer",3);
        Hotel hotel4 = new Hotel("Qwer4","Qwer",4);
        Hotel hotel5 = new Hotel("Qwe5","Qwer",5);
        Hotel hotel22 = new Hotel("Qwer22","Qwer",2);
        Hotel hotel44 = new Hotel("Qwer44","Qwer",4);

        hotelList.add(hotel3);
        hotelList.add(hotel1);
        hotelList.add(hotel4);
        hotelList.add(hotel2);
        hotelList.add(hotel5);
        hotelList.add(hotel22);
        hotelList.add(hotel44);
        System.out.println("before sort");
        hotelList.forEach(t->System.out.println(t));
        hotelList.sort(comporatorParity);
        System.out.println("after sort");
        hotelList.forEach(t->System.out.println(t));

        assertEquals(3, hotelList.get(0).getRating());  // первое четное (min)
        assertEquals(1, hotelList.get(1).getRating());  // второе четное
        assertEquals(2, hotelList.get(2).getRating());  // третье четное
        assertEquals(4, hotelList.get(3).getRating());  // четвертое четное
        assertEquals(5, hotelList.get(4).getRating());  // затем нечетные в исходном порядке
        assertEquals(2, hotelList.get(5).getRating());  //
        assertEquals(4, hotelList.get(6).getRating());  //

    }
}
