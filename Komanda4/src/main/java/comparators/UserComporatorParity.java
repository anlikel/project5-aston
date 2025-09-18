package comparators;

import classes.User;

import java.util.Comparator;

public class UserComporatorParity implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.getAge() % 2 == 0 && o2.getAge() % 2 == 0) {

                if ( o1.getAge() > o2.getAge()) {
                    return 1;
                } else if ( o1.getAge() < o2.getAge()) {
                    return -1;
                }
                return 0;
        }

//        if (o1.getAge() % 2 != 0 && o2.getAge() % 2 != 0) {
//            return 0;
//        }
//
//        if (o1.getAge() % 2 == 0 && o2.getAge() % 2 != 0) {
//            return -1;
//        }

        return 0;
    }



}
