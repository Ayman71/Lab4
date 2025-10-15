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
public class CustomerProductDatabase {

    private ArrayList<CustomerProduct> records;
    private final String filename;

    public CustomerProductDatabase(String filename) {
        this.filename = filename;
    }

    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        records = new ArrayList<CustomerProduct>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            CustomerProduct customerProduct = createRecordFrom(line);
            insertRecord(customerProduct);
        }
    }
    public CustomerProduct createRecordFrom(String line) {
        String[] tokens = line.split(",");
        String customerSSN = tokens[0];
        String productID = tokens[1];
        String[] dateTokens = tokens[2].split("-");
        boolean paid = Boolean.parseBoolean(tokens[3]);
        LocalDate purchaseDate =LocalDate.of(Integer.parseInt(dateTokens[2]), Integer.parseInt(dateTokens[1]), Integer.parseInt(dateTokens[0]));
        CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProduct.setPaid(paid);
        return customerProduct;
    }
    
    public ArrayList<CustomerProduct> returnAllRecords() {
        return records;
    }
    
    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    
     public CustomerProduct getRecord(String key) {
        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    return records.get(i);
                }
            }
        } else {
            System.out.println("No such purchase operation found.");
        }
        return null;
    }
     
    public void insertRecord(CustomerProduct record) throws FileNotFoundException {
        records.add(record);
        saveToFile();
    }
    
    public void deleteRecord(String key) throws FileNotFoundException {
        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    records.remove(i);
                    saveToFile();
                }
            }
        } else {
            System.out.println("No such purchase operation found.");
        }
    }
    
    public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (int i = 0; i < records.size(); i++) {
            pw.println(records.get(i).lineRepresentation());
        }
        pw.close();
    }
}
