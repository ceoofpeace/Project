/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author lucal
 */
public class MagazineManager 
{
    UserManager uManager = new UserManager();
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://data\\AssessmentShopDB.accdb";
    
    
     public HashMap<Integer, Comment> LoadMagazaineComments(Magazine magazine)
    {
        
        HashMap<Integer, Comment> loadedComments = new HashMap<Integer, Comment>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every Magazine  entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM Comments WHERE MagazineId = " + magazine.getMagazineId());
            
            //loops through each User entry
            while(rs.next())
            {
                
                
                int commentId = rs.getInt("CommentId");   
                String author = rs.getString("Author");
                String content = rs.getString("Content");
                Date dateCreated = rs.getDate("DateCreated");
                int rating = rs.getInt("Rating");
                Date dateLastEdited = rs.getDate("DateLastEdited");
                
                
                
                
               //public Comment(int commendId, User author, String content, Date dateCreated, int rating, Date dateLastEdited, Magazine magazine)
                Comment comment = new Comment(commentId, uManager.loadUser(author), content, dateCreated, rating,dateLastEdited, magazine);
                
                //HashMap.put(KEY,VALUE) -> adds to HashMap
                loadedComments.put(commentId,comment);
                
            
            }
            
            
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Comments: " + ex.getMessage());
        }
        finally
        {
            return loadedComments;
        }
    }
     
    
    public HashMap<Integer, Magazine> LoadMagazines()
    {
        HashMap<Integer, Magazine> loadedMagazines = new HashMap<Integer, Magazine>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every Magazine  entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM MagazineMagazineCategories INNER JOIN Magazines ON MagazineMagazineCategories.MagazineId = Magazines.MagazineId  ");
            
            HashMap<Integer, Magazine> magazines = new HashMap<Integer, Magazine>();

            
            //loops through each Magazines and magazineCategory entry
            while(rs.next())
            {
                
                
                int magazineId = rs.getInt("MagazineId");
                String author = rs.getString("Author");
                String title = rs.getString("Title");
                String content = rs.getString("Content");
                Date dateCreated = rs.getDate("DateCreated");
                Date dateEdited = rs.getDate("DateEdited");
                int magazineCategoryId = rs.getInt("MagazineCategoryId");
                
                if(magazines.containsKey(magazineId))
                {
                    Magazine magazineEntry = magazines.get(magazineId);
                    magazineEntry.addCategoryId(magazineId);
                    magazines.replace(magazineId, magazineEntry);
                }
                else
                {
                    
                    //public Magazine(int magazineId, String author, String title, String content, Date dateCreated, Date dateEdited, List<Integer> categoryIds, HashMap<Integer, Comment> comments)

                    Magazine magazine = new Magazine(magazineId, uManager.loadUser(author), title, content, dateCreated, dateEdited, new ArrayList<>(), new HashMap<Integer, Comment>() );
                    
                    magazine.setComments(LoadMagazaineComments(magazine));
                    //HashMap.put(KEY,VALUE) -> adds to HashMap
                    loadedMagazines.put(magazineId,magazine);
                }
                
                
                
                
                
                
                
                
            
            }
            
            return loadedMagazines;
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Magazines: " + ex.getMessage());
        }
        finally
        {
            return loadedMagazines;
        }
    }
}
