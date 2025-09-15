package classfillers;

import classes.Hotel;
import classes.User;
import commands.Command;
import commands.CommandFactory;
import commands.ReadCommand;
import enums.Action;
import exceptions.ReadWriteException;
import utils.MyArrayListImpl;
import utils.Util;

import java.util.List;
import java.util.Random;

public class HotelFilling implements Filling<Hotel> {
    private String name;
    private String city;
    private double rating;

    @Override
    public List<Hotel> manualFill(int size) throws ReadWriteException {
        List<Hotel> hotels = new MyArrayListImpl<>();
        for (int i = 0; i < size; i++) {
            Util.writeMessage("input hotel name");
            name = Util.readName();

            Util.writeMessage("input hotel city");
            city = Util.readCity();

            Util.writeMessage("input hotel rating");
            String rating1=Util.readRating();
            rating = Double.parseDouble(rating1);

            Hotel hotel = new Hotel.HotelBuilder()
                    .setName(name)
                    .setCity(city)
                    .setRaiting(rating)
                    .build();
            hotels.add(hotel);
        }
        return hotels;
    }

    @Override
    public List<Hotel> randomFill(int size) {
        List<Hotel> hotels = new MyArrayListImpl<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            Hotel hotel = new Hotel.HotelBuilder()
                    .setName("Hotel" + random.nextInt(1000))
                    .setCity("City" + random.nextInt(1000))
                    .setRaiting(random.nextDouble(5))
                    .build();
            hotels.add(hotel);
        }
        return hotels;
    }

    @Override
    public List<Hotel> autoFill() throws ReadWriteException {
        Command command= CommandFactory.getCommand(Action.READ);
        command.execute();
        ReadCommand readCommand=(ReadCommand) command;
        return readCommand.getList();
    }
}
