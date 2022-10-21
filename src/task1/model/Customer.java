package task1.model;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> listProducts = new ArrayList<>();


    public Customer(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setProductsToList(final Product product) {
            for (final Product productFromList : listProducts) {
                if (productFromList.getName().equals(product.getName())) {
                    productFromList.setCount(productFromList.getCount() + 1);
                    return;
                }
            }
        product.setCount(1);
        listProducts.add(product);
    }

    public void showAllProducts() {
        for (final Product product : getListProducts()) {
            System.out.println("PRODUCT:  ("+ product.getId()+")" + " name: " + product.getName() + " price: " + product.getPrice() + " count: " + product.getCount());
        }
    }

    public void getAllCostsByTime(final String localDate1, final String localDate2) {
        final long mils1 = convertToMilliseconds(localDate1);
        final long mils2 = convertToMilliseconds(localDate2);

        final List<Product> listProductsAtTime = new ArrayList<>();

            for (final Product product : listProducts){
                final long milsProduct = product.getLocalDate().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
                if (milsProduct > mils1 && milsProduct < mils2){
                    listProductsAtTime.add(product);
                }
            }
            for (final Product product : listProductsAtTime) {
                System.out.println("PRODUCT:  ("+ product.getId()+")" + " name: " + product.getName() + " price: " + product.getPrice() + " count: " + product.getCount() + " date: " + product.getLocalDate() );
            }
    }

    public long convertToMilliseconds(final String localDate1){
        final LocalDate data1 = LocalDate.parse(localDate1);
        return data1.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
    }

}