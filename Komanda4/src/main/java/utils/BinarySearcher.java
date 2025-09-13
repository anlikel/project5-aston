package utils;

import classes.User;
import exceptions.ReadWriteException;

import java.util.Comparator;
import java.util.List;

public class BinarySearcher{

    public static void main(String[] args) throws ReadWriteException {
        List<User>users=FileObjectLoad.loadUsersFromJsonFile();
        User user = new User.UserBuilder()
                .setName("User57")
                .setAge(36)
                .setEmail("user381@example.com")
                .build();
        User user2=users.get(2);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user.equals(user2));

        users.sort(null);
        int index=BinarySearcher.binarySearch(user,users,null);
        System.out.println(index);
        User user3=users.get(index);
        System.out.println(user3);
    }

    public static <E>int binarySearch(E key, List<E> list, Comparator<? super E> comparator) {
        int size=list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            E midElement = list.get(mid);
            int comparison;
            if (comparator != null) {
                comparison = comparator.compare(key, midElement);
            } else {
                Comparable<? super E> comparableKey = (Comparable<? super E>) key;
                comparison = comparableKey.compareTo(midElement);
            }
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
