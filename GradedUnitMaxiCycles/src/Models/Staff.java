package Models;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30479752
 */
public class Staff extends User
{
    private Date dateEmployed;

    //getters

    public Date getDateEmployed() {
        return dateEmployed;
    }

    //setters
    public void setDateEmployed(Date dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    //constuctors

    public Staff(Date dateEmployed, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) {
        super(userName, password, firstName, surname, emailAddress, phoneNumber, address, numberOfFailedLoginAttempts, dateOfAccountLock, dateRegistered, role);
        this.dateEmployed = dateEmployed;
    }
    
    public Staff(Date dateEmployed, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) {
        super( password, firstName, surname, emailAddress, phoneNumber, address, numberOfFailedLoginAttempts, dateOfAccountLock, dateRegistered, role);
        this.dateEmployed = dateEmployed;
    }
    
   
    
    public Staff() {
        super( );
        this.dateEmployed = new Date();
    }

   
    
    
    
    
    
    
    
}
