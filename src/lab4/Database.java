/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Ayman
 */
public abstract class Database {

    ArrayList<Record> records = new ArrayList<>();

    public abstract void readFromFile() throws FileNotFoundException;

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords() {
        return records;
    }

    public abstract boolean contains(String key);

    public abstract Record getRecord(String key);

    public abstract void insertRecord(Record record) throws FileNotFoundException;

    public abstract void deleteRecord(String key) throws FileNotFoundException;

    public abstract void saveToFile() throws FileNotFoundException;

}
