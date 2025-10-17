/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab4;

import java.io.FileNotFoundException;
import java.time.LocalDate;

/**
 *
 * @author iislam
 */
public class EmployeeRole {

    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        productsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomerProduct.txt");
    }

 public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity) {
      try   {
            float price = 10;
            Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
            productsDatabase.readFromFile();
            productsDatabase.insertRecord(product);
            productsDatabase.saveToFile();
        } catch (FileNotFoundException x) {
            System.out.println("File Not Found.");
        }
 }
   public Product[] getListOfProducts() {
    try {
        productsDatabase.readFromFile();
        return productsDatabase.returnAllRecords().toArray(new Product[0]);
    } catch (FileNotFoundException  x) {
        System.out.println("File Not Found.");
        return new Product[0];
    }}
    public CustomerProduct[] getListOfPurchasingOperations() {
        try {
            customerProductDatabase.readFromFile();
            return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
        } catch (FileNotFoundException x) {
            System.out.println("File Not Found.");
            return new CustomerProduct[0];
        }
    }
     public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        try {
            productsDatabase.readFromFile();
            customerProductDatabase.readFromFile();
            Product product = productsDatabase.getRecord(productID);
            if (product == null) {
                System.out.println("Product not found!");
                return false;
            }
            if (product.getQuantity() == 0) {
                System.out.println("Product out of stock!");
                return false;
            }
            product.setQuantity(product.getQuantity() - 1);
            CustomerProduct cx = new CustomerProduct(customerSSN, productID, purchaseDate);
            customerProductDatabase.insertRecord(cx);
            productsDatabase.saveToFile();
            customerProductDatabase.saveToFile();
            System.out.println("Purchase successful!");
            return true;
        } catch (FileNotFoundException x) {
            System.out.println("File Not Found.");
            return false;
        }
    }
     public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        try {
            productsDatabase.readFromFile();
            customerProductDatabase.readFromFile();
            Product product = productsDatabase.getRecord(productID);
            if (product == null) 
                return -1;
            if (returnDate.isBefore(purchaseDate)) 
                return -1;
            if (customerProductDatabase.contains(customerSSN, productID, purchaseDate)) 
                return -1;
            // Ftret sma7 within 14 days
            if (returnDate.isAfter(purchaseDate.plusDays(14))) return -1;
            product.setQuantity(product.getQuantity() + 1);
            customerProductDatabase.deleteRecord(customerSSN, productID, purchaseDate);
            productsDatabase.saveToFile();
            customerProductDatabase.saveToFile();
            System.out.println("Product returned successfully!");
            return product.getPrice();
        } catch (FileNotFoundException x) {
            System.out.println("File Not Found.");
            return -1;
        }
    }
     public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        try {
            customerProductDatabase.readFromFile();
            CustomerProduct record = customerProductDatabase.findRecord(customerSSN, purchaseDate);
            if (record != null && !record.isPaid()) {
                record.setPaid(true);
                customerProductDatabase.saveToFile();
                System.out.println("Payment applied!");
                return true;
            } else {
                System.out.println("Record not found or already paid.");
            }

        } catch (FileNotFoundException x) {
            System.out.println("File Not Found.");
        }
        return false;
    }
    public void logout() {
        try {
            productsDatabase.saveToFile();
            customerProductDatabase.saveToFile();
            System.out.println("All data saved. Logged out.");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
    }
}
}   

