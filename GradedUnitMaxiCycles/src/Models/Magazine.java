/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author lucal
 */
public class Magazine 
{
    private int magazineId;
    private User author;
    private String title;
    private String content;
    private Date dateCreated;
    private Date dateEdited;
    private List<Integer> categoryIds;
    private HashMap<Integer, Comment> comments;
    
    //getters

    public int getMagazineId() {
        return magazineId;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateEdited() {
        return dateEdited;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public HashMap<Integer, Comment> getComments() {
        return comments;
    }
    
    
    
    

    
    
    
    //setters

    public void setMagazineId(int magazineId) {
        this.magazineId = magazineId;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateEdited(Date dateEdited) {
        this.dateEdited = dateEdited;
    }
    
    public void setCategoryIds(List<Integer> categories) {
        this.categoryIds = categories;
    }

    public void setComments(HashMap<Integer, Comment> comments) {
        this.comments = comments;
    }
    
    //adders

    public void addCategoryId(int categoryId) {
        categoryIds.add(categoryId);
    }
    
    

    //constructors

    public Magazine(int magazineId, User author, String title, String content, Date dateCreated, Date dateEdited, List<Integer> categoryIds, HashMap<Integer, Comment> comments) {
        this.magazineId = magazineId;
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        this.categoryIds = categoryIds;
        this.comments = comments;
    }
    public Magazine( User author, String title, String content, Date dateCreated, Date dateEdited, List<Integer> categoryIds, HashMap<Integer, Comment> comments) {
        this.magazineId = 0;
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        this.categoryIds = categoryIds;
        this.comments = comments;
    }
    public Magazine() {
        this.magazineId = 0;
        this.author = new User();
        this.title = "";
        this.content = "";
        this.dateCreated = new Date();
        this.dateEdited = new Date();
        this.categoryIds = new ArrayList<>();
        this.comments = new HashMap<Integer, Comment>();
    }

    
    

    

   
    
    
    
    
    
    
}
