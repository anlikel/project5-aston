package classfillers;

import classes.User;
import commands.Command;
import commands.CommandFactory;
import commands.ReadCommand;
import enums.Action;
import exceptions.ReadWriteException;
import utils.FileObjectLoad;
import utils.Holder;
import utils.MyArrayListImpl;
import utils.Util;
import java.util.List;
import java.util.Random;

public class UserFilling implements Filling<User> {
    private String name;
    private int age;
    private String email;

    @Override
    public List<User> manualFill(int size) throws ReadWriteException {
        List<User>users=new MyArrayListImpl<>();
        for (int i=0;i<size;i++) {
            Util.writeMessage("input user name or exit");
            name = Util.readName();
            Util.writeMessage("input user age or exit");
            String age1=Util.readAge();
            age = Integer.parseInt(age1);
            Util.writeMessage("input user email or exit");
            email = Util.readEmail();
            User user = new User.UserBuilder()
                    .setName(name)
                    .setAge(age)
                    .setEmail(email)
                    .build();
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> randomFill(int size) {
        List<User>users=new MyArrayListImpl<>();
        Random random = new Random();
        for (int i=0;i<size;i++) {
            User user = new User.UserBuilder()
                    .setName("User" + random.nextInt(1000))
                    .setAge(random.nextInt(80) + 18)
                    .setEmail("user" + random.nextInt(1000) + "@example.com")
                    .build();
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> autoFill() throws ReadWriteException {
        Command command= CommandFactory.getCommand(Action.READ);
        command.execute();
        ReadCommand readCommand=(ReadCommand) command;
        return readCommand.getList();
    }
}
