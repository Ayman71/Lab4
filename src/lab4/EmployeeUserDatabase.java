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
public class EmployeeUserDatabase extends Database {

    public EmployeeUserDatabase(String filename) throws FileNotFoundException{
        super(filename);
        readFromFile();
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
}
