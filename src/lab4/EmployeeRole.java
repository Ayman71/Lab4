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

    private final ProductDatabase productsDatabase;
    private final CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() throws FileNotFoundException {
        productsDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
        customerProductDatabase.readFromFile();
        productsDatabase.readFromFile();
       
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) throws FileNotFoundException {
        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productsDatabase.insertRecord(product);
    }

    public Product[] getListOfProducts() throws FileNotFoundException {
        return productsDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() throws FileNotFoundException {
        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) throws FileNotFoundException {
        if (!productsDatabase.contains(productID)) {
            System.out.println("Product not found!");
            return false;
        } else {
            Product product = productsDatabase.getRecord(productID);
            if (product.getQuantity() == 0) {
                System.out.println("Product out of stock!");
                return false;
            } else {
                product.setQuantity(product.getQuantity() - 1);
                CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
                customerProductDatabase.insertRecord(customerProduct);
                System.out.println("Purchase successful!");
                return true;
            }
        }
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) throws FileNotFoundException {
        CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
        if (!customerProductDatabase.contains(customerProduct.getSearchKey())) {
            System.out.println("No such purchase operation found!");
            return -1;
        } else if (!productsDatabase.contains(productID)) {
            System.out.println("No product assocciated with this ID!");
            return -1;
        } else if (returnDate.isAfter(purchaseDate.plusDays(14))) {
            System.out.println("14-Days limit exceeded!");
            return -1;
        } else {
            Product product = productsDatabase.getRecord(productID);
            productsDatabase.getRecord(productID).setQuantity(productsDatabase.getRecord(productID).getQuantity() + 1);
            customerProductDatabase.deleteRecord(customerProduct.getSearchKey());
            System.out.println("Product returned successfully!");
            double price = Double.parseDouble(product.lineRepresentation().split(",")[5]);
            return price;
        }
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) throws FileNotFoundException {
        for (CustomerProduct customerProduct : customerProductDatabase.returnAllRecords()) {
            if (customerProduct.getCustomerSSN().equals(customerSSN) && customerProduct.getPurchaseDate().equals(purchaseDate)) {
                if (!customerProduct.isPaid()) {
                    customerProductDatabase.getRecord(customerProduct.getSearchKey()).setPaid(true);
                    System.out.println("Payment updated successfully!");
                    return true;
                }
                System.out.println("Purchase operation already paid.");
                return false;
            }
        }
        System.out.println("Purchase operation not found");
            return false;
    }

    public void logout() throws FileNotFoundException {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        System.out.println("All data saved. Logged out.");
    }
}
