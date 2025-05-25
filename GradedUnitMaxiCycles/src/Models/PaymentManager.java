/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.sun.net.httpserver.HttpServer;
import java.awt.Desktop;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lucal
 */
public class PaymentManager {

    private static final Object lock = new Object();

    public boolean TryMakePayment(double price) {
        Stripe.apiKey = "sk_test_51RSFzuP8UEQWc5azx3CHp2OKO3w4T1KuYS3FG2Pw5XCItoSNcYmWLNOAy99WWrFnsEGdoRyX7luxeFkEAQG4x6kR006BMJ0674";

        try {
            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl("https://example.com/success") // Redirect here after successful payment
                    .setCancelUrl("https://example.com/cancel") // Redirect here if the user cancels
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("gbp")
                                                    .setUnitAmount((long) price) // $50.00
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName("Java Stripe License")
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();

            Session session = Session.create(params);
            String checkoutUrl = session.getUrl();
            System.out.println("Go to Stripe Checkout: " + checkoutUrl);

            // Open browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(checkoutUrl));
            }
            
             
                 try {
                

                for(int i = 0; i < 40; i++) {
                    session = Session.retrieve(session.getId());
                    System.out.println(session.getUrl().length());

                    if (session.getPaymentStatus().equals("Paid")) {

                        System.out.println("Payment successful!");
                        return true;
                    } else if (session.getUrl().isEmpty()) {
                        return false;

                    }
                    
                    Thread.sleep(3000);
                }
                session.expire();
                return false;

            } catch (Exception e) {
                System.err.println("Error retrieving session: " + e.getMessage());
            }
            

            

        } catch (Exception e) {
            System.err.println("Error creating checkout session: " + e.getMessage());
        }
        return false;
    }
    
    
}

