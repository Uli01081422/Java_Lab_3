package task1.model;

import java.util.ArrayList;
import java.util.List;

public class Check {
    private int id;
    private String nameCustomer;
    private List<Product> listProducts = new ArrayList<>();

    public Check(final int id, final String nameCustomer, final List<Product> listProducts) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.listProducts = listProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return nameCustomer;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void showAllCheck() {
        System.out.println("------------------------");
        System.out.println("Username - " + getName());

        double totalPrice = 0;
        for (final Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getName() + " price: " + product.getPrice() + " count: " + product.getCount());
            if (product.getCount() > 0) {
                totalPrice += product.getPrice() * product.getCount();
            } else {
                totalPrice += product.getPrice();
            }
        }
        System.out.println("Total = " + totalPrice);
        System.out.println("------------------------");
    }

}