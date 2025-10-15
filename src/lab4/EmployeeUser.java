/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author Mariam
 */
public class EmployeeUser {
    private String EmployeeId, Name, Email, Address, PhoneNumber;
    public EmployeeUser(String EmployeeId, String Name, String Email, String Address, 
String PhoneNumber)
    {
        this.EmployeeId=EmployeeId;
        this.Name=Name;
        this.Email=Email;
        this.Address=Address;
        this.PhoneNumber=PhoneNumber;
        
        
    }
    public String getEmployeeId()
    {
        return EmployeeId;
    }
    public String getName()
    {
        return Name;
    }
    public String getEmail()
    {
        return Email;
    }
     public String getAddress()
    {
        return Address;
    }
      public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    public String lineRepresentation()
    {
       return EmployeeId+","+Name+","+Email+","+Address+","+PhoneNumber;
    } 
    
    public String getSearchKey()
    {
        return EmployeeId;
    } 

}