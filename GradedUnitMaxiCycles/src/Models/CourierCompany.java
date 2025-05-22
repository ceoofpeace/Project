/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.HashMap;

/**
 *
 * @author lucal
 */
public class CourierCompany 
{
    private int courierCompanyId;
    private String courierCompanyName;
    private HashMap<Integer,Delivery> Deliveries;
    
    //getters

    public int getCourierCompanyId() {
        return courierCompanyId;
    }

    public String getCourierCompanyName() {
        return courierCompanyName;
    }

    public HashMap<Integer, Delivery> getDeliveries() {
        return Deliveries;
    }
    
    //setters

    public void setCourierCompanyId(int courierCompanyId) {
        this.courierCompanyId = courierCompanyId;
    }

    public void setCourierCompanyName(String courierCompanyName) {
        this.courierCompanyName = courierCompanyName;
    }

    public void setDeliveries(HashMap<Integer, Delivery> Deliveries) {
        this.Deliveries = Deliveries;
    }
    
    //constructor

    public CourierCompany(int courierCompanyId, String courierCompanyName, HashMap<Integer, Delivery> Deliveries) {
        this.courierCompanyId = courierCompanyId;
        this.courierCompanyName = courierCompanyName;
        this.Deliveries = Deliveries;
    }
    
    public CourierCompany( String courierCompanyName, HashMap<Integer, Delivery> Deliveries) {
        this.courierCompanyId = 0;
        this.courierCompanyName = courierCompanyName;
        this.Deliveries = Deliveries;
    }
    
    public CourierCompany( ) {
        this.courierCompanyId = 0;
        this.courierCompanyName = "";
        this.Deliveries = new HashMap<Integer,Delivery>();
    }
    
    
    
}
//