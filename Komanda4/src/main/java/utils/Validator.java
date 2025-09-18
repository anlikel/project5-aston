package utils;

import exceptions.ReadWriteException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Validator {

    private Validator() {
    }

    public static boolean isValidName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) { return false; }

        String regex = "^[A-ZА-Я][A-ZА-Яa-zа-я0-9\\-\\s]*$";
        String[] names = fullName.trim().split(" ");

        for (String name : names) {
            if (!name.matches(regex)) return false;
        }

        return true;
    }

    public static boolean isValidAge(String age) {
        if (age == null || age.trim().isEmpty()) { return false; }

        try {
            int ageInt = Integer.parseInt(age.trim());
            return ageInt >= 0 && ageInt <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) { return false; }

        String emailRegex = "^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(emailRegex);
    }

    public static boolean isValidPrice(String prise) {
        if (prise == null || prise.trim().isEmpty()) { return false; }

        try {
            double praseDouble = Double.parseDouble(prise.trim());
            return praseDouble >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidQuantity(String quantity) {
        if (quantity == null || quantity.trim().isEmpty()) { return false; }

        try {
            int quantityInt = Integer.parseInt(quantity.trim());
            return quantityInt >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty() && title.matches("[A-ZА-Яa-zа-я0-9\\-\\s]*$");
    }

    public static boolean isValidDate(String date) {
        return simpleValidDate(date, "dd.MM.yyyy HH:mm");
    }

    private static boolean simpleValidDate(String date, String pattern) {
        if (date == null || date.trim().isEmpty()) { return false; }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            LocalDateTime.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidCity(String city) {
        if (city == null || city.trim().isEmpty()) { return false; }
        return city.matches("^[A-ZА-Я][A-ZА-Яa-zа-я0-9\\-\\s]*$");
    }

    public static boolean isValidRating(String rating) {
        double ratingDouble;

        try {
            ratingDouble = Double.parseDouble(rating);
        } catch (NumberFormatException e) {
            return false;
        }

        return ratingDouble <= 5 && ratingDouble >= 0;
    }

    public static void checkList(List list) throws ReadWriteException {
        if(list==null || list.isEmpty()){
            throw new ReadWriteException("исключение: объект для записи не существует");
        }
    }
}

