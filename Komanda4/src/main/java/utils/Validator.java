package utils;

public class Validator {

    public static boolean isValidNameOrTitle(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[A-Za-zА-Яа-яs]+");
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
}

