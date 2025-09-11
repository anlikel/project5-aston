package classes;

import java.util.Objects;

public class Product {
    private final String title;
    private final double price;
    private final int quantity;

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
}