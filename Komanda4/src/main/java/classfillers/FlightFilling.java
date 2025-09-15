package classfillers;

import classes.Flight;
import commands.Command;
import commands.CommandFactory;
import commands.ReadCommand;
import enums.Action;
import exceptions.ReadWriteException;
import utils.Holder;
import utils.MyArrayListImpl;
import utils.Util;
import utils.FileObjectLoad;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightFilling implements Filling<Flight> {

    private String nameFlight;
    private LocalDateTime date;
    private double price;

    @Override
    public List<Flight> manualFill(int size) throws ReadWriteException {
        List<Flight> temp =new MyArrayListImpl<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        for (int i = 0; i < size; i++) {
            Util.writeMessage("input flight name");
            nameFlight = Util.readName();

            Util.writeMessage("input date flight: dd.MM.yyyy HH:mm");
            String date1 = Util.readDate();
            try {
                date = LocalDateTime.parse(date1, formatter);
            } catch (DateTimeParseException e) {
                throw new ReadWriteException("Ошибка чтения даты: " + e.getMessage());
            }

            Util.writeMessage("input flight price");
            String price1=Util.readPrice();
            price=Double.parseDouble(price1);

            Flight flight = new Flight.FlightBuilder()
                    .setNameFlight(nameFlight)
                    .setDate(date)
                    .setPrice(price)
                    .build();
            temp.add(flight);
        }
        return temp;
    }

    @Override
    public List<Flight> randomFill(int size) {
        List<Flight> temp = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Генерация случайной даты в пределах ±30 дней от текущей
            LocalDateTime now = LocalDateTime.now();
            int randomDays = random.nextInt(60) - 30; // от -30 до +29 дней
            int randomHours = random.nextInt(24);
            int randomMinutes = random.nextInt(60);

            LocalDateTime randomDate = now.plusDays(randomDays)
                    .plusHours(randomHours)
                    .plusMinutes(randomMinutes);

            Flight flight = new Flight.FlightBuilder()
                    .setNameFlight("Flight" + random.nextInt(1000))
                    .setDate(randomDate)
                    .setPrice(Math.round(random.nextDouble() * 1500 * 100.0) / 100.0) // округление до 2 знаков
                    .build();
            temp.add(flight);
        }
        return temp;
    }

    @Override
    public List<Flight> autoFill() throws ReadWriteException {
        Command command= CommandFactory.getCommand(Action.READ);
        command.execute();
        ReadCommand readCommand=(ReadCommand) command;
        return readCommand.getList();
    }
}
