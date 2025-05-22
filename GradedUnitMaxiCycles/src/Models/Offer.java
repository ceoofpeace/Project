/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lucal
 */
public class Offer 
{
    private int offerId;
    private int numberOfProducts;
    private double discount;
    private Product product;
    
    //getters

    public int getOfferId() {
        return offerId;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public double getDiscount() {
        return discount;
    }

    public Product getProduct() {
        return product;
    }
    
    //setters

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    //constructors

    public Offer(int offerId, int numberOfProducts, double discount, Product product) {
        this.offerId = offerId;
        this.numberOfProducts = numberOfProducts;
        this.discount = discount;
        this.product = product;
    }
    
    
    
}
