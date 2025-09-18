package FileTests;

import classes.Flight;
import classes.Hotel;
import classes.Product;
import classes.User;
import enums.ClassTags;
import exceptions.ReadWriteException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FileObjectLoad;
import utils.FileObjectSave;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonReadWriteTest {

    @Test
    @DisplayName("Users List read/write test")
    public void createUserListRandom(){
        ClassTags tag = ClassTags.USER;
        User user1 = new User("Aa", 10, "aaa@aaa.com");
        User user2 = new User("Ba", 10, "aaa@aaa.com");
        User user3 = new User("Ca", 10, "aaa@aaa.com");
        List<User> users1 = List.of(user1, user2, user3);
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile("usersTemp", ".json");
            FileObjectSave.saveListToFile(tempFile.toString(), users1);
            List<User> users2 = FileObjectLoad.loadUsersFromJsonFile(tempFile.toString());

            boolean res1 = users1.get(0).equals(users2.get(0));
            boolean res2 = users1.get(1).equals(users2.get(1));
            boolean res3 = users1.get(2).equals(users2.get(2));

            assertTrue(res1);
            assertTrue(res2);
            assertTrue(res3);

        } catch (IOException | ReadWriteException e) {
            System.err.println(e.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    System.err.println("Ошибка удаления файла: " + e.getMessage());
                }
            }
        }
    }

    @Test
    @DisplayName("Products List read/write test")
    public void createProductListReadWrite() {
        Product product1 = new Product("Laptop", 999.99, 123);
        Product product2 = new Product("Book", 19.99, 456);
        Product product3 = new Product("Chair", 49.99, 789);
        List<Product> products1 = List.of(product1, product2, product3);
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile("productsTemp", ".json");
            FileObjectSave.saveListToFile(tempFile.toString(), products1);
            List<Product> products2 = FileObjectLoad.loadProductsFromJsonFile(tempFile.toString());

            boolean res1 = products1.get(0).equals(products2.get(0));
            boolean res2 = products1.get(1).equals(products2.get(1));
            boolean res3 = products1.get(2).equals(products2.get(2));

            assertTrue(res1);
            assertTrue(res2);
            assertTrue(res3);

        } catch (IOException | ReadWriteException e) {
            System.err.println(e.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    System.err.println("Ошибка удаления файла: " + e.getMessage());
                }
            }
        }
    }

    @Test
    @DisplayName("Flights List read/write test")
    public void createFlightListReadWrite() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime departure1 = LocalDateTime.parse("12.02.2024 10:00", formatter);
        LocalDateTime departure2 = LocalDateTime.parse("15.03.2024 14:30", formatter);
        LocalDateTime departure3 = LocalDateTime.parse("20.04.2024 08:45", formatter);

        Flight flight1 = new Flight("Flight1", departure1, 299.99);
        Flight flight2 = new Flight("Flight2", departure2,  599.99);
        Flight flight3 = new Flight("Flight3", departure3,  149.99);
        List<Flight> flights1 = List.of(flight1, flight2, flight3);
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile("flightsTemp", ".json");
            FileObjectSave.saveListToFile(tempFile.toString(), flights1);
            List<Flight> flights2 = FileObjectLoad.loadFlightFromJsonFile(tempFile.toString());

            boolean res1 = flights1.get(0).equals(flights2.get(0));
            boolean res2 = flights1.get(1).equals(flights2.get(1));
            boolean res3 = flights1.get(2).equals(flights2.get(2));

            assertTrue(res1);
            assertTrue(res2);
            assertTrue(res3);

        } catch (IOException | ReadWriteException e) {
            System.err.println(e.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    System.err.println("Ошибка удаления файла: " + e.getMessage());
                }
            }
        }
    }

    @Test
    @DisplayName("Hotels List read/write test")
    public void createHotelListReadWrite() {
        Hotel hotel1 = new Hotel("Hotel1", "City1",  199.99);
        Hotel hotel2 = new Hotel("Hotel2", "City2", 299.99);
        Hotel hotel3 = new Hotel("Hotel3", "City3",  89.99);
        List<Hotel> hotels1 = List.of(hotel1, hotel2, hotel3);
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile("hotelsTemp", ".json");
            FileObjectSave.saveListToFile(tempFile.toString(), hotels1);
            List<Hotel> hotels2 = FileObjectLoad.loadHotelsromJsonFile(tempFile.toString());

            boolean res1 = hotels1.get(0).equals(hotels2.get(0));
            boolean res2 = hotels1.get(1).equals(hotels2.get(1));
            boolean res3 = hotels1.get(2).equals(hotels2.get(2));

            assertTrue(res1);
            assertTrue(res2);
            assertTrue(res3);

        } catch (IOException | ReadWriteException e) {
            System.err.println(e.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    System.err.println("Ошибка удаления файла: " + e.getMessage());
                }
            }
        }
    }
}