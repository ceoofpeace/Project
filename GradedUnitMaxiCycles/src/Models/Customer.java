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
public class Customer extends User
{
    private String preferredPaymentMethod;
    private String paymentDetails;
    private Address preferredDeliveryAddress; // Assuming you have the Address class
    private String companyName;

    //getters

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public Address getPreferredDeliveryAddress() {
        return preferredDeliveryAddress;
    }

    public String getCompanyName() {
        return companyName;
    }
    
    //setters

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public void setPreferredDeliveryAddress(Address preferredDeliveryAddress) {
        this.preferredDeliveryAddress = preferredDeliveryAddress;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    //constructors

    public Customer(String preferredPaymentMethod, String paymentDetails, Address preferredDeliveryAddress, String companyName, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) {
        super(userName, password, firstName, surname, emailAddress, phoneNumber, address, numberOfFailedLoginAttempts, dateOfAccountLock, dateRegistered, role);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.paymentDetails = paymentDetails;
        this.preferredDeliveryAddress = preferredDeliveryAddress;
        this.companyName = companyName;
    }
    
    public Customer(String preferredPaymentMethod, String paymentDetails, Address preferredDeliveryAddress, String companyName,  String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) {
        super( password, firstName, surname, emailAddress, phoneNumber, address, numberOfFailedLoginAttempts, dateOfAccountLock, dateRegistered, role);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.paymentDetails = paymentDetails;
        this.preferredDeliveryAddress = preferredDeliveryAddress;
        this.companyName = companyName;
    }
    
    public Customer( String userName,  String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address) {
        super(userName, password, firstName, surname, emailAddress, phoneNumber, address, 0, null, new Date(), new Role());
        this.preferredPaymentMethod = "";
        this.paymentDetails = "";
        this.preferredDeliveryAddress = new Address();
        this.companyName = "";
    }

   public Customer() {
        super( );
        this.preferredPaymentMethod = "";
        this.paymentDetails = "";
        this.preferredDeliveryAddress = new Address();
        this.companyName = companyName;
    }
    
    
}
