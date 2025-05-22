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
public class ProductTag 
{
    private int productTagId;
    private String productTagName;
    private boolean isRanged;
    private HashMap<Integer, Product> products;

    public int getProductTagId() {
        return productTagId;
    }

    public void setProductTagId(int productTagId) {
        this.productTagId = productTagId;
    }

    public String getProductTagName() {
        return productTagName;
    }

    public void setProductTagName(String productTagName) {
        this.productTagName = productTagName;
    }

    public boolean isIsRanged() {
        return isRanged;
    }

    public void setIsRanged(boolean isRanged) {
        this.isRanged = isRanged;
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Product> products) {
        this.products = products;
    }

    public ProductTag(int productTagId, String productTagName, boolean isRanged, HashMap<Integer, Product> products) {
        this.productTagId = productTagId;
        this.productTagName = productTagName;
        this.isRanged = isRanged;
        this.products = products;
    }

    public ProductTag(String productTagName, boolean isRanged, HashMap<Integer, Product> products) {
        this.productTagId = 0;
        this.productTagName = productTagName;
        this.isRanged = isRanged;
        this.products = products;
    }

    public ProductTag() 
    {
        this.productTagId = 0;
        this.productTagName = "";
        this.isRanged = false;
        this.products = new HashMap<Integer,Product>();
    }
    
    
    
    
    
}
