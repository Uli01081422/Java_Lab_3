package task1.model;

import java.time.LocalDate;


public class Product {

    private int id;
    private double price;
    private String name;

    private Customer customer;
    private int count;
    private LocalDate localDate;


    public Product(final String name, final String price) {
        this.name = name;
        this.price = Double.parseDouble(price);
    }

    public Product(final int id, final String name, final String price) {
        this.id = id;
        this.name = name;
        this.price = Double.parseDouble(price);
    }

    public Product(final int id, final String name, final String price, final LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.price = Double.parseDouble(price);
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Product() {
        super();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }


    public  int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(final LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setCustomer(final String name) {
    }

}