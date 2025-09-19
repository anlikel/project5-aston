package utils;

import classes.Flight;
import classes.Hotel;
import classes.Product;
import classes.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.ClassTags;
import exceptions.ReadWriteException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileObjectLoad {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private FileObjectLoad(){}

    public static List<User> loadUsersFromJsonFile(String file) throws ReadWriteException {
        try {

            if (!Files.exists(Path.of(file))) {
                throw new ReadWriteException("Исключение: файл не существует - " + file);
            }

            if (Files.size(Path.of(file))==0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(file),
                    new TypeReference<List<User>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + file + ": " + e.getMessage());
        }
    }

    public static List<Product> loadProductsFromJsonFile(String file) throws ReadWriteException {
        try {
            if (!Files.exists(Path.of(file))) {
                throw new ReadWriteException("Исключение: файл не существует - " + file);
            }

            if (Files.size(Path.of(file))==0) {
                return List.of();

            }

            return objectMapper.readValue(
                    new File(file),
                    new TypeReference<List<Product>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + file + ": " + e.getMessage());
        }
    }

    public static List<Flight> loadFlightFromJsonFile(String file) throws ReadWriteException {
        try {
            if (!Files.exists(Path.of(file))) {
                throw new ReadWriteException("Исключение: файл не существует - " + file);
            }

            if (Files.size(Path.of(file)) == 0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(file),
                    new TypeReference<List<Flight>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + file + ": " + e.getMessage());
        }
    }

    public static List<Hotel> loadHotelsromJsonFile(String file) throws ReadWriteException {
        try {

            if (!Files.exists(Path.of(file))) {
                throw new ReadWriteException("Исключение: файл не существует - " + file);
            }

            if (Files.size(Path.of(file))==0) {
                return List.of();
            }

            return objectMapper.readValue(
                    new File(file),
                    new TypeReference<List<Hotel>>() {}
            );

        } catch (IOException e) {
            throw new ReadWriteException("Исключение: ошибка чтения JSON файла " + file + ": " + e.getMessage());
        }
    }

    public static List getFileList(String file) throws ReadWriteException {
        List list=null;
        ClassTags tag=Holder.getController().getTag();
        switch (tag){
            case PRODUCT:
                list=loadProductsFromJsonFile(file);
                break;
            case USER:
                list=loadUsersFromJsonFile(file);
                break;
            case FLIGHT:
                list=loadFlightFromJsonFile(file);
                break;
            case HOTEL:
                list=loadHotelsromJsonFile(file);
                break;
        }
        return list;
    }

    public static void checkFileForSave(String file) throws ReadWriteException {
        if (!Files.exists(Path.of(file))) {
            throw new ReadWriteException("Исключение: файл не существует - " + file);
        }
        if (!Files.isWritable(Path.of(file))) {
            throw new ReadWriteException("Исключение: в файл нельзя записать - " + file);
        }
    }
}
