package classes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public final class Flight implements Comparable<Flight> {
    private final String nameFlight;
    private final Date date;
    private final double price;

    public Flight(FlightBuilder flightBuilder) {
        this.nameFlight = flightBuilder.nameFlight;
        this.date = flightBuilder.date;
        this.price = flightBuilder.price;
    }

    public String getNameFlight() {
        return nameFlight;
    }

    public Date getDate() {
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
        DateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String text = fmt.format(date);

        return String.format("Flight{nameFlight='%s', date='%s', price=%.2f}",
                nameFlight, text, price);
    }

    @Override
    public int compareTo(Flight o) {
        int nameCompare = this.nameFlight.compareTo(o.nameFlight);
        if(nameCompare != 0){
            return nameCompare;
        }

        int dateCompare = this.date.compareTo(o.date);
        if(dateCompare != 0){
            return dateCompare;
        }

        return Double.compare(this.price, o.price);
    }



    public static class FlightBuilder{
        private  String nameFlight;
        private  Date date;
        private  double price;

        public FlightBuilder setNameFlight (String nameFlight){
            this.nameFlight = nameFlight;
            return this;
        }

        public FlightBuilder setDate(Date date){
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
