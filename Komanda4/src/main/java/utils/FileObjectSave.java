package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import commands.Command;
import commands.CommandFactory;
import commands.ReadCommand;
import enums.Action;
import exceptions.ReadWriteException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileObjectSave {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static void saveListToFile(String fileName,List list) {
        try {
            objectMapper.writeValue(new File(fileName), list);

            System.out.println("Данные успешно сохранены в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveListToFileWithAppend(String fileName,List list) {
        try {
            Command command= CommandFactory.getCommand(Action.READ);
            command.execute();
            List list1=Holder.getController().getTempList();
            list1.addAll(list);
            objectMapper.writeValue(new File(fileName), list1);

            System.out.println("Данные успешно сохранены в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
            e.printStackTrace();
        } catch (ReadWriteException e) {
            throw new RuntimeException(e);
        }
    }
}
