package BinarySearch;

import classes.User;
import comparators.UserComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BinarySearcher;
import utils.MyArrayListImpl;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTestUser {

    @Test
    @DisplayName("Users Binary Search Test NullComp")
    public void usersBinarySearchNullComp(){
        User userFind=new User("Bge",1,"baa@aaa.com");

        User user1=new User("Aa",10,"aaa@aaa.com");
        User user2=new User("Bge",1,"baa@aaa.com");
        User user3=new User("Cdfbh",10,"afa@aaa.com");
        User user4=new User("Dfhr",14,"faa@aaa.com");
        User user5=new User("Fegee",10,"eaa@aaa.com");
        User user6=new User("Gfhr",5,"eaa@aaa.com");

        Comparator comp=null;
        List<User> users1=new MyArrayListImpl<>();
        users1.add(user1);
        users1.add(user2);
        users1.add(user3);
        users1.add(user4);
        users1.add(user5);
        users1.add(user6);
        users1.sort(comp);
        int result= BinarySearcher.binarySearch(userFind,users1,comp);
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Users Binary Search Test nameComp")
    public void usersBinarySearchNameComp(){
        User userFind=new User("Bge",1,"baa@aaa.com");

        User user1=new User("Aa",10,"aaa@aaa.com");
        User user2=new User("Bge",1,"baa@aaa.com");
        User user3=new User("Cdfbh",10,"afa@aaa.com");
        User user4=new User("Dfhr",14,"faa@aaa.com");
        User user5=new User("Fegee",10,"eaa@aaa.com");
        User user6=new User("Gfhr",5,"eaa@aaa.com");

        UserComparator userComparator=new UserComparator();
        userComparator.setSortField("name");
        Comparator comp=userComparator;
        List<User> users1=new MyArrayListImpl<>();
        users1.add(user1);
        users1.add(user2);
        users1.add(user3);
        users1.add(user4);
        users1.add(user5);
        users1.add(user6);
        users1.sort(comp);
        int result= BinarySearcher.binarySearch(userFind,users1,comp);
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Users Binary Search Test ageComp")
    public void usersBinarySearchAgeComp(){
        User userFind=new User("Bge",1,"baa@aaa.com");

        User user1=new User("Aa",10,"aaa@aaa.com");
        User user2=new User("Bge",1,"baa@aaa.com");
        User user3=new User("Cdfbh",10,"afa@aaa.com");
        User user4=new User("Dfhr",14,"faa@aaa.com");
        User user5=new User("Fegee",10,"eaa@aaa.com");
        User user6=new User("Gfhr",5,"eaa@aaa.com");

        UserComparator userComparator=new UserComparator();
        userComparator.setSortField("age");
        Comparator comp=userComparator;
        List<User> users1=new MyArrayListImpl<>();
        users1.add(user1);
        users1.add(user2);
        users1.add(user3);
        users1.add(user4);
        users1.add(user5);
        users1.add(user6);
        users1.sort(comp);
        int result= BinarySearcher.binarySearch(userFind,users1,comp);
        assertEquals(0,result);
    }

    @Test
    @DisplayName("Users Binary Search Test EmailComp")
    public void usersBinarySearchEmailComp(){
        User userFind=new User("Bge",1,"baa@aaa.com");

        User user1=new User("Aa",10,"aaa@aaa.com");
        User user2=new User("Bge",1,"baa@aaa.com");
        User user3=new User("Cdfbh",10,"afa@aaa.com");
        User user4=new User("Dfhr",14,"faa@aaa.com");
        User user5=new User("Fegee",10,"eaa@aaa.com");
        User user6=new User("Gfhr",5,"eaa@aaa.com");

        UserComparator userComparator=new UserComparator();
        userComparator.setSortField("email");
        Comparator comp=userComparator;
        List<User> users1=new MyArrayListImpl<>();
        users1.add(user1);
        users1.add(user2);
        users1.add(user3);
        users1.add(user4);
        users1.add(user5);
        users1.add(user6);
        users1.sort(comp);
        int result= BinarySearcher.binarySearch(userFind,users1,comp);
        assertEquals(2,result);
    }
}
