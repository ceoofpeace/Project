/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucal
 */
public class ProductTag 
{
    private int productTagId;
    private String productTagName;
    private boolean isRanged;
    private String tagValue;
    private List<Integer> productIds;

    public int getProductTagId() {
        return productTagId;
    }

    public void setProductTagId(int productTagId) {
        this.productTagId = productTagId;
    }

    public String getProductTagName() {
        return productTagName;
    }
    public String getTagValue() {
        return tagValue;
    }

    public void setProductTagName(String productTagName) {
        this.productTagName = productTagName;
    }

    public boolean getIsRanged() {
        return isRanged;
    }

    public void setIsRanged(boolean isRanged) {
        this.isRanged = isRanged;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
    
    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }
    
    public void addProductId(int addProductId)
    {
        productIds.add(addProductId);
    }

    public ProductTag(int productTagId, String productTagName, boolean isRanged,String tagValue, List<Integer> productIds) {
        this.productTagId = productTagId;
        this.productTagName = productTagName;
        this.isRanged = isRanged;
        this.tagValue = tagValue;
        this.productIds = productIds;
    }

    public ProductTag(String productTagName, boolean isRanged,String tagValue, List<Integer> productIds) {
        this.productTagId = 0;
        this.productTagName = productTagName;
        this.isRanged = isRanged;
        this.tagValue = tagValue;
        this.productIds = productIds;
    }

    public ProductTag() 
    {
        this.productTagId = 0;
        this.productTagName = "";
        this.isRanged = false;
        this.tagValue = "";
        this.productIds = new ArrayList<>();
    }
    
    
    
    
    
}
