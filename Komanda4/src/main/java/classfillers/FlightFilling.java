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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightFilling implements Filling<Flight> {

    private String nameFlight;
    private LocalDateTime date;
    private double price;

    @Override
    public List<Flight> manualFill(int size) throws ReadWriteException {
//        List<Flight> temp =new MyArrayListImpl<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
//
//        for (int i = 0; i < size; i++) {
//            Util.writeMessage("input flight name or exit");
//            nameFlight = Util.readName();
//
//            Util.writeMessage("input date flight: dd.MM.yyyy HH:mm or exit");
//            String text = Util.readDate();
//            try {
//                date = LocalDateTime.parse(text, formatter);
//            } catch (DateTimeParseException e) {
//                throw new ReadWriteException("Ошибка чтения даты: " + e.getMessage());
//            }
//
//            Util.writeMessage("input flight price or exit");
//            String price1=Util.readPrice();
//            price = Double.parseDouble(price1);
//
//            Flight flight = new Flight.FlightBuilder()
//                    .setNameFlight(nameFlight)
//                    .setDate(date)
//                    .setPrice(price)
//                    .build();
//            temp.add(flight);
//        }
//        return temp;
//        ************************************************************
        String[] names = new String[size];
        LocalDateTime[] dates = new LocalDateTime[size];
        double[] prices = new double[size];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        for (int i = 0; i < size; i++) {
            Util.writeMessage("input flight name or exit");
            names[i] = Util.readName();

            Util.writeMessage("input date flight: dd.MM.yyyy HH:mm or exit");
            String text = Util.readDate();
            try {
                dates[i] = LocalDateTime.parse(text, formatter);
            } catch (DateTimeParseException e) {
                throw new ReadWriteException("Ошибка чтения даты: " + e.getMessage());
            }

            Util.writeMessage("input flight price or exit");
            String priceStr = Util.readPrice();
            prices[i] = Double.parseDouble(priceStr);
        }

        return IntStream.range(0, size)
                .mapToObj(i -> new Flight.FlightBuilder()
                        .setNameFlight(names[i])
                        .setDate(dates[i])
                        .setPrice(prices[i])
                        .build())
                .collect(Collectors.toCollection(MyArrayListImpl::new));
    }

    @Override
    public List<Flight> randomFill(int size) {
//        List<Flight> temp = new ArrayList<>();
//        Random random = new Random();
//
//        for (int i = 0; i < size; i++) {
//            // Генерация случайной даты в пределах ±30 дней от текущей
//            LocalDateTime now = LocalDateTime.now();
//            int randomDays = random.nextInt(60) - 30; // от -30 до +29 дней
//            int randomHours = random.nextInt(24);
//            int randomMinutes = random.nextInt(60);
//
//            LocalDateTime randomDate = now.plusDays(randomDays)
//                    .plusHours(randomHours)
//                    .plusMinutes(randomMinutes);
//
//            Flight flight = new Flight.FlightBuilder()
//                    .setNameFlight("Flight" + random.nextInt(1000))
//                    .setDate(randomDate)
//                    .setPrice(Math.round(random.nextDouble() * 1500 * 100.0) / 100.0) // округление до 2 знаков
//                    .build();
//            temp.add(flight);
//        }
//        return temp;
//        **********************************************************
        Random random = new Random();
        LocalDateTime now = LocalDateTime.now();

        return IntStream.range(0, size)
                .mapToObj(i -> {
                    // Генерация случайной даты в пределах ±30 дней от текущей
                    int randomDays = random.nextInt(60) - 30; // от -30 до +29 дней
                    int randomHours = random.nextInt(24);
                    int randomMinutes = random.nextInt(60);

                    LocalDateTime randomDate = now.plusDays(randomDays)
                            .plusHours(randomHours)
                            .plusMinutes(randomMinutes);

                    return new Flight.FlightBuilder()
                            .setNameFlight("Flight" + random.nextInt(1000))
                            .setDate(randomDate)
                            .setPrice(Math.round(random.nextDouble() * 1500 * 100.0) / 100.0)
                            .build();
                })
                .collect(Collectors.toCollection(MyArrayListImpl::new));
    }

    @Override
    public List<Flight> autoFill() throws ReadWriteException {
        Command command= CommandFactory.getCommand(Action.READ);
        command.execute();
        return Holder.getController().getTempList();
    }
}
