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
import java.util.Map;

/**
 *
 * @author lucal
 */
public class ProductManager 
{
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://data\\AssessmentShopDB.accdb";
    
    
    
    public HashMap<Integer, Product> LoadProducts()
    {
        HashMap<Integer, Product> loadedProducts = new HashMap<Integer, Product>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            
            
            
            
            //gets every Product  entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM Products LEFT JOIN productProductTags ON productProductTags.ProductId = Products.ProductId  LEFT JOIN productStockOrders ON productStockOrders.ProductId = Products.ProductId ");
            
            //loops through each User entry
            while(rs.next())
            {
                System.out.println("test");
                
                int productId = rs.getInt("ProductId");   
                String productName = rs.getString("ProductName");
                String productMake = rs.getString("ProductMake");
                String productModel = rs.getString("ProductModel");
                String productDescription = rs.getString("ProductDescription");
                String productColour = rs.getString("ProductColour");
                double productPrice = rs.getDouble("ProductPrice");
                int productQuantity = rs.getInt("ProductQuantity");
                String image = rs.getString("Image");
                String supplierId = rs.getString("SupplierId");
                
                int productTagId = rs.getInt("ProductTagId");
                int stockOrderId = rs.getInt("StockOrderId");
                
                
                if(loadedProducts.containsKey(productId))
                {
                    Product ProductEntry = loadedProducts.get(productId);
                    
                    
                    ProductEntry.addProductTagId(productTagId);
                    ProductEntry.addStockOrderId(stockOrderId);
                    loadedProducts.replace(ProductEntry.getProductId(), ProductEntry);
                }
                else
                {
                    //public Product(int productId, String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds, HashMap<Integer, List<Integer> stockOrderIds)
                    Product product = new Product(productId,productName,productMake,productModel,productDescription,productColour,productPrice,productQuantity,image,supplierId,new ArrayList(), new ArrayList());
                    
                    //HashMap.put(KEY,VALUE) -> adds to HashMap
                    loadedProducts.put(productId,product);
                }
                
                
               
                
                
                
            
            }
            
            return loadedProducts;
            
           
            
            
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Products: " + ex.getMessage());
        }
        finally
        {
            return loadedProducts;
        }
        
    }
    
    public Product LoadProduct(int id)
    {
        try
        {
            return LoadProducts().get(id);
            
           
            
            
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Product: " + ex.getMessage());
        }
        finally
        {
            return LoadProducts().get(id);
        }
    }
    
    public void UpdateStockLevel(HashMap<Integer, OrderLine> orderLines)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement();       
            
            for (Map.Entry<Integer, OrderLine> entry : orderLines.entrySet()) {
                
                
                // decreases product stock level by selected quanitity
                statement.executeUpdate("UPDATE Products "
                    + "SET ProductQuantity = ProductQuantity -  " + entry.getValue().getQuantity() + " "
                    + "WHERE ProductId = " + entry.getValue().getProduct().getProductId());
                
            }
            
            
        }
        catch(Exception ex){
            //displays error message
            System.out.println("Error changing availability: " + ex.getMessage());
        }
    }
    
    
}
