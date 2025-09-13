package classfillers;

import classes.Flight;
import exceptions.ReadWriteException;
import utils.FileObjectLoad;
import utils.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FlightFilling implements Filling<Flight>{

    private  String nameFlight;
    private  Date date;
    private  double price;
    private int multiple = 3;
    @Override
    public List<Flight> manualFill(int size) throws ReadWriteException{
        List<Flight> temp = new ArrayList<>();
        for (int i=0;i<size;i++) {
            Util.writeMessage("input flight name");
            nameFlight = Util.readMessage();

            Util.writeMessage("input date flight: dd.mm.yyyy hh:mm");
            DateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String text = Util.readMessage();
            try {
                date = fmt.parse(text);
            } catch (ParseException e) {
                throw new ReadWriteException("Ошибка чтения даты");
            }

            Util.writeMessage("input flight price");
            price = Double.parseDouble(Util.readMessage());

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
        Date tempDate;
        for (int i=0;i<size;i++) {
            tempDate = new Date();
            long rnd = random.nextLong(100000) + tempDate.getTime();
            Flight flight = new Flight.FlightBuilder()
                    .setNameFlight("Flight" + random.nextInt(1000))
                    .setDate(new Date(rnd))
                    .setPrice(random.nextDouble() * 1500)
                    .build();
            temp.add(flight);
        }
        return temp;
    }

    @Override
    public List<Flight> autoFill() throws ReadWriteException {
        List<String> list= FileObjectLoad.getFlightList();

        List<Flight> temp =new ArrayList<>();
        DateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        if (list.size() % multiple != 0) {
            throw new ReadWriteException("исключяение: не верный формат файла");
        }
        for(int i=0;i<list.size()/multiple;i++) {
            try {
                Flight flight = new Flight.FlightBuilder()
                        .setNameFlight(list.get(i*3))
                        .setDate (fmt.parse (list.get(i*3+1)))
                        .setPrice(Double.parseDouble(list.get(i*3+2)))
                        .build();
                temp.add(flight);
            } catch (ParseException e) {
               throw  new ReadWriteException("исключение: ошибка чтения файла");
            }

        }
        return temp;
    }
}
