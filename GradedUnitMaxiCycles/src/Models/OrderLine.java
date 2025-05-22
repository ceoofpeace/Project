/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lucal
 */
public class OrderLine 
{
    private int orderLineId;
    private int quantity;
    private int orderId;
    private Product product;
    
    //getters

    public int getOrderLineId() {
        return orderLineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }
    
    
    
    //setters

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    //constructor

    public OrderLine(int orderLineId, int quantity, int orderId, Product product) {
        this.orderLineId = orderLineId;
        this.quantity = quantity;
        this.orderId = orderId;
        this.product = product;
    }
    
    public OrderLine(int quantity, int orderId, Product product) {
        this.orderLineId = 0;
        this.quantity = quantity;
        this.orderId = orderId;
        this.product = product;
    }
    public OrderLine() {
        this.orderLineId = 0;
        this.quantity = 0;
        this.orderId = 0;
        this.product = new Product();
    }

    
    
    
}
