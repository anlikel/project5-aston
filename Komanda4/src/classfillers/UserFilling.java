package classfillers;

import classes.User;
import exceptions.ReadWriteException;
import utils.FileObjectLoader;
import utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFilling implements Filling<User> {
    private String name;
    private int age;
    private String email;
    int fieldCount=3;

    @Override
    public List<User> manualFill(int size) throws ReadWriteException {
        List<User>users=new ArrayList<>();
        for (int i=0;i<size;i++) {
            Util.writeMessage("input user name");
            name = Util.readMessage();
            Util.writeMessage("input user age");
            age = Integer.parseInt(Util.readMessage());
            Util.writeMessage("input user email");
            email = Util.readMessage();
            User user = new User.UserBuilder()
                    .setName(name)
                    .setAge(age)
                    .setEmail(email)
                    .build();
            users.add(user);
        }
//        users.forEach(System.out::println);
        return users;
    }

    @Override
    public List<User> randomFill(int size) {
        List<User>users=new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<size;i++) {
            User user = new User.UserBuilder()
                    .setName("User" + random.nextInt(1000))
                    .setAge(random.nextInt(80) + 18)
                    .setEmail("user" + random.nextInt(1000) + "@example.com")
                    .build();
            users.add(user);
        }
//        users.forEach(System.out::println);
        return users;
    }

    @Override
    public List<User> autoFill() throws ReadWriteException {
        List<String> list= FileObjectLoader.getUserList();
        List<User>users=new ArrayList<>();
        if (list.size() < 3) {
            throw new ReadWriteException("исключяение: слишком аленький список данных для заполнения");
        }
        for(int i=0;i<list.size()/fieldCount;i++) {
            User user=new User.UserBuilder()
                    .setName(list.get(i*3))
                    .setAge(Integer.parseInt(list.get(i*3+1)))
                    .setEmail(list.get(i*3+2))
                    .build();
            users.add(user);
        }
//        users.forEach(System.out::println);
        return users;
    }

}
