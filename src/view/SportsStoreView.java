package view;

import controller.SportsStoreController;
import model.Customer;
import model.Product;

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
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> showAllProducts();
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
        controller.getProducts().forEach(System.out::println);
    }



}

