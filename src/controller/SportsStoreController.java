package controller;

import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Controller for managing the sports store operations.
 * Provides CRUD operations for Products and Customers, and utility methods for filtering and sorting.
 */

public class SportsStoreController {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    // Product CRUD

    /**
     * Adds a product to the store.
     *
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        products.add(product);
    }
    /**
     * Retrieves all products in the store.
     *
     * @return List of all products.
     */
    public List<Product> getProducts() {
        return products;
    }
    /**
     * Updates an existing product's details.
     *
     * @param productID The ID of the product to update.
     * @param newName   The new name for the product.
     * @param newPrice  The new price for the product.
     * @param newSeason The new season for the product.
     */
    public void updateProduct(int productID, String newName, double newPrice, String newSeason) {
        for (Product product : products) {
            if (product.getProductID()==productID) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setSeason(newSeason);
                System.out.println("Product updated: " + product);
                return;
            }
        }
        System.out.println("Product with ID " + productID + " not found.");
    }
    /**
     * Deletes a product from the store.
     *
     * @param productID The ID of the product to delete.
     */
    public void deleteProduct(int productID) {
        products.removeIf(p -> p.getProductID() == productID);
    }

    // Customer CRUD

    /**
     * Adds a customer to the store.
     *
     * @param customer The customer to be added.
     */
    public void addCustomer(Customer customer) {customers.add(customer);}
    /**
     * Retrieves all customers in the store.
     *
     * @return List of all customers.
     */
    public List<Customer> getCustomers() {return customers;}
    /**
     * Updates an existing customer's details.
     *
     * @param customerID The ID of the customer to update.
     * @param newName    The new name for the customer.
     * @param newPlace   The new place for the customer.
     */
    public void updateCustomer(int customerID, String newName, String newPlace) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerID) {
                customer.setName(newName);
                customer.setPlace(newPlace);
                System.out.println("Customer updated: " + customer);
                return;
            }
        }
        System.out.println("Customer with ID " + customerID + " not found.");
    }
    /**
     * Deletes a customer from the store.
     *
     * @param customerID The ID of the customer to delete.
     */
    public void deleteCustomer(int customerID) {customers.removeIf(c -> c.getCustomerId() == customerID);}
    /**
     * Assigns a product to a customer by their respective IDs.
     *
     * @param customerID  The ID of the customer.
     * @param productName The name of the product to add.
     */
    public void addProducttoCustomer(int customerID, String productName) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerID) {
                for (Product product : products) {
                    if (product.getName().equals(productName)) {
                        customer.getProducts().add(product);
                    }
                }
            }
        }
        System.out.println("Product added to customer successfully!");
    }

    /**
     * Filters customers by their place.
     *
     * @param place The place to filter by.
     * @return List of customers from the specified place.
     */
    //c
    public List<Customer> filterCustomersByPlace(String place) {
        List<Customer> filtered = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getPlace().equalsIgnoreCase(place)) {
                filtered.add(customer);
            }
        }
        return filtered;
    }
    /**
     * Filters customers by the season of the products they own.
     *
     * @param season The season to filter by.
     * @return List of customers owning products for the specified season.
     */
    //d
    public List<Customer> filterCustomersByProductsSeason(String season){
        List<Customer> filtered = new ArrayList<>();
        for (Customer customer : customers) {
            for (Product product : products) {
                if (product.getSeason().equalsIgnoreCase(season)) {
                    filtered.add(customer);
                }
            }
        }
        return filtered;
    }
    /**
     * Sorts products owned by a specific customer.
     *
     * @param customerID The ID of the customer.
     * @param ascending  Whether to sort in ascending order.
     * @return List of sorted products.
     */
    //e
    public List<Product> sortProductsByCustomer(int customerID, boolean ascending) {
        List<Product> filtered = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerID) {
                filtered.addAll(customer.getProducts());
                break;
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("Customer with ID " + customerID + " has no products.");
            return filtered;
        }

        if (ascending) {
            filtered.sort(Comparator.comparing(Product::getName));
        } else {
            filtered.sort(Comparator.comparing(Product::getName).reversed());
        }

        return filtered;
    }

}
