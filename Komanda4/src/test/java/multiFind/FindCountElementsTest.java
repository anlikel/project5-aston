package multiFind;

import classes.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindCountElementsTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }
    @AfterEach
    void tearDown(){
        System.setOut(originalOut);
    }
    @Test
    @DisplayName("Тест на список содержащий null")
    public void testFindElementInNullLenthColection(){
        User user = null;
        try {
            FindCountElements.find(user);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = outputStream.toString();
        assertTrue(result.contains("Элемент содержит null"));
        //assertEquals("Элемент содержит null", result);


    }
}
