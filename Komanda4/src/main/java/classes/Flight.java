package classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public final class Flight implements Comparable<Flight> {
    private final String nameFlight;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime date;

    private final double price;

    @JsonCreator
    public Flight(@JsonProperty("nameFlight") String nameFlight,
                  @JsonProperty("date") LocalDateTime date,
                  @JsonProperty("price") double price) {
        this.nameFlight = nameFlight;
        this.date = date;
        this.price = price;
    }

    public Flight(FlightBuilder flightBuilder) {
        this.nameFlight = flightBuilder.nameFlight;
        this.date = flightBuilder.date;
        this.price = flightBuilder.price;
    }

    public String getNameFlight() {
        return nameFlight;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Flight) obj;
        return Objects.equals(this.nameFlight, that.nameFlight) &&
                Objects.equals(this.date, that.date) &&
                Double.doubleToLongBits(this.price) == Double.doubleToLongBits(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFlight, date, price);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String text = date.format(formatter);

        return String.format("Flight{nameFlight='%s', date='%s', price=%.2f}",
                nameFlight, text, price);
    }

    @Override
    public int compareTo(Flight o) {
        int dateCompare = this.date.truncatedTo(ChronoUnit.MINUTES).compareTo(o.date.truncatedTo(ChronoUnit.MINUTES));
        if(dateCompare != 0){
            return dateCompare;
        }
        double price1 = Math.round(this.price * 100.0) / 100.0;
        double price2 = Math.round(o.price * 100.0) / 100.0;
        int priceCompare = Double.compare(price1, price2);
        if (priceCompare != 0) {
            return priceCompare;
        }
        return this.nameFlight.compareTo(o.nameFlight);
    }

    public static class FlightBuilder{
        private  String nameFlight;
        private  LocalDateTime date;
        private  double price;

        public FlightBuilder setNameFlight (String nameFlight){
            this.nameFlight = nameFlight;
            return this;
        }

        public FlightBuilder setDate(LocalDateTime date){
            this.date = date;
            return this;
        }

        public FlightBuilder setPrice(double price){
            this.price = price;
            return this;
        }

        public Flight build(){
            return new Flight(this);
        }
    }



}
