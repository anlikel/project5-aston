package comparators;


import classes.User;
import exceptions.ReadWriteException;
import utils.Util;


import java.util.Comparator;

public class UserComparator implements Comparator<User>,Filter {

    private String sortField;

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

    @Override
    public void setFilter() throws ReadWriteException {
        try{
            Util.writeMessage("введите поле для сортировки");
            Util.writeMessage("name age email");
            sortField=Util.readMessage();
        }
        catch (ReadWriteException e){
            throw new ReadWriteException("некорректный ввод");
        }
    }
}