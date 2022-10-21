package task1.service;

import task1.exceptions.StorageException;
import task1.model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class Storage {
    private static final int FULL_STORAGE = 12;
    private static final int filterCount = 5;
    private ArrayList<Product> listProducts = new ArrayList<>();

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(final ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public void addProduct(final Product product) throws StorageException {
        if (listProducts.size() <= FULL_STORAGE) {
            product.setId(listProducts.size() + 1);
            listProducts.add(product);
        } else {
            throw new StorageException("Warehouse is full");
        }
    }

    public void addDefaultProduct() {
        listProducts.add(new Product(1, "Sugar", "30"));
        listProducts.add(new Product(2, "Salt", "33"));
        listProducts.add(new Product(3, "Buckwheat", "80"));
        listProducts.add(new Product(4, "Water", "11"));
        listProducts.add(new Product(5, "Bread", "20"));
        listProducts.add(new Product(6, "Sweets", "90"));
    }

    public void showAllProducts() {
        for (final Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getName() + " price: " + product.getName());
        }
    }

    public Product getProductByPosition(final String position) {
        return listProducts.get(Integer.parseInt(position) - 1);
    }

    public void filterByPriceList() {
            listProducts.stream().filter(x -> x.getPrice() >= filterCount).forEach(x -> System.out.println("name = " + x.getName() + " price = " + x.getPrice()));

    }

    public void sortedByPriceList() {
            listProducts.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(x -> System.out.println("name = " + x.getName() + " price = " + x.getPrice()));
    }

    public void middlePriceList() throws StorageException {
            listProducts.stream().mapToDouble(Product::getPrice).average().orElseThrow(() -> new StorageException("Definition error"));
    }

}