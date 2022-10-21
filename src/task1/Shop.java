package task1;
import task1.exceptions.StorageException;
import task1.model.Check;
import task1.model.Customer;
import task1.model.Product;
import task1.model.Seller;
import task1.service.Storage;
import java.time.LocalDate;
import java.util.Scanner;

public class Shop {
    public final static Storage storage = new Storage();
    public static Customer customer;
    public static Seller seller = new Seller();
    public final static Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) throws StorageException {
        storage.addDefaultProduct();
        initUser();
    }

    private static void initUser() throws StorageException {
        System.out.println("------------------------------");
        System.out.println("Enter username: ");
        final String nameUser = sc.nextLine();
        customer = new Customer(nameUser);
        showOptionsStorage();
    }

    private static void showOptionsStorage() throws StorageException {
        System.out.println("------------------------------");
        System.out.println("Choose one of the functions: ");
        System.out.println("(1) Enter the goods");
        System.out.println("(2) Shop");
        System.out.println("(3) User");
        System.out.println("(4) The most popular product");
        System.out.println("(5) The highest income for the day");
        System.out.println("(6) Issuance of a check");
        System.out.println("Enter value: ");
        final String input = sc.nextLine();

        switch (input) {
            case "1":
                addProduct();
                break;
            case "2":
                showOptionsShop();
                break;
            case "3":
                showOptionsUser();
                break;
            case "4":
                seller.showMostPopularProduct();
                break;
            case "5":
                seller.showMostGreatestPriceProduct();
                break;
            case "6":
                giveCheck();
                break;
            default:
                System.out.println("Out of number");
                showOptionsStorage();
        }
    }

    private static void showOptionsShop() throws StorageException {
        System.out.println("------------------------------");
        System.out.println("Choose one of the functions: ");
        System.out.println("(1) Buy goods");
        System.out.println("(2) Filtering products from 5");
        System.out.println("(3) Sorting products by price");
        System.out.println("(4) Determination of the average price of products");
        System.out.println("(5) Show all products from the store");
        System.out.println("(6) BACK");
        System.out.println("Enter value: ");
        final String input = sc.nextLine();

        switch (input) {
            case "1":
                buyProduct();
                break;
            case "2":
                storage.filterByPriceList();
                showOptionsShop();
                break;
            case "3":
                storage.sortedByPriceList();
                showOptionsShop();
                break;
            case "4":
                storage.middlePriceList();
                showOptionsShop();
                break;
            case "5":
                storage.showAllProducts();
                showOptionsShop();
                break;
            case "6":
                showOptionsStorage();
                break;
            default:
                System.out.println("Out of number");
                showOptionsShop();
        }
    }

    private static void showOptionsUser() throws StorageException {
        System.out.println("------------------------------");
        System.out.println("Choose one of the functions: ");
        System.out.println("(1)Show all user expenses for a certain period of time");
        System.out.println("(2) Show the total quantity of each purchased product");
        System.out.println("(6) BACK");
        System.out.println("Enter value: ");
        final String input = sc.nextLine();

        switch (input) {
            case "1":
                putTime();
                break;
            case "2":
                customer.showAllProducts();
                break;
            case "3":
                showOptionsStorage();
                break;
            default:
                System.out.println("Out of number");
                showOptionsUser();
        }
    }

    private static void addProduct() throws StorageException {
        System.out.println("Enter the name of the product: ");
        final String nameProduct = sc.nextLine();
        if (nameProduct.isEmpty()) {
            System.out.println("ERROR :Product name is empty");
        }
        System.out.println("Enter the price of the product: ");
        final String priceProduct = sc.nextLine();

        if (priceProduct.isEmpty() || Double.parseDouble(priceProduct) < 0.0) {
            System.out.println("ERROR : The name is missing or the number is negative");
        }

        try {
            if (!nameProduct.isEmpty() && !priceProduct.isEmpty() && Double.parseDouble(priceProduct) > 0.0) {
                storage.addProduct(new Product(nameProduct, priceProduct));
            }
        } catch (final StorageException e) {
            System.out.println(e.getMessage());
        }

        showOptionsStorage();
    }

    private static void buyProduct() throws StorageException {
        storage.showAllProducts();

        System.out.println("Enter the product number:");
        final String productPosition = sc.nextLine();

        final Product product = storage.getProductByPosition(productPosition);

        final LocalDate dtNow = LocalDate.now(); // format 2022-09-10 yyyy-mm-dd

        product.setLocalDate(dtNow);
        customer.setProductsToList(product);
        product.setCustomer(customer.getName());
        seller.setPurchasedProduct(product);

        showOptionsShop();
    }

    private static void giveCheck() {
        final Check check = new Check(1, customer.getName(), customer.getListProducts());
        check.showAllCheck();
    }

    private static void putTime() {
        System.out.println("Enter 2 times in the format yyyy-mm-dd: ");
        System.out.println("1 : ");
        final String dateFirst = sc.nextLine();
        System.out.println("2 : ");
        final String dateSecond = sc.nextLine();
        customer.getAllCostsByTime(dateFirst, dateSecond);
    }

}