/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ayman
 */
public class CustomerProductDatabase extends Database {

    public CustomerProductDatabase(String filename) throws FileNotFoundException {
        super(filename);
        readFromFile();
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] tokens = line.split(",");
        String customerSSN = tokens[0];
        String productID = tokens[1];
        String[] dateTokens = tokens[2].split("-");
        boolean paid = Boolean.parseBoolean(tokens[3]);
        LocalDate purchaseDate = LocalDate.of(Integer.parseInt(dateTokens[2]), Integer.parseInt(dateTokens[1]), Integer.parseInt(dateTokens[0]));
        CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProduct.setPaid(paid);
        return customerProduct;
    }
}

