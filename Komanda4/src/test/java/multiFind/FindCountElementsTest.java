package multiFind;

import classes.User;
import model.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import utils.Holder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
    @DisplayName("Тест на элемент содержащий null")
    public void testFindElementInNull(){
        User user1 = new User.UserBuilder().setName("1").setAge(1).setEmail("1").build();
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        User user = null;
        try {
            FindCountElements.find(userList,user);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = outputStream.toString();
        assertTrue(result.contains("Элемент содержит null"));
    }

    @Test
    @DisplayName("Тест на список содержащий null")
    public void testFindListNull(){
        User user1 = new User.UserBuilder().setName("1").setAge(1).setEmail("1").build();
        List<User> userList = null;
        try {
            FindCountElements.find(userList,user1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = outputStream.toString();
        assertTrue(result.contains("Коллекция пуста"));
    }

    @Test
    @DisplayName("Тест на список содержащий один элемент")
    public void testFindListOneElement(){
        User user1 = new User.UserBuilder().setName("1").setAge(1).setEmail("1").build();
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        try {
            FindCountElements.find(userList,user1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = outputStream.toString();
        assertTrue(result.contains("Количество вхождения элемента в коллекцию - 1"));
    }

    @Test
    @DisplayName("Тест на список содержащий 50 элементов")
    public void testFindListFiftyElement(){
        User userOne = new User.UserBuilder().setName("1").setAge(1).setEmail("1").build();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            userList.add(userOne);
        }
        try {
            FindCountElements.find(userList,userOne);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String result = outputStream.toString();
        assertTrue(result.contains("Количество вхождения элемента в коллекцию - 50"));
    }

}
