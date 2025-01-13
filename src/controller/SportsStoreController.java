package controller;

import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class SportsStoreController {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    // Product CRUD

    //create
    public void addProduct(Product product) {
        products.add(product);
    }
    //read
    public List<Product> getProducts() {
        return products;
    }
    //update
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
    //delete
    public void deleteProduct(int productID) {
        products.removeIf(p -> p.getProductID() == productID);
    }




}
