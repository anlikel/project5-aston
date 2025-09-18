package classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private final String title;
    private final double price;
    private final int quantity;

    @JsonCreator
    public Product(@JsonProperty("title") String title,
                   @JsonProperty("price") double price,
                   @JsonProperty("quantity") int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    private Product(ProductBuilder builder) {
        this.title = builder.title;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public static class ProductBuilder {
        private String title;
        private double price;
        private int quantity;

        public ProductBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return String.format("Product{title='%s', price=%.2f, quantity=%d}", title, price, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, quantity);
    }

    @Override
    public int compareTo(Product other) {
        int titleCompare = this.title.compareTo(other.title);
        if (titleCompare != 0) {
            return titleCompare;
        }
        double price1 = Math.round(this.price * 100.0) / 100.0;
        double price2 = Math.round(other.price * 100.0) / 100.0;
        int priceCompare = Double.compare(price1, price2);
        if (priceCompare != 0) {
            return priceCompare;
        }
        return Integer.compare(this.quantity, other.quantity);
    }
}