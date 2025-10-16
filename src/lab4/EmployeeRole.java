/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab4;

/**
 *
 * @author iislam
 */
public class EmployeeRole {

    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        productsDatabase = new ProductDatabase();
        customerProductDatabase = new CustomerProductDatabase();
    }

    public void addProduct(String productID, String productName, String manufacturerName,
                           String supplierName, int quantity) {
        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity);
        productsDatabase.addProduct(product);
        productsDatabase.saveToFile("Products.txt");
    }

    public Product[] getListOfProducts() {
        return productsDatabase.getAllProducts();
    }
}
