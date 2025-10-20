/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;


import java.io.FileNotFoundException;

/**
 *
 * @author Ayman
 */
public class ProductDatabase extends Database {

    public ProductDatabase(String filename) throws FileNotFoundException {
        super(filename);
        readFromFile();
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] tokens = line.split(",");
        String productID = tokens[0];
        String productName = tokens[1];
        String manufacturerName = tokens[2];
        String supplierName = tokens[3];
        int quantity = Integer.parseInt(tokens[4]);
        float price = Float.parseFloat(tokens[5]);
        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        return product;
    }
}
