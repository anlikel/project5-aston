package utils;

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
    static String productsFile2="src/main/resources/product2.txt";
    static String usersFile2="src/main/resources/user2.txt";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private FileObjectLoad(){}

    public static List<String>getProductList() throws ReadWriteException {
        if(productList==null){
            productList=loadListFromFile(productsFile);
        }
        return productList;
    }

    public static List<String>getUserList() throws ReadWriteException {
        if(userList==null){
            userList=loadListFromFile(usersFile);
        }
        return userList;
    }

    private static List<String>loadListFromFile(String filename) throws ReadWriteException {
        Path path= Paths.get(filename);
        List<String>list=null;
        try{
            if(Files.exists(path)){
                list=Files.readAllLines(path);
            }
            else{throw new ReadWriteException("исключение: файл не существцет");}
        }
        catch(IOException e){
            throw new ReadWriteException("исключение: ошибка чтения файла с данными");
        }
        return list;
    }

    public static List<User> loadUsersFromJsonFile() throws ReadWriteException {
        try {

            if (!Files.exists(Path.of(usersFile2))) {
                throw new ReadWriteException("Исключение: файл не существует - " + usersFile2);
            }

            if (Files.size(Path.of(usersFile2))==0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(usersFile2),
                    new TypeReference<List<User>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + usersFile2 + ": " + e.getMessage());
        }
    }

    public static List<Product> loadProductsFromJsonFile() throws ReadWriteException {
        try {
            if (!Files.exists(Path.of(productsFile2))) {
                throw new ReadWriteException("Исключение: файл не существует - " + productsFile2);
            }

            if (Files.size(Path.of(productsFile2))==0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(productsFile2),
                    new TypeReference<List<Product>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + productsFile2 + ": " + e.getMessage());
        }
    }
    /// //////////////////////////////////////////////////////////////
    public static List<String>getFlightList() throws ReadWriteException {
        if(flightList==null){
            flightList = loadListFromFile("src/properties/flight.txt");
        }
        return flightList;
    }


}
