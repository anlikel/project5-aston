package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileObjectSave {
    private static String fileName="src/main/resources/list.txt";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static void saveListToFile() {
        try {
            List list = getListFromModel();
            objectMapper.writeValue(new File(fileName), list);

            System.out.println("Данные успешно сохранены в файл: " + fileName);

        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List getListFromModel(){
        return Holder.getController().getModel().getList();
    }
}
