package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {

    private Validator() {}

    public static boolean isValidName(String fullName){
        if (fullName == null || fullName.trim().isEmpty()) {
            return false;
        }

        String regex = "^[A-ZА-Я][a-zа-я]*(?:-[A-ZА-Я][a-zа-я]*)*$";
        String[] names = fullName.trim().split(" ");

        for (String name : names){
            if (!name.matches(regex)) return false;
        }

        return true;
    }

    public static boolean isValidAge(String age) {
        if (age == null || age.trim().isEmpty()) {
            return false;
        }
        try {
            int ageInt = Integer.parseInt(age.trim());
            return ageInt >= 0 && ageInt <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        String emailRegex = "^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(emailRegex);
    }

    public static boolean isValidPrise(String prise) {
        if (prise == null || prise.trim().isEmpty()) {
            return false;
        }

        try {
            double praseDouble = Double.parseDouble(prise.trim());
            return praseDouble >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidQuantity(String quantity) {
        if (quantity == null || quantity.trim().isEmpty()) {
            return false;
        }

        try {
            int quantityInt = Integer.parseInt(quantity.trim());
            return quantityInt >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty() && title.matches("[A-Za-zА-Яа-я\\-\\s]+");
    }

    public static boolean isValidDate(String date){
        return isValidDate(date, "dd/MM/yyyy HH:mm");
    }

    public static boolean isValidDate(String date, String pattern){
            if (date == null || date.trim().isEmpty()) {
                return false;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            try {
                LocalDateTime.parse(date, formatter);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
    }
}

