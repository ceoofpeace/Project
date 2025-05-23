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
public class StockOrder 
{
    private int stockOrderId;
    private boolean hasArrived;
    private int stockOrderQuantity;
    private Date dateOrdered;
    private Product product;
    private Address address;
    
    //getters

    public int getStockOrderId() {
        return stockOrderId;
    }
    
    public boolean getHasArrived() {
        return hasArrived;
    }

    public int getStockOrderQuantity() {
        return stockOrderQuantity;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public Product getProduct() {
        return product;
    }
    public Address getAddress() {
        return address;
    }
    
    
    
    
    
    
    
    
    //setters

    public void setStockOrderId(int stockOrderId) {
        this.stockOrderId = stockOrderId;
    }
    
    public void setHasArrived (boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public void setStockOrderQuantity(int stockOrderQuantity) {
        this.stockOrderQuantity = stockOrderQuantity;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
    //constructors

    public StockOrder(int stockOrderId, boolean hasArrived, int stockOrderQuantity, Date dateOrdered, Product product , Address address) {
        
        this.stockOrderId = stockOrderId;
        this.hasArrived = hasArrived;
        this.stockOrderQuantity = stockOrderQuantity;
        this.dateOrdered = dateOrdered;
        this.product = product;
        this.address = address;
    }
    
    public StockOrder(int stockOrderQuantity, boolean hasArrived, Date dateOrdered, Product product, Address address) {
        this.stockOrderId = 0;
        this.hasArrived = hasArrived;
        this.stockOrderQuantity = stockOrderQuantity;
        this.dateOrdered = dateOrdered;
        this.product = product;
        this.address = address;
    }
    public StockOrder() {
        this.stockOrderId = 0;
        this.hasArrived = false;
        this.stockOrderQuantity = 0;
        this.dateOrdered = new Date();
        this.product = new Product();
        this.address = new Address();
    }
    
    
}
