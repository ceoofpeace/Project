/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lucal
 */
public class Product 
{
    private int productId;
    private String name;
    private String make;
    private String model;
    private String description;
    private String colour;
    private double price;
    private int quantity;
    private String image;
    private String supplierId;
    private List<Integer> productTagIds;
    private List<Integer> stockOrderIds;
    

    //getters

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public List<Integer> getProductTagIds() {
        return productTagIds;
    }


    public List<Integer> getStockOrderIds() {
        return stockOrderIds;
    }
    
    //setters

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setProductTagIds(List<Integer> productTagIds) {
        this.productTagIds = productTagIds;
    }


    public void setStockOrderIds(List<Integer> stockOrderIds) {
        this.stockOrderIds = stockOrderIds;
    }
    
    //adders
    
    public void addStockOrderId(int id)
    {
        stockOrderIds.add(id);
    }
    public void addProductTagId(int id)
    {
        productTagIds.add(id);
    }

    
    //constructors

    public Product(int productId, String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds, List<Integer> stockOrderIds) {
        this.productId = productId;
        this.name = name;
        this.make = make;
        this.model = model;
        this.description = description;
        this.colour = colour;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.supplierId = supplierId;
        this.productTagIds = productTagIds;
        this.stockOrderIds = stockOrderIds;
    }
    
    public Product(String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds, List<Integer> stockOrderIds) {
        this.productId = 0;
        this.name = name;
        this.make = make;
        this.model = model;
        this.description = description;
        this.colour = colour;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.supplierId = supplierId;
        this.productTagIds = productTagIds;
        this.stockOrderIds = stockOrderIds;
    }
    
    public Product() {
        this.productId = 0;
        this.name = "";
        this.make = "";
        this.model = "";
        this.description = "";
        this.colour = "";
        this.price = 0;
        this.quantity = 0;
        this.image = "";
        this.supplierId = "";
        this.productTagIds = new ArrayList();
        this.stockOrderIds = new ArrayList();
    }
    
    
    
    
    
    
}
