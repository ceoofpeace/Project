package Models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucal
 */
public class Address 
{
    private String street;
    private String town;
    private String city;
    private String country;
    private String postCode;
    private int addressId;

    

    // Getters
    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getAddressId() {
        return addressId;
    }

    // Setters
    public void setStreet(String street) {
        this.street = street;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Address(String street, String town, String city, String country, String postCode, int addressId) {
        this.street = street;
        this.town = town;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.addressId = addressId;
    }
    
    public Address(String street, String town, String city, String country, String postCode) {
        this.street = street;
        this.town = town;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
        this.addressId = 0;
    }
    public Address() {
        this.street = "";
        this.town = "";
        this.city = "";
        this.country = "";
        this.postCode = "";
        this.addressId = 0;
    }
    
    
}
