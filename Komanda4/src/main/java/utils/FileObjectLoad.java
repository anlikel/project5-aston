package utils;

import classes.Flight;
import classes.Product;
import classes.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ReadWriteException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileObjectLoad {
    private static List<String> productList=null;
    private static List<String> userList=null;
    private static List<String> flightList=null;
    static String productsFile="src/main/resources/product.txt";
    static String usersFile="src/main/resources/user.txt";
    static String flightsFile="src/main/resources/flight.txt";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private FileObjectLoad(){}

    public static List<User> loadUsersFromJsonFile() throws ReadWriteException {
        try {

            if (!Files.exists(Path.of(usersFile))) {
                throw new ReadWriteException("Исключение: файл не существует - " + usersFile);
            }

            if (Files.size(Path.of(usersFile))==0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(usersFile),
                    new TypeReference<List<User>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + usersFile + ": " + e.getMessage());
        }
    }

    public static List<Product> loadProductsFromJsonFile() throws ReadWriteException {
        try {
            if (!Files.exists(Path.of(productsFile))) {
                throw new ReadWriteException("Исключение: файл не существует - " + productsFile);
            }

            if (Files.size(Path.of(productsFile))==0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(productsFile),
                    new TypeReference<List<Product>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + productsFile + ": " + e.getMessage());
        }
    }

    public static List<Flight> loadFlightFromJsonFile() throws ReadWriteException {
        try {
            if (!Files.exists(Path.of(flightsFile))) {
                throw new ReadWriteException("Исключение: файл не существует - " + flightsFile);
            }

            if (Files.size(Path.of(flightsFile)) == 0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(flightsFile),
                    new TypeReference<List<Flight>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + flightsFile + ": " + e.getMessage());
        }
    }
}
