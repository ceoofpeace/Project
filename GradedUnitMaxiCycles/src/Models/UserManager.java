package Models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucal
 */
public class UserManager 

{
    
    
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://data\\AssessmentShopDB.accdb";
    
    public User loadUser(String id)
    {
        
       HashMap<String, User> users = LoadUsers();
       
       return users.get(id);
            
            
    }
    public User logIn(String username, String password)
    {
        //creates a hashmap of Users
        HashMap<String,User> loadedUsers = LoadUsers();
        
        //checks if a User exists with the input username
        if(loadedUsers.containsKey(username))
        {
            //checks input password against Customer password
            User userWithUsername = loadedUsers.get(username);
            
            
            if(userWithUsername.getPassword().equals(password))
            {
                return userWithUsername; //password is correct
            }
            else{
                return null; //password is wrong
            }
        }
        else
        {
            return null; //incorrect username
        }
    }
    
    public HashMap<Integer,Role> loadRoles()
    {
        HashMap<Integer, Role> loadedRoles = new HashMap<Integer, Role>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every User entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM Roles LEFT JOIN Users ON Users.RoleId = Roles.RoleId");
            
            //loops through each User entry
            while(rs.next())
            {
                int id = rs.getInt("RoleId");
                String roleName = rs.getString("RoleName");
                String username = rs.getString("UserName");
                
                Role role;
                if(!loadedRoles.containsKey(id))
                {
                    role = new Role(id,roleName,new ArrayList<>());
                    loadedRoles.put(id,role);
                }
                else
                {
                    role = loadedRoles.get(id);
                    role.AddUserId(username);
                    loadedRoles.put(id, role);
                    
                }

                
            }
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Roles: " + ex.getMessage());
        }
        finally
        {
            return loadedRoles;
        }
    }
    
    
    
    public Role LoadRole(int id)
    {
        return loadRoles().get(id);
    }
    
    public Role LoadRoleByName(String name)
    {
        HashMap<Integer,Role> roles = loadRoles();
        
        for (Map.Entry<Integer, Role> entry : roles.entrySet()) {
            if(entry.getValue().getRoleName().equals(name))
            {
                return entry.getValue();
            }
            
        }
        
        return null;
    }
    
    
   
    
    public HashMap<String, User> LoadUsers()
    {
        HashMap<String, User> loadedUsers = new HashMap<String, User>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every User entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM Users");
            
            //loops through each User entry
            while(rs.next())
            {
                //"Username" is columns name
                
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String surname = rs.getString("Surname");
                String emailAddress = rs.getString("EmailAddress");
                String phoneNumber = rs.getString("PhoneNumber");
                Address address = loadAddresses().get(rs.getInt("AddressId"));
                int numberOfFailedLoginAttempts = rs.getInt("NumberOfFailedLoginAttempts");
                Date dateOfAccountLock = ( rs.getDate("DateOfAccountLock") == null ? null : rs.getDate("DateOfAccountLock"));
                Date dateRegistered = rs.getDate("DateRegistered");
                int roleId = rs.getInt("RoleId");
               
                User user;
                //public User(String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, List<Integer> roleIds)
                     user = new User(username, password, firstName, surname, emailAddress, phoneNumber, address, numberOfFailedLoginAttempts, dateOfAccountLock, dateRegistered, LoadRole(roleId));
                     
               //HashMap.put(KEY,VALUE) -> adds to HashMap
                loadedUsers.put(username,user);

                
                
                
                
               
                
                
            
            }
            
            rs = statement.executeQuery("SELECT * FROM Customers");
            
            while(rs.next())
            {
                //"Username" is columns name
                
                String userName = rs.getString("UserName");
                String preferredPaymentMethod = rs.getString("PreferredPaymentMethod");
                String paymentDetails = rs.getString("PaymentDetails");
                Address preferredDeliveryAddress = loadAddresses().get(rs.getInt("preferredDeliveryAddressId"));
                String companyName = (rs.getString("CompanyName") == null ? null : rs.getString("CompanyName"));
                
                User user =  loadedUsers.get(userName);
                //public Customer(String preferredPaymentMethod, String paymentDetails, Address preferredDeliveryAddress, String companyName, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role)
                Customer customer = new Customer(preferredPaymentMethod, paymentDetails, preferredDeliveryAddress, companyName, userName, user.getPassword(), user.getFirstName(), user.getSurname(), user.getEmailAddress(), user.getPhoneNumber(), user.getAddress(), user.getNumberOfFailedLoginAttempts(), user.getDateOfAccountLock(), user.getDateRegistered(), user.getRole());
                
                loadedUsers.replace(userName, customer);
                
                
                
            }
            
            rs = statement.executeQuery("SELECT * FROM Staff");
            
            while(rs.next())
            {
                //"Username" is columns name
                
                String userName = rs.getString("UserName");
                Date dateEmployed = rs.getDate("DateEmployed");
                
                User user =  loadedUsers.get(userName);
                //public Staff(Date dateEmployed, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role)
                Staff staff = new Staff(dateEmployed, userName, user.getPassword(), user.getFirstName(), user.getSurname(), user.getEmailAddress(), user.getPhoneNumber(), user.getAddress(), user.getNumberOfFailedLoginAttempts(), user.getDateOfAccountLock(),user.getDateRegistered(),  user.getRole());
                
                loadedUsers.replace(userName, staff);
                
            }
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Users: " + ex.getMessage());
        }
        finally
        {
            return loadedUsers;
        }
    }
    
    
    
    public HashMap<Integer,Address> loadAddresses()
    {
        HashMap<Integer,Address> loadedAddresses = new HashMap<Integer,Address>();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every Address entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM Addresses");
            
           
            
            //loops through each Address entry
            while(rs.next())
            {
                int addressId = rs.getInt("AddressId");
               String street = rs.getString("Street");
                String town = rs.getString("Town");
                String city = rs.getString("City");
                String country = rs.getString("Country");
                String postcode = rs.getString("PostCode");
                
                //public Address(String street, String town, String city, String country, String postCode, int addressId)
                Address address = new Address(street, town, city, country, postcode, addressId); 
                
                
                loadedAddresses.put(addressId, address);
                
                
            
            }
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Address: " + ex.getMessage());
        }
        finally
        {
            return loadedAddresses;
        }
    }
    
    public void RegisterCustomer(Customer customer)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            
            
            //public User(String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address)
            
            //inserts new customer into database
            
            
            statement.executeUpdate("Insert INTO Users"
            + "(UserName, Password, FirstName, surname, EmailAddress, PhoneNumber, AddressId, NumberOfFailedLoginAttempts, DateOfAccountLock, DateRegistered, Type) Values("
            + "'" + customer.getUserName()+ "',"
            +"'" + customer.getPassword() + "',"
            +"'" + customer.getFirstName() + "',"
            +"'" + customer.getSurname() + "',"
            +"'" + customer.getEmailAddress()+ "',"
            +"'" + customer.getPhoneNumber()+ "',"
            + customer.getAddress().getAddressId() + ","
            + customer.getNumberOfFailedLoginAttempts() + "," 
            + "Null," 
            + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "',"
            + "'Customer'," +
            + customer.getRole().getRoleId() + ")");
            
            statement.executeUpdate("Insert INTO Customers"
            + "(UserName, PreferredPaymentMethod, PaymentDetails, PreferredDeliveryAddressId, CompanyName) Values("
            + "'" + customer.getUserName()+ "',"
            + "'" + customer.getPreferredPaymentMethod()+ "',"
            + "'" + customer.getPaymentDetails()+ "',"
            + customer.getPreferredDeliveryAddress().getAddressId()+ ","
            + "'" + customer.getCompanyName()  + "')");
            
            
            
        }
        catch(Exception ex){
            System.out.println("Error Registering Customer: " + ex.getMessage());
        }
        
    }
    
    public void RegisterStaff(Staff staff)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            
            
            //public User(String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role)
            
            //inserts new customer into database
            
            
            statement.executeUpdate("Insert INTO Users"
            + "(UserName, Password, FirstName, surname, EmailAddress, PhoneNumber, AddressId, NumberOfFailedLoginAttempts, DateOfAccountLock, DateRegistered, Type, RoleId) Values("
            + "'" + staff.getUserName()+ "',"
            +"'" + staff.getPassword() + "',"
            +"'" + staff.getFirstName() + "',"
            +"'" + staff.getSurname() + "',"
            +"'" + staff.getEmailAddress()+ "',"
            +"'" + staff.getPhoneNumber()+ "',"
            + staff.getAddress().getAddressId() + ","
            + staff.getNumberOfFailedLoginAttempts() + "," 
            + "Null," 
            + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "',"
            + "'Staff'," + 
            + staff.getRole().getRoleId() + ")");
            
            
            statement.executeUpdate("Insert INTO Staff"
            + "(UserName, DateEmployed) Values("
            + "'" + staff.getUserName()+ "',"
            + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(staff.getDateEmployed()) + "')");
            
            
            
        }
        catch(Exception ex){
            System.out.println("Error Registering Staff: " + ex.getMessage());
        }
        
    }
    
    public boolean IsAddressRegistered(Address address)
    {
         HashMap<Integer, Address> addresses = loadAddresses();
         for (Map.Entry<Integer, Address> entry : addresses.entrySet()) {
            Integer key = entry.getKey();
            Address value = entry.getValue();
            
            if(value.getStreet().equals(address.getStreet()) && value.getTown().equals(address.getTown()) && value.getCity().equals(address.getCity()) && value.getPostCode().equals(address.getPostCode()) ){
                return true;
            }
            
        }
         return false;
         
    }
    
    public Address RegisterAddress(Address address)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            
            
            // public Address(String street, String town, String city, String country, String postCode)
            
            //inserts new Address into database
            
            
            statement.executeUpdate("Insert INTO Addresses"
            + "(Street, Town, City, Country, PostCode) Values("     
            + "'" + address.getStreet() + "',"
            +"'" + address.getTown()+ "',"
            +"'" + address.getCity() + "',"
            +"'" + address.getCountry() + "',"
            +"'" + address.getPostCode() + "')");
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Addresses ORDER BY AddressId DESC LIMIT 1");
            
            if(rs.next())
            {
                address.setAddressId(rs.getInt("AddressId"));
            }
            return address;

        }
        catch(Exception ex)
        {
            System.out.println("Error Registering Address: " + ex.getMessage());
            return null;
        }
    }
    
   
    public User UpdateUser(User user)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            
            
            //updates User in database
            //public User(String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, List<Integer> roleIds)
                statement.executeUpdate("UPDATE Users SET "
                + "UserName = '" + user.getUserName()+ "',"        
                + "Password = '" + user.getPassword() + "',"
                + "FirstName = '" + user.getFirstName() + "',"
                + "Surname = '" + user.getSurname() + "',"
                + "EmailAddress = '" + user.getEmailAddress() + "',"
                + "PhoneNumber = '" + user.getPhoneNumber() + "',"
                + "AddressId = " + user.getAddress().getAddressId() 
                + " WHERE UserName  = '" + user.getUserName() + "'");
            
                
                //checks if user is a customer
            if(user.getClass().getName().equals("Models.Customer"))
            {
                //updates Customer item in the database
                Customer customer = (Customer)user;
                statement.executeUpdate("UPDATE Customers SET "
                + "UserName = '" + user.getUserName()+ "'," 
                + "PreferredPaymentMethod = '" + customer.getPreferredPaymentMethod()+ "',"        
                + "PaymentDetails = '" + customer.getPaymentDetails()+ "',"
                + "CompanyName = '" + customer.getCompanyName() + "'"
                + " WHERE UserName  = '" + user.getUserName() + "'");
            }
            //checks if user is a staff member
            if(user.getClass().getName().equals("Models.Staff"))
            {
                //updates Staff member item in the database
                Staff staff = (Staff) user;
                statement.executeUpdate("UPDATE Staff SET "
                + "UserName = '" + user.getUserName()+ "'," 
                + "DateEmployed = '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(staff.getDateEmployed()) + "'"    
                + " WHERE UserName  = '" + user.getUserName() + "'");
            }
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Users ORDER BY UserName DESC LIMIT 1");
            
            if(rs.next())
            {
                user = loadUser(rs.getString("UserName"));
            }
            return user;
            
        }
        catch(Exception ex)
        {
            System.out.println("Error Updating User: " + ex.getMessage());
            return null;
        }
    }
    
    public Address LoadAddress(int id)
    {
       return loadAddresses().get(id);
    }
    
    public void ChangeUserPassword(User user, String password)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            
            
            //updates User in database
            
                statement.executeUpdate("UPDATE Users SET "     
                + "Password = '" + password  + "'"

                + " WHERE UserName  = '" + user.getUserName() + "'");
            
                
            
        }
        catch(Exception ex)
        {
            System.out.println("Error Updating User Password: " + ex.getMessage());
           
        }
    }
    
            
}
