package utils;



import exceptions.ReadWriteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileObjectLoad {
    private static List<String> productList=null;
    private static List<String> userList=null;

    private FileObjectLoad(){}

    public static List<String>getProductList() throws ReadWriteException {
        if(productList==null){
            productList=loadListFromFile("src/properties/product.txt");
        }
        return productList;
    }

    public static List<String>getUserList() throws ReadWriteException {
        if(userList==null){
            userList=loadListFromFile("src/properties/user.txt");
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
}
