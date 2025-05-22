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
 * @author lucal
 */
public class User 
{
    private String userName;
    private String password;
    private String firstName;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private Address address; // Assuming you have an Address class
    private int numberOfFailedLoginAttempts;
    private Date dateOfAccountLock; 
    private Date dateRegistered;
    private List<Integer> roleIds;
    
    //getters

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public int getNumberOfFailedLoginAttempts() {
        return numberOfFailedLoginAttempts;
    }

    public Date getDateOfAccountLock() {
        return dateOfAccountLock;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }
    
    
    
    //setters

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setNumberOfFailedLoginAttempts(int numberOfFailedLoginAttempts) {
        this.numberOfFailedLoginAttempts = numberOfFailedLoginAttempts;
    }

    public void setDateOfAccountLock(Date dateOfAccountLock) {
        this.dateOfAccountLock = dateOfAccountLock;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
    
    //constructors

    public User(String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, List<Integer> roleIds) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.numberOfFailedLoginAttempts = numberOfFailedLoginAttempts;
        this.dateOfAccountLock = dateOfAccountLock;
        this.dateRegistered = dateRegistered;
        this.roleIds = roleIds;
    }
    
    public User( String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, List<Integer> roleIds) {
        this.userName = "";
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.numberOfFailedLoginAttempts = numberOfFailedLoginAttempts;
        this.dateOfAccountLock = dateOfAccountLock;
        this.dateRegistered = dateRegistered;
        this.roleIds = roleIds;
    }
    
    public User() {
        this.userName = "";
        this.password = "";
        this.firstName = "";
        this.surname = "";
        this.emailAddress = "";
        this.phoneNumber = "";
        this.address = new Address();
        this.numberOfFailedLoginAttempts = 0;
        this.dateOfAccountLock = null;
        this.dateRegistered = new Date();
        this.roleIds = new ArrayList();
    }
    
    //adders
    
    public void addRoleId(int id)
    {
        roleIds.add(id);
    }
    
    
    
    

    
    
    
}
