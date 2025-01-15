package view;

import controller.SportsStoreController;
import model.Customer;
import model.Product;

import java.util.List;
import java.util.Scanner;

/**
 * Console-based UI for managing the sports store.
 */
public class SportsStoreView {

    private final SportsStoreController controller = new SportsStoreController();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Main menu.
     */
    public void start() {
        while (true) {
            System.out.println("\n----- Sports Store Management -----");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show All Products");
            System.out.println("5. Add Customer");
            System.out.println("6. Update Customer");
            System.out.println("7. Delete Customer");
            System.out.println("8. Show All Customers");
            System.out.println("9. Add Product to Customer");
            System.out.println("10.Filter Customers By Place");
            System.out.println("11.Filter Customers By Products Season");
            System.out.println("12.Sort Products By Customer");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> showAllProducts();
                case 5 -> addCustomer();
                case 6 -> updateCustomer();
                case 7 -> deleteCustomer();
                case 8 -> showAllCustomers();
                case 9 -> addProductToCustomer();
                case 10 -> filterCustomersByPlace();
                case 11 -> filterCustomersByProductsSeason();
                case 12 -> sortProductsByCustomer();

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct() {
        System.out.println("Product ID: ");
        int productID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Season: ");
        String season = scanner.nextLine();

        controller.addProduct(new Product(productID,name, price, season));
        System.out.println("Product added successfully!");
    }

    private void updateProduct() {
        System.out.println("Product ID: ");
        int productID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Name: ");
        String newName = scanner.nextLine();
        System.out.print("New Price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("New Season: ");
        String newSeason = scanner.nextLine();

        controller.updateProduct(productID, newName, newPrice, newSeason);
    }

    private void deleteProduct() {
        System.out.print("Enter the ID of the product to delete: ");
        int productID = scanner.nextInt();
        scanner.nextLine();
        controller.deleteProduct(productID);
        System.out.println("Product deleted successfully!");
    }

    private void showAllProducts() {
        if (controller.getProducts().isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        controller.getProducts().forEach(System.out::println);
    }

    private void addCustomer() {
        System.out.println("Customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Customer Place: ");
        String place = scanner.nextLine();

        controller.addCustomer(new Customer(customerID, name, place));
        System.out.println("Customer added successfully!");
    }

    private void updateCustomer() {
        System.out.println("Customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("New Customer Place: ");
        String place = scanner.nextLine();

        controller.updateCustomer(customerID, name, place);
        System.out.println("Customer updated successfully!");
    }

    private void deleteCustomer() {
        System.out.println("Customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        controller.deleteCustomer(customerID);
        System.out.println("Customer deleted successfully!");
    }

    private void showAllCustomers() {
        if (controller.getCustomers().isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        controller.getCustomers().forEach(System.out::println);}

    private void addProductToCustomer() {
        controller.getProducts().forEach(System.out::println);

        System.out.print("Enter the ID of the client who wants to buy: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the name of the product to buy: ");
        String productName = scanner.nextLine();

        controller.addProducttoCustomer(clientId, productName);
    }

    private void filterCustomersByPlace(){
        System.out.print("Enter place to filter by: ");
        String place = scanner.nextLine();
        controller.filterCustomersByPlace(place).forEach(System.out::println);
    }

    private void filterCustomersByProductsSeason(){
        System.out.print("Enter season to filter by: ");
        String season = scanner.nextLine();
        controller.filterCustomersByProductsSeason(season).forEach(System.out::println);
    }

    private void sortProductsByCustomer(){
        controller.getCustomers().forEach(System.out::println);
        System.out.print("Enter the ID of the customer: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Sort ascending? (true/false): ");
        boolean ascending = scanner.nextBoolean();

        List<Product> sortedProducts = controller.sortProductsByCustomer(customerId, ascending);
        if (sortedProducts.isEmpty()) {
            System.out.println("No products to display for this customer.");
        } else {
            sortedProducts.forEach(System.out::println);
        }
    }






}

