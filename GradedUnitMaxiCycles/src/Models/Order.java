/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucal
 */
public class Order 
{
    private int orderId;
    private Date orderDate;
    private double Price;
    private Customer customer;
    private HashMap<Integer,OrderLine> orderLines;
    private Payment payment;
    
    //getters

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getPrice() {
        return Price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public HashMap<Integer, OrderLine> getOrderLines() {
        return orderLines;
    }

    public Payment getPayment() {
        return payment;
    }
    
    //setters

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderLines(HashMap<Integer, OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    //adders
    
    public void addOrderLine(OrderLine orderLine){
        int id = orderLine.getOrderLineId();
        if(orderLines.containsKey(id))
        {
            id++;
            orderLine.setOrderLineId(id);
        }
        orderLines.put(orderLine.getOrderLineId(), orderLine);
    }
    
    //removers
    
    public void removeOrderLine(int productId){
        for (Map.Entry<Integer, OrderLine> entry : orderLines.entrySet()) {
            if(entry.getValue().getProduct().getProductId() == productId){
                orderLines.remove(entry.getKey());
            }
            
        }
    }
    
    public double CalculateOrderTotal(){
        double total = 0;
        for (Map.Entry<Integer, OrderLine> entry : orderLines.entrySet()) {
            OrderLine orderLine = entry.getValue();
            total += orderLine.getQuantity() * orderLine.getProduct().getPrice();
            
        }
        
        return total;
    }
    
    public OrderLine ExistsInOrder(Product product)
    {
        for (Map.Entry<Integer, OrderLine> entry : orderLines.entrySet()) {
            if(product.getProductId() == entry.getValue().getProduct().getProductId()){
                return entry.getValue();
            }
            
        }
        
        return null;
    }
    
    public void UpdateOrderLine(OrderLine oL)
    {
        orderLines.replace(oL.getOrderLineId(), oL);
    }

    public Order(int orderId, Date orderDate, double Price, Customer customer, HashMap<Integer, OrderLine> orderLines, Payment payment) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.Price = Price;
        this.customer = customer;
        this.orderLines = orderLines;
        this.payment = payment;
    }
    public Order( Date orderDate, double Price, Customer customer, HashMap<Integer, OrderLine> orderLines, Payment payment) {
        this.orderId = 0;
        this.orderDate = orderDate;
        this.Price = Price;
        this.customer = customer;
        this.orderLines = orderLines;
        this.payment = payment;
    }
    public Order( ) {
        this.orderId = 0;
        this.orderDate = new Date();
        this.Price = 0;
        this.customer = new Customer();
        this.orderLines = new HashMap<Integer,OrderLine>();
        this.payment = new Payment();
    }
    
    
    
    
}
