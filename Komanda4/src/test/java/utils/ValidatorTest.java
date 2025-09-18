package utils;

import exceptions.ReadWriteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля name на ввод 41 символов")
    public void testNameTooMuchCharacter(){
        boolean result = Validator.isValidName("Aaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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

    @Test
    @DisplayName("Тест поля Email на вод Null")
    public void testEmailNull(){
        boolean result = Validator.isValidEmail(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Email на вод одного символа")
    public void testEmailOneChar(){
        boolean result = Validator.isValidEmail("a");
        assertEquals(false, result);
    }
    @Test
    @DisplayName("Тест поля Email на вод пустой строки")
    public void testEmailZeroChar(){
        boolean result = Validator.isValidEmail("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Email на волидное значение")
    public void testEmailPositiv(){
        boolean result = Validator.isValidEmail("test@test.com");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Email на не волидное значение")
    public void testEmailNigative(){
        boolean result = Validator.isValidEmail("test@@test.com");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Price на ввод Null")
    public void testPriceNull(){
        boolean result = Validator.isValidPrice(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Price на ввод пустой строки")
    public void testPriceZeroChar(){
        boolean result = Validator.isValidPrice("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Price на ввод символов")
    public void testPriceChar(){
        boolean result = Validator.isValidPrice("12a.@!");
        assertEquals(false, result);
    }
    @Test
    @DisplayName("Тест поля Price на ввод волидного значения")
    public void testPriceVolid(){
        boolean result = Validator.isValidPrice("12.3");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Quantity на ввод волидного значения")
    public void testQuantityVolid(){
        boolean result = Validator.isValidQuantity("1");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Quantity на ввод null")
    public void testQuantityNull(){
        boolean result = Validator.isValidQuantity(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Quantity на ввод пустой строки")
    public void testQuantityZeroChar(){
        boolean result = Validator.isValidQuantity("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Quantity на ввод 0")
    public void testQuantityDouble(){
        boolean result = Validator.isValidQuantity("0");
        assertEquals(true, result);
    }
    @Test
    @DisplayName("Тест поля Quantity на ввод отрицательного значения")
    public void testQuantityNigotiv(){
        boolean result = Validator.isValidQuantity("-1");
        assertEquals(false, result);
    }


    @Test
    @DisplayName("Тест поля Title на ввод валидного значения (Qwerty1)")
    public void testTitlePositiv(){
        boolean result = Validator.isValidTitle("Qwerty1");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Title на ввод null")
    public void testTitleNull(){
        boolean result = Validator.isValidTitle(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Title на ввод пустой строки")
    public void testTitleZeroChar(){
        boolean result = Validator.isValidTitle("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Date на ввод null")
    public void testDateNull(){
        boolean result = Validator.isValidDate(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Date на ввод пустой строки")
    public void testDateZeroChar(){
        boolean result = Validator.isValidDate("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Date на ввод валидной даты")
    public void testDatePositiv(){
        boolean result = Validator.isValidDate("01.07.1871 11:59");
        assertTrue(result);
    }

    @Test
    @DisplayName("Тест поля Date на ввод не валидной даты")
    public void testDateNigativ(){
        boolean result = Validator.isValidDate("33.13.1871 30:61");
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест поля Date на ввод символов")
    public void testDateChar(){
        boolean result = Validator.isValidDate("3i.13.1871 30:61");
        assertFalse(result);
    }

    @Test
    @DisplayName("Тест поля City на ввод валидного значения (Qwerty1)")
    public void testCityPositiv(){
        boolean result = Validator.isValidCity("Qwerty1");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля City на ввод null")
    public void testCityNull(){
        boolean result = Validator.isValidCity(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля City на ввод пустой строки")
    public void testCityZeroChar(){
        boolean result = Validator.isValidCity("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод волидного значения")
    public void testRatingVolid(){
        boolean result = Validator.isValidRating("3.2");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод null")
    public void testRatingNull(){
        boolean result = Validator.isValidRating(null);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод пустой строки")
    public void testRatingZeroChar(){
        boolean result = Validator.isValidRating("");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод 0")
    public void testRatingDouble(){
        boolean result = Validator.isValidRating("0");
        assertEquals(true, result);
    }
    @Test
    @DisplayName("Тест поля Rating на ввод отрицательного значения")
    public void testRatingNigotiv(){
        boolean result = Validator.isValidRating("-1");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод минимального значения (0)")
    public void testRatingMin() {
        boolean result = Validator.isValidRating("0");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод максимального значения (5)")
    public void testRatingMax() {
        boolean result = Validator.isValidRating("5");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Тест поля Rating на ввод превышающего значения (6)")
    public void testRatingMaxPlus() {
        boolean result = Validator.isValidRating("6");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Тест checkList на ввод null")
    public void testCheckListNull() {
        assertThrows(ReadWriteException.class, () -> Validator.checkList(null));
    }

    @Test
    @DisplayName("Тест checkList на ввод null")
    public void testCheckListIsEmpty() {
        assertThrows(ReadWriteException.class, () ->
                Validator.checkList(new ArrayList()));
    }

    @Test
    @DisplayName("Тест checkList на ввод List")
    public void testCheckListVolid() {
        List testList = new ArrayList<>();
        testList.add("test");
        assertDoesNotThrow(() -> Validator.checkList(testList));
    }

    @Test
    @DisplayName("Тест checkList на ввывод текста")
    public void testCheckListTextCheck() {
        List testList = new ArrayList<>();
        ReadWriteException exception = assertThrows(ReadWriteException.class,
                () -> Validator.checkList(null));
        assertEquals("исключение: объект для записи не существует", exception.getMessage());
    }

}

