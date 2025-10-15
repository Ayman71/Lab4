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
public class testDatabase {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeUserDatabase employeeUserDatabase = new EmployeeUserDatabase("Employees.txt");
        employeeUserDatabase.readFromeFile();
        ArrayList<EmployeeUser> arr = employeeUserDatabase.returnAllRecords();
        
        for (int i = 0; i < arr.size(); i++) {
            System.out.println((i+1) + "- " + arr.get(i).lineRepresentation());
            
        }
        EmployeeUser e1 = new EmployeeUser("E1205", "Ahmed", "ayman.elsherif@gmail.com", "Alexandria", "01030050198");
        employeeUserDatabase.insertRecord(e1);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println((i+1) + "- " + arr.get(i).lineRepresentation());
            
        }
    }
}
