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
import java.util.List;
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
            
            
            
            
            
            //gets every Products and product Tags  entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM Products LEFT JOIN ProductProductTags ON ProductProductTags.ProductId = Products.ProductId   ");
            
            //loops through each User entry
            while(rs.next())
            {
                
                //gets product variables from database
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

                
                if(loadedProducts.containsKey(productId))
                {
                    Product ProductEntry = loadedProducts.get(productId);
                    
                    
                    ProductEntry.addProductTagId(productTagId);
                    loadedProducts.replace(ProductEntry.getProductId(), ProductEntry);
                }
                else
                {
                    //public Product(int productId, String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds, HashMap<Integer)
                    Product product = new Product(productId,productName,productMake,productModel,productDescription,productColour,productPrice,productQuantity,image,supplierId,new ArrayList());
                    
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
    
    public HashMap<Integer, StockOrder> LoadStockOrders()
    {
        HashMap<Integer, StockOrder> loadedStockOrders = new HashMap<Integer, StockOrder>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            
            
            
            
            //gets every Stock Order entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM StockOrders   ");
            
            //loops through each User entry
            while(rs.next())
            {
                
                //gets Stock Order variables from database
                int stockOrderId = rs.getInt("StockOrderId");   
                boolean hasArrived = rs.getBoolean("HasArrived");
                int stockOrderQuantity = rs.getInt("StockOrderQuantity");   
                
                Date dateOrdered = rs.getDate("DateOrdered");
                int productId = rs.getInt("ProductId");
                int addressId = rs.getInt("AddressId");

                //creates userManager instance
                UserManager uManager = new UserManager();
                //public StockOrder(int stockOrderId, boolean hasArrived, int stockOrderQuantity, Date dateOrdered, Product product )
                StockOrder stockOrder = new StockOrder(stockOrderId, hasArrived,stockOrderQuantity, dateOrdered, LoadProduct(productId), uManager.LoadAddress(addressId));
                    
                //HashMap.put(KEY,VALUE) -> adds to HashMap
                loadedStockOrders.put(productId,stockOrder);

            }
            
            return loadedStockOrders;

        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading StockOrders: " + ex.getMessage());
        }
        finally
        {
            return loadedStockOrders;
        }
    }
    
    public void DeleteProduct(int id)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement();       
            
            //deletes product from database
            statement.executeUpdate("DELETE FROM Products "
                    + "WHERE ProductId = " + id);
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error deleting product: " + ex.getMessage());
        }
    }
    
    public void CreateProduct(Product product)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            //public Product(int productId, String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds)
            
            //inserts new Product into database
            statement.executeUpdate("Insert INTO Products"
            + "( ProductName, ProductMake, ProductModel, ProductDescription, ProductColour, ProductPrice, ProductQuantity, Image, SupplierId) Values("
            + "'" + product.getName()+ "',"
            +"'" + product.getMake() + "',"
            +"'" + product.getModel() + "',"
            +"'" + product.getDescription() + "',"
            +"'" + product.getColour()+ "',"
            + product.getPrice() + "," 
            + product.getQuantity() + ","
            + "'" + product.getImage() + "',"
            + "'" + product.getSupplierId() + "')");
            



        }
        catch(Exception ex){
            System.out.println("Error Writing Customer: " + ex.getMessage());
        }
        
    }
    
    public void UpdateProduct(Product product) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement();

            // updates product information
            statement.executeUpdate("UPDATE Products "
                    + "SET ProductName = '" + product.getName() + "', "
                    + "ProductMake = '" + product.getMake()+ "', "
                    + "ProductModel = '" + product.getModel()+ "', "
                    + "ProductDescription = '" + product.getDescription() + "', "
                    + "ProductColour = '" + product.getColour() + "', "
                    + "ProductPrice = " + product.getPrice() + ", "
                    + "ProductQuantity = " + product.getQuantity() + ", "
                    + "Image = '" + product.getImage() + "', "
                    + "SupplierId = '" + product.getSupplierId() + "' "
                    + "WHERE ProductId = " + product.getProductId());

        } catch (Exception ex) {
            //displays error message
            System.out.println("Error Updating Product: " + ex.getMessage());
        }
    }
    
    public HashMap<Integer,Product> LoadProductsByTag(List<Integer> tagIds)
    {
        HashMap<Integer, Product> loadedProducts = new HashMap<Integer, Product>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            
            
            String searchQuery = "SELECT * FROM Products LEFT JOIN ProductProductTags ON ProductProductTags.ProductId = Products.ProductId";
            
            for (int i = 0; i < tagIds.size(); i++) 
            {
                if(i == 0)
                {
                    searchQuery += " Where ProductProductTags.ProductTagId = "  + tagIds.get(i);
                }
                else
                {
                    searchQuery += " AND ProductProductTags.ProductTagId = "  + tagIds.get(i);
                }
            }
            

            
            //gets every Products and product Tags  entry in the database
            ResultSet rs = statement.executeQuery(searchQuery);
            
            //loops through each User entry
            while(rs.next())
            {
                
                //gets product variables from database
                int productId = rs.getInt("ProductId");   


                
                if(!loadedProducts.containsKey(productId))
                {
                    loadedProducts.put(productId, LoadProduct(productId));
                }
                

            }
            
            return loadedProducts;

        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Products by tag: " + ex.getMessage());
        }
        finally
        {
            return loadedProducts;
        }
    }

    public HashMap<Integer, ProductTag> LoadProductTags()
    {
        HashMap<Integer, ProductTag> productTags = new HashMap<Integer, ProductTag>();

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);

            Statement statement = conn.createStatement();

            //gets every Products and product Tags  entry in the database
            ResultSet rs = statement.executeQuery("SELECT * FROM ProductTags LEFT JOIN ProductProductTags ON ProductProductTags.ProductTagId = ProductTags.ProductTagId  ");

            //loops through each User entry
            while (rs.next()) {

                //gets product variables from database
                int productTagId = rs.getInt("ProductTagId");
                String productTagName = rs.getString("ProductTagName");
                boolean isRanged = rs.getBoolean("IsRanged");
                String tagValue = rs.getString("TagValue");
                
                int ProductId = rs.getInt("ProductId");
                
                if(!productTags.containsKey(productTagId))
                {
                    // public ProductTag(int productTagId, String productTagName, boolean isRanged,String tagValue, HashMap<Integer, Product> products)
                    ProductTag productTag = new ProductTag(productTagId, productTagName,isRanged,tagValue,new ArrayList<>());
                    
                    //HashMap.put(KEY,VALUE) -> adds to HashMap
                    productTags.put(productTagId, productTag);
                }
                
                
                productTags.get(productTagId).addProductId(ProductId);

                

            }

            return productTags;

        } catch (Exception ex) {
            //outputs error message
            System.out.println("Error loading ProductTags: " + ex.getMessage());
        } finally {
            return productTags;
        }
        
    }
    
    public void AddProductTagToProduct(ProductTag tag, Product product)
    {

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            
            
            //inserts ProductTag product relationship into database
            statement.executeUpdate("Insert INTO ProductProductTags"
            + "( ProductId, ProductTagId) Values("
            + product.getProductId()+ ","
            + tag.getProductTagId()+ ")");
            



        }
        catch(Exception ex){
            System.out.println("Error Writing Customer: " + ex.getMessage());
        }
        
    }
    
    public ProductTag LoadProductTag(int id)
    {
       return LoadProductTags().get(id);
    }
    
    public void RemoveProductTagFromProduct(int tagId, int productId)
    {

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement();       
            
            //deletes product product tag relationship from database
            statement.executeUpdate("DELETE FROM ProductProductTags "
                    + "WHERE ProductId = " + productId + " AND ProductTagId = " + tagId);
            
            



        }
        catch(Exception ex){
            System.out.println("Error Writing Customer: " + ex.getMessage());
        }
        
    }
}
