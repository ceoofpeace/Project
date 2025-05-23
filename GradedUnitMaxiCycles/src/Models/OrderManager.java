/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucal
 */
public class OrderManager 
{
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://data\\AssessmentShopDB.accdb";
    
    public HashMap<Integer, Delivery> LoadDeliveries()
    {

        HashMap<Integer, Delivery> loadedDeliveries = new HashMap<Integer, Delivery>();
        UserManager uManager = new UserManager();

        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every Order entry in the database
            ResultSet rs = statement.executeQuery("Select * From Deliveries");
            
            //loops through each User entry
            while(rs.next())
            {
                
                int deliveryId = rs.getInt("DeliveryId");
                Delivery.DeliveryType deliveryType = Delivery.DeliveryType .valueOf( rs.getString("Deliverytype"));
                Delivery.DeliveryStatus deliveryStatus = Delivery.DeliveryStatus.valueOf( rs.getString("DeliveryStatus"));
                int courierCompanyId = rs.getInt("CourierCompanyId");
                Date predictedDeliveryDate = rs.getDate("PredictedDeliveryDate");
                int orderId = rs.getInt("OrderId");
                int addressId = rs.getInt("AddressId");
                
                
                //public Delivery(int deliveryId, DeliveryType type, DeliveryStatus status, CourierCompany courierCompany, Date predictedDeliveryDate, Order order, Address address)
                
                Delivery delivery = new Delivery(deliveryId,deliveryType ,deliveryStatus, new CourierCompany(), predictedDeliveryDate, LoadOrder(orderId),  uManager.LoadAddress(addressId) ); 
                
                
                
                loadedDeliveries.put(deliveryId, delivery);

                
               

                
                
                
               
               
                
                
            
            }
            
             return loadedDeliveries;
            
           
            
            
            
        }

        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Deliveries: " + ex.getMessage());
        }
        finally
        {
            return loadedDeliveries;
        }
    }
    
    public Order LoadOrder(int id)
    {
        return LoadOrders().get(id);
        
    }
    
    public HashMap<Integer,OrderLine> LoadOrderLines()
    {
        ProductManager pManager = new ProductManager();
        HashMap<Integer,OrderLine> LoadedOrderLines = new HashMap<Integer,OrderLine>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every OrderLine entry in the database
            ResultSet rs = statement.executeQuery("Select * From OrderLines");
            
            //loops through each User entry
            while(rs.next())
            {
                
                int orderLineId = rs.getInt("OrderLineId");
                int quantity = rs.getInt("Quantity");
                int orderId = rs.getInt("OrderId");
                int productId = rs.getInt("ProductId");
                
                //public OrderLine(int orderLineId, int quantity, int orderId, Product product)
                
                OrderLine orderline = new OrderLine(orderId, quantity, orderId, pManager.LoadProduct(productId));
                
                LoadedOrderLines.put(orderLineId, orderline);

                
               

                
                
                
                return LoadedOrderLines;
               
                
                
            
            }
            
           
            
            
            
        }
        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading OrderLines: " + ex.getMessage());
        }
        finally
        {
            return LoadedOrderLines;
        }
    }
    
    public HashMap<Integer, Order> LoadOrders(){
        
        UserManager uManager = new UserManager();
        ProductManager pManager = new ProductManager();
        HashMap<Integer, Order> loadedOrders = new HashMap<Integer, Order>();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            
            Statement statement = conn.createStatement();
            
            //gets every Order entry in the database
            ResultSet rs = statement.executeQuery("Select * From Orders");
            
            //loops through each User entry
            while(rs.next())
            {
                
                int orderId = rs.getInt("OrderId");
                Date orderDate = rs.getDate("OrderDate");
                int price = rs.getInt("Price");
                String username = rs.getString("UserName");
                int paymentId = rs.getInt("PaymentId");
                //loads haahmap of orderlines
                HashMap<Integer,OrderLine> allOrderLines = LoadOrderLines();
                //creates hashmap of Orderlines for loaded Order
                HashMap<Integer,OrderLine> orderLines = new HashMap<Integer,OrderLine>();
                //loops through orderline entries
                for (Map.Entry<Integer, OrderLine> entry : orderLines.entrySet()) {

                    
                    if(entry.getValue(). getOrderId() == orderId)
                    {
                        orderLines.put(entry.getValue(). getOrderId(), entry.getValue());
                    }
                    
                }
                
                //public Order(int orderId, Date orderDate, double Price, Customer customer, HashMap<Integer, OrderLine> orderLines, Payment payment)
                
                Order order = new Order(orderId, orderDate, price, (Customer) uManager.loadUser(username), orderLines, new Payment());
                
                
                
                loadedOrders.put(orderId, order);

                
               

                
                
                
               
               
                
                
            
            }
            
             return loadedOrders;
            
           
            
            
            
        }

        catch(Exception ex){
            //outputs error message
            System.out.println("Error loading Orders: " + ex.getMessage());
        }
        finally
        {
            return loadedOrders;
        }
    }
    public Delivery RegisterDelivery(Delivery delivery)
    {
        
        try
        {
            UserManager uManager = new UserManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            
            //public Delivery(int deliveryId, DeliveryType type, DeliveryStatus status, CourierCompany courierCompany, Date predictedDeliveryDate, Order order, Address address)
            
            delivery.setOrder(RegisterOrder(delivery.getOrder()));
            if(!uManager.IsAddressRegistered(delivery.getAddress()))
            {
                delivery.setAddress(uManager.RegisterAddress(delivery.getAddress()));
            }
            //inserts new customer into database
            statement.executeUpdate("Insert INTO Deliveries"
            + "( DeliveryType, DeliveryStatus, CourierCompanyId, PredictedDeliveryDate, OrderId, AddressId) Values("
            + "'" + delivery.getType().toString() + "',"
            + "'" + delivery.getStatus().toString() + "',"
            + delivery.getCourierCompany().getCourierCompanyId() + ","
            + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(delivery.getPredictedDeliveryDate()) + "',"
            + delivery.getOrder().getOrderId()+ "," 
            + delivery.getAddress().getAddressId() + ")");
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Deliveries ORDER BY AddressId DESC LIMIT 1");
            
            if(rs.next())
            {
                delivery.setDeliveryId(rs.getInt("DeliveryId"));
            }
            return delivery;
        }
        catch(Exception ex){
            System.out.println("Error Writing Delivery: " + ex.getMessage());
            return null;
        }
        
    }
    
    public Order RegisterOrder(Order order)
    {
        try
        {
            UserManager uManager = new UserManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            

            //public Order(int orderId, Date orderDate, double Price, Customer customer, HashMap<Integer, OrderLine> orderLines, Payment payment)
            
            //inserts new order into database
            statement.executeUpdate("Insert INTO Orders"
            + "( OrderDate, Price, UserName, PaymentId) Values("
            + "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "',"
            + "'" + order.CalculateOrderTotal()+ "',"
            + "'" + order.getCustomer().getUserName() + "',"
            + order.getPayment().getPaymentId() + ")");
            

            
            ResultSet rs = statement.executeQuery("SELECT * FROM Orders ORDER BY OrderId DESC LIMIT 1");
            
            while(rs.next())
            {
                order.setOrderId(rs.getInt("OrderId"));
                //loops through each orderline in the order
                for (Map.Entry<Integer, OrderLine> entry : order.getOrderLines().entrySet()) {
                    
                    //registers orderline while passing through the orderline and order id
                   RegisterOrderLine(entry.getValue(), order.getOrderId());
                    
                }
                return order;
            }
        }
        catch(Exception ex){
            System.out.println("Error Writing Order: " + ex.getMessage());
        }
        return order;
    }
    
    public void RegisterOrderLine(OrderLine oL, int id)
    {
        try
        {
            UserManager uManager = new UserManager();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement statement = conn.createStatement(); 
            

            //public Order(int orderId, Date orderDate, double Price, Customer customer, HashMap<Integer, OrderLine> orderLines, Payment payment)
            
            //inserts new order into database
            statement.executeUpdate("Insert INTO OrderLines"
            + "(Quantity, OrderId, ProductId) Values("
            + oL.getQuantity() + ","
            + id + ","
            + oL.getProduct().getProductId() + ")");
            

            
            
        }
        catch(Exception ex){
            System.out.println("Error Writing OrderLine: " + ex.getMessage());
        }

    }
    
    
}
