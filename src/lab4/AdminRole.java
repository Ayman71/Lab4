package lab4;

/**
 *
 * @author husse
 */
public class AdminRole {

    private EmployeeUserDatabase database;

    public AdminRole() {   // compostion relationship as admin role is part of data base
        database = new EmployeeUserDatabase("Employees.txt");

        database.readFromFile();

    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) throws FileNotFoundException {

        // created new emp to send it when inserting it inside the insertrecord and also this is assosication process
        EmployeeUser newEmp = new EmployeeUser(employeeId, name, email, address, phoneNumber);

// duplicate employee check
        if (database.contains(employeeId)) {
            System.out.println("cant add this employee already exists");
            return;
        } else {
            database.insertRecord(newEmp);

        }

    }

    public EmployeeUser[] getListOfEmployees() {

        // had to conert it since the requirment is to return array not array list and this method returns array list 
        return database.returnAllRecords().toArray(new EmployeeUser[0]);

    }

    public void removeEmployee(String key) throws FileNotFoundException {
        if (!(database.contains(key))
                   {
            System.out.println("cant delete this employee not exsiting");
            return;

        } else {

            database.deleteRecord(key);

        }
    
    

    public void logout() throws FileNotFoundException {

        database.saveToFile();
    }
}

}
