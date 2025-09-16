package utils;

import classes.User;
import multiFind.FindCountElements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @BeforeEach
    public void setUp(){

    }

    @Test
    @DisplayName("Тест поля name на ввод null")
    public void testNameNull(){
        boolean result = Validator.isValidName(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля name на ввод одного символа")
    public void testNameOneCharacter(){
        boolean result = Validator.isValidName("A");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля name на ввод 500 символов")
    public void testNameTooMuchCharacter(){
        boolean result = Validator.isValidName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля name на содержание недопустимых символов")
    public void testNameContainsInvalidCharacter(){
        boolean result = Validator.isValidName("Qw!%:?;{}");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля age на null")
    public void testAgeNull(){
        boolean result = Validator.isValidAge(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля age на отрицательное значение")
    public void testAgeNigative(){
        boolean result = Validator.isValidAge("-1");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля age на превышающее предел значение(ввод 101)")
    public void testAgeLimit(){
        boolean result = Validator.isValidAge("101");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля age на волидное значение")
    public void testAgePositiv(){
        boolean result = Validator.isValidAge("39");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля age на вод символов")
    public void testAgeChar(){
        boolean result = Validator.isValidAge("qwer123!@#$%");
        assertEquals(false, result);
    }

}

