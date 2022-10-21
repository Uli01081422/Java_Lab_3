package task1.model;

import task1.exceptions.StorageException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Seller {
    private String name;
    private List<Product> listProducts = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setPurchasedProduct(final Product product) {
        listProducts.add(product);
    }

    public void showAllProducts() {
        for (final Product product : getListProducts()) {
            System.out.println("PRODUCT:  (" + product.getId() + ")" + " name: " + product.getName() + " price: " + product.getPrice() + " customer: " + product.getName());
        }
    }

    public void showMostPopularProduct() throws StorageException {
            final Product product = listProducts.stream().max(Comparator.comparing(Product::getCount)).orElseThrow(() -> new StorageException("помилка"));
            System.out.println("Popular product : "+ product.getName() + " count : " + product.getCount());
    }

    public void showMostGreatestPriceProduct() {
            Product mostGreatestProduct = null;
            double mostGreatestProductPrice = 0;

            for(final Product product : listProducts){
                final double price = product.getPrice() * product.getCount();
                if (price > mostGreatestProductPrice){
                    mostGreatestProductPrice = price;
                    mostGreatestProduct = product;
                }
            }
            System.out.println("Product with the highest incomes is this : "+ mostGreatestProduct.getName() + " price : " + mostGreatestProduct.getPrice());
    }
}