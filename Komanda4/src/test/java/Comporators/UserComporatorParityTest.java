package Comporators;

import classes.User;
import comparators.UserComporatorParity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserComporatorParityTest {

    @BeforeEach
    public void setUp(){
    }


    @Test
    @DisplayName("Тест Компоратора UserComporatorParity")
    public void testSort() {
        UserComporatorParity comporatorParity = new UserComporatorParity();
        List<User> userList = new ArrayList<>();
        User user1 = new User("Qwe1",1,"qwer@qwer.re");
        User user2 = new User("Qwe2",2,"qwer@qwer.re");
        User user3 = new User("Qwe3",3,"qwer@qwer.re");
        User user4 = new User("Qwe4",4,"qwer@qwer.re");
        User user5 = new User("Qwe5",5,"qwer@qwer.re");
        User user6 = new User("Qwe6",6,"qwer@qwer.re");
        User user7 = new User("Qwe7",7,"qwer@qwer.re");
        userList.add(user6);
        userList.add(user2);
        userList.add(user1);
        userList.add(user4);
        userList.add(user3);
        userList.add(user7);
        userList.add(user5);
        System.out.println("before sort");
        userList.forEach(t-> System.out.println(t));
        userList.sort(comporatorParity);
        System.out.println("after sort");
        userList.forEach(t-> System.out.println(t));

        assertEquals(2, userList.get(0).getAge());
        assertEquals(4, userList.get(1).getAge());
        assertEquals(6, userList.get(2).getAge());
        assertEquals(1, userList.get(3).getAge());
        assertEquals(3, userList.get(4).getAge());
        assertEquals(7, userList.get(5).getAge());
        assertEquals(5, userList.get(6).getAge());
    }

}
