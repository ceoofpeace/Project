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
public class Comment 
{
    private int commendId;
    private User author;
    private String content;
    private Date dateCreated;
    private int rating;
    private Date dateLastEdited;
    private Magazine magazine;
    
    //getters

    public int getCommendId() {
        return commendId;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getRating() {
        return rating;
    }

    public Date getDateLastEdited() {
        return dateLastEdited;
    }

    public Magazine getMagazine() {
        return magazine;
    }
    
    //setters

    public void setCommendId(int commendId) {
        this.commendId = commendId;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDateLastEdited(Date dateLastEdited) {
        this.dateLastEdited = dateLastEdited;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
    
    //constructor

    public Comment(int commendId, User author, String content, Date dateCreated, int rating, Date dateLastEdited, Magazine magazine) {
        this.commendId = commendId;
        this.author = author;
        this.content = content;
        this.dateCreated = dateCreated;
        this.rating = rating;
        this.dateLastEdited = dateLastEdited;
        this.magazine = magazine;
    }
    
    public Comment( User author, String content, Date dateCreated, int rating, Date dateLastEdited, Magazine magazine) {
        this.commendId = 0;
        this.author = author;
        this.content = content;
        this.dateCreated = dateCreated;
        this.rating = rating;
        this.dateLastEdited = dateLastEdited;
        this.magazine = magazine;
    }
    
    public Comment() {
        this.commendId = 0;
        this.author = new User();
        this.content = "";
        this.dateCreated = new Date();
        this.rating = 0;
        this.dateLastEdited = new Date();
        this.magazine = new Magazine();
    }
    
    
}
