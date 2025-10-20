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
abstract public class Database {

    private final String filename;
    ArrayList<Record> records;

    public Database(String filename) {
        this.filename = filename;
        records = new ArrayList<>();
    }

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

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords() {
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

    public Record getRecord(String key) {
        if (contains(key)) {
            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).getSearchKey().equals(key)) {
                    return records.get(i);
                }
            }
        } else {
            System.out.println("No record assocciated with this search key.");
        }
        return null;
    }

    public void insertRecord(Record record) throws FileNotFoundException {
        records.add(record);
    }

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

    public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (int i = 0; i < records.size(); i++) {
            pw.println(records.get(i).lineRepresentation());
        }
        pw.close();
    }

}
