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
public class EmployeeUserDatabase {

    private ArrayList<EmployeeUser> records;
    private final String filename;

    public EmployeeUserDatabase(String filename) {
        this.filename = filename;
    }

    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        records = new ArrayList<EmployeeUser>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            EmployeeUser employeeUser = createRecordFrom(line);
            records.add(employeeUser);
        }

    }

    public EmployeeUser createRecordFrom(String line) {
        String[] tokens = line.split(",");
        String employeeID = tokens[0];
        String name = tokens[1];
        String email = tokens[2];
        String address = tokens[3];
        String phoneNumber = tokens[4];
        EmployeeUser employeeUser = new EmployeeUser(employeeID, name, email, address, phoneNumber);
        return employeeUser;
    }

    public ArrayList<EmployeeUser> returnAllRecords() {
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

    public EmployeeUser getRecord(String key) {
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

    public void insertRecord(EmployeeUser record) throws FileNotFoundException {
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
            System.out.println("No employee assocciated with this ID.");
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
