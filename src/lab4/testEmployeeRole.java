/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Ayman
 */
public class testEmployeeRole {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeRole employeeRole = new EmployeeRole();
        
        employeeRole.addProduct("P2401", "Printer 107w", "HP", "Sigma Store", 15, (float) 8700.0);
        
        employeeRole.purchaseProduct("987315211", "P2400", LocalDate.now());
        
        employeeRole.purchaseProduct("987315211", "P2398", LocalDate.now());
        
        employeeRole.purchaseProduct("987315211", "P2500", LocalDate.now());
        
        System.out.println((int) employeeRole.returnProduct("719203846", "P2398", LocalDate.of(2025, Month.OCTOBER, 12), LocalDate.EPOCH));
        
        System.out.println((int) employeeRole.returnProduct("123456789", "P2401", LocalDate.of(2025, Month.OCTOBER,3), LocalDate.EPOCH));
        
        employeeRole.applyPayment("987315211", LocalDate.EPOCH);
        
        employeeRole.applyPayment("987315211", LocalDate.EPOCH);
        
        employeeRole.applyPayment("975103248", LocalDate.of(2023, Month.OCTOBER, 10));
        
        employeeRole.logout();
    }
    
}
