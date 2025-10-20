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
public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        AdminRole adminRole = new AdminRole();
        EmployeeRole employeeRole = new EmployeeRole();

        Record[] employees = adminRole.getListOfEmployees();
        for (Record record : employees) {
            System.out.println(record.lineRepresentation());
        }

        System.out.println("----------------------------------------------------");

        adminRole.addEmployee("E6", "Ayman", "Ayman@gmial.com", "Alexandria", "01030050198");
        adminRole.addEmployee("E7", "Hussien", "Hussein@gmial.com", "Alexandria", "01034827457");

        employees = adminRole.getListOfEmployees();
        for (Record record : employees) {
            System.out.println(record.lineRepresentation());
        }

        System.out.println("----------------------------------------------------");

        adminRole.removeEmployee("E4");
        adminRole.removeEmployee("E8"); // not in file

        employees = adminRole.getListOfEmployees();
        for (Record record : employees) {
            System.out.println(record.lineRepresentation());
        }
        adminRole.logout();
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");

        Record[] products = employeeRole.getListOfProducts();
        Record[] operations = employeeRole.getListOfPurchasingOperations();
        System.out.println("-------------------Products-----------------------");
        for (Record record : products) {
            System.out.println(record.lineRepresentation());
        }
        System.out.println("-------------------Operations-----------------------");
        for (Record record : operations) {
            System.out.println(record.lineRepresentation());
        }
        System.out.println("-------------------Products test------------------------");
        employeeRole.addProduct("P10", "Laptop Stand", "Baseus", "GadgetHub", 40, (float) 350.0);
        employeeRole.addProduct("P11", "Laptop", "MSI", "GadgetHub", 3, (float) 35000.0);
        
        System.out.println("----------------------------------------------------");
        products = employeeRole.getListOfProducts();
        for (Record record : products) {
            System.out.println(record.lineRepresentation());
        }
        System.out.println("-------------------Operations test------------------------");
        employeeRole.purchaseProduct("123456789", "P10", LocalDate.of(2025, Month.OCTOBER, 20));
        employeeRole.purchaseProduct("123456789", "P10", LocalDate.of(2025, Month.OCTOBER, 20));
        employeeRole.returnProduct("123456789", "P10", LocalDate.of(2025, Month.OCTOBER, 20), LocalDate.of(2025, Month.OCTOBER, 20));
        employeeRole.returnProduct("123456789", "P11", LocalDate.of(2025, Month.OCTOBER, 20), LocalDate.of(2025, Month.OCTOBER, 20));
        employeeRole.applyPayment("123456789", LocalDate.of(2025, Month.OCTOBER, 20));
        employeeRole.purchaseProduct("123456789", "P5", LocalDate.EPOCH); // out of stock
        employeeRole.returnProduct("987315211", "P5", LocalDate.of(2025, Month.OCTOBER, 18), LocalDate.of(2025, Month.OCTOBER, 20)); //stock increases by 1
        System.out.println("----------------------------------------------------");
        operations = employeeRole.getListOfPurchasingOperations();
        for (Record record : operations) {
            System.out.println(record.lineRepresentation());
        }
        
        
        
        employeeRole.logout();
    }
}
