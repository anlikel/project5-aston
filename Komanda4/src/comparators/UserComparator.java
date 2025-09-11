package comparators;

import classes.User;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    private String sortField;

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortField() {
        return sortField;

    }

    @Override
    public int compare(User u1, User u2) {
        switch (sortField) {
            case "name":
                return u1.getName().compareTo(u2.getName());
            case "age":
                return Integer.compare(u1.getAge(), u2.getAge());
            case "email":
                return u1.getEmail().compareTo(u2.getEmail());
            default:
                return u1.compareTo(u2);
        }
    }
}