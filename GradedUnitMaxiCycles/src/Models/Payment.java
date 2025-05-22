/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author lucal
 */
public class Payment 
{
    private int paymentId;
    private double paymentAmount;
    private boolean isRefunded;
    
    //getters

    public int getPaymentId() {
        return paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public boolean isIsRefunded() {
        return isRefunded;
    }

    
    //setters

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setIsRefunded(boolean isRefunded) {
        this.isRefunded = isRefunded;
    }
    
    //constructors

    public Payment(int paymentId, double paymentAmount, boolean isRefunded) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.isRefunded = isRefunded;
    }
    public Payment( double paymentAmount, boolean isRefunded) {
        this.paymentId = 0;
        this.paymentAmount = paymentAmount;
        this.isRefunded = isRefunded;
    }
     public Payment() {
        this.paymentId = 0;
        this.paymentAmount = 0;
        this.isRefunded = false;
    }
    
    
}
