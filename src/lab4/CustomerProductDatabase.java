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

    private final String filename;

    public CustomerProductDatabase(String filename) throws FileNotFoundException {
        this.filename = filename;
        readFromFile();
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        records = new ArrayList<Record>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Record record = createRecordFrom(line);
            insertRecord(record);
        }
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

    @Override
    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Record getRecord(String key) {
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

    public void insertRecord(Record record) throws FileNotFoundException {
        records.add(record);
        //saveToFile();
    }

    @Override
    public void deleteRecord(String key) throws FileNotFoundException {
        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    records.remove(i);
                    //saveToFile();
                }
            }
        } else {
            System.out.println("No such purchase operation found.");
        }
    }

    @Override
    public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (int i = 0; i < records.size(); i++) {
            pw.println(records.get(i).lineRepresentation());
        }
        pw.close();
    }
}

