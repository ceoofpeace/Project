/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author lucal
 */


public class Delivery 
{
    
    public enum DeliveryType
    {
        firstClass,secondClass,courier
    }
    public enum DeliveryStatus
    {
        pending, inProgress, delivered, cancelled, toBeCollected, collected
    }
    private int deliveryId;
    private DeliveryType type;
    private DeliveryStatus status;
    private CourierCompany courierCompany;
    private Date predictedDeliveryDate;
    private Order order;
    private Address address;
    
    //getters

    public int getDeliveryId() {
        return deliveryId;
    }

    public DeliveryType getType() {
        return type;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public CourierCompany getCourierCompany() {
        return courierCompany;
    }

    public Date getPredictedDeliveryDate() {
        return predictedDeliveryDate;
    }

    public Order getOrder() {
        return order;
    }

    public Address getAddress() {
        return address;
    }
    
    //setters

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setType(DeliveryType type) {
        this.type = type;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public void setCourierCompany(CourierCompany courierCompany) {
        this.courierCompany = courierCompany;
    }

    public void setPredictedDeliveryDate(Date predictedDeliveryDate) {
        this.predictedDeliveryDate = predictedDeliveryDate;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Delivery(int deliveryId, DeliveryType type, DeliveryStatus status, CourierCompany courierCompany, Date predictedDeliveryDate, Order order, Address address) {
        this.deliveryId = deliveryId;
        this.type = type;
        this.status = status;
        this.courierCompany = courierCompany;
        this.predictedDeliveryDate = predictedDeliveryDate;
        this.order = order;
        this.address = address;
    }
    public Delivery(DeliveryType type, DeliveryStatus status, CourierCompany courierCompany, Date predictedDeliveryDate, Order order, Address address) {
        this.deliveryId = 0;
        this.type = type;
        this.status = status;
        this.courierCompany = courierCompany;
        this.predictedDeliveryDate = predictedDeliveryDate;
        this.order = order;
        this.address = address;
    }
    
    public Delivery() {
        this.deliveryId = 0;
        this.type = DeliveryType.firstClass;
        this.status = DeliveryStatus.pending;
        this.courierCompany = new CourierCompany();
        this.predictedDeliveryDate = new Date();
        this.order = new Order();
        this.address = new Address();
    }
    
    
    

    
    
    
    
    
    
    
    
}
