/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import static java.lang.classfile.Attributes.code;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author lucal
 */
public class MessageManager 

{
    public void sendEmail(String email, String subject, String body)
    {
        UserManager uManager = new UserManager();
        HashMap<String,User> users = uManager.LoadUsers();
        
        
        
        // TODO add your handling code here:
        String fromEmail = "thewetdesert8@gmail.com";//studyviral2@gmail.com
        String FromEmailPassword = "dtis trds hduv bnfo";//You email Password from you want to send email
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromEmail, FromEmailPassword);
            }
        });
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            
            
            message.setText(body);
            Transport.send(message);
            
            
            
            
        }catch(Exception ex){
            System.out.println("Failed To Send Email"+ex);
        }
    }
}
