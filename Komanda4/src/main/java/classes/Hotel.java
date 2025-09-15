package classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Hotel implements Comparable<Hotel>{
    private final String name;
    private final String city;
    private final double rating;

    @JsonCreator
    public Hotel(@JsonProperty("name") String name,
                 @JsonProperty("city") String city,
                 @JsonProperty("rating") double rating) {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public Hotel(HotelBuilder hotelBuilder) {
        this.name = hotelBuilder.name;
        this.city = hotelBuilder.city;
        this.rating = hotelBuilder.rating;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public double getRating() { return rating; }

    public static class HotelBuilder {
        private String name;
        private String city;
        private double rating;

        public HotelBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HotelBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public HotelBuilder setRaiting(double rating) {
            this.rating = rating;
            return this;
        }

        public Hotel build() { return new Hotel(this); }
    }

    @Override
    public String toString() {
        return String.format("Hotel{name='%s', city='%s', rating=%.2f}", name, city, rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;
        return Double.compare(hotel.rating, rating) == 0 &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(name, hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, rating);
    }

    @Override
    public int compareTo(Hotel other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }

        int cityCompare = this.city.compareTo(other.city);
        if (cityCompare != 0) {
            return cityCompare;
        }

        double rating1 = Math.round(this.rating * 100.0) / 100.0;
        double rating2 = Math.round(other.rating * 100.0) / 100.0;
        return Double.compare(rating1, rating2);
    }
}
