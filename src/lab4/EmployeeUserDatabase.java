/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ayman
 */
public class EmployeeUserDatabase extends Database {

    private final String filename;

    public EmployeeUserDatabase(String filename) {
        this.filename = filename;
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        records = new ArrayList<Record>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Record record = createRecordFrom(line);
            records.add(record);
        }

    }

    @Override
    public Record createRecordFrom(String line) {
        String[] tokens = line.split(",");
        String employeeID = tokens[0];
        String name = tokens[1];
        String email = tokens[2];
        String address = tokens[3];
        String phoneNumber = tokens[4];
        EmployeeUser employeeUser = new EmployeeUser(employeeID, name, email, address, phoneNumber);
        return employeeUser;
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
            System.out.println("No employee assocciated with this ID.");
        }
        return null;
    }

    public void insertRecord(Record record) throws FileNotFoundException {
        records.add(record);
    }

    @Override
    public void deleteRecord(String key) throws FileNotFoundException {
        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    records.remove(i);
                }
            }
        } else {
            System.out.println("No employee assocciated with this ID.");
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
