/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author Mariam
 */
public class EmployeeUser implements Record {

    private final String employeeId, name, email, address, phoneNumber;

    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        return employeeId + "," + name + "," + email + "," + address + "," + phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return employeeId;
    }

}
