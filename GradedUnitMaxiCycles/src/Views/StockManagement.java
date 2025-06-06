

package Views;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Models.Address;
import Models.Order;
import Models.Product;
import Models.ProductManager;
import Models.ProductTag;
import Models.StockOrder;
import Models.User;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucal
 */
public class StockManagement extends javax.swing.JFrame {

    User loadedUser;
    Order loadedBasket;
    JFileChooser fileChooser;
            ProductManager pManager = new ProductManager();

    /**
     * Creates new form StockManager
     */
    public StockManagement(User user, Order order) {
        initComponents();
        loadedBasket = order;
        loadedUser = user;
        //loads products of database into hashmap
        HashMap<Integer, Product> products = pManager.LoadProducts();
        //gets product table model
        
        DefaultTableModel productTableModel = (DefaultTableModel) tblProducts.getModel();
        
        //creates new jfile chooser
        
        fileChooser = new JFileChooser();
        
        LoadProductTagTable();
        
        
        
        
        
        
        //loops through every product in the hashmap
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {

            //gets product entry
            Product actualProduct = entry.getValue();

            //adds rows to table model
            productTableModel.addRow(new Object[]{
                actualProduct.getProductId(),
                actualProduct.getName(),
                actualProduct.getDescription(),
                "Not Implemented",
                "£" + actualProduct.getPrice(),
                actualProduct.getQuantity(),
                actualProduct.getColour(),
                "Not Implemented",
                "Not Implemented",
                "Not Implemented",
                "Not Implemented"

            });

            //creates action listener for table item selection
            tblProducts.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    //gets selected Row
                    int selectedRow = tblProducts.getSelectedRow();
                    //checks if row is not null
                    if (selectedRow != -1) {
                        UpdateProductFields();
                        LoadProductTagTable((int) tblProducts.getValueAt( selectedRow, 0 ));
                    }
                }
            });
            
            
            
            
        }
        //sets stockOrders table model
        tblProducts.setModel(productTableModel);
        
        //loads stockOrders of database into hashmap
        HashMap<Integer,StockOrder> stockOrders = pManager.LoadStockOrders();
        //gets stock table model
        DefaultTableModel stockOrderTableModel = (DefaultTableModel) tblStockOrders.getModel();
        
        //loops through every product in the hashmap
        for(Map.Entry<Integer, StockOrder> entry : stockOrders.entrySet())
        {
            
            //gets StockOrder entry
            StockOrder actualStockOrder = entry.getValue();


            //gets stockorder address
            Address address = actualStockOrder.getAddress();
            //creates address string
            String addressString = address.getStreet() + "\\n" + address.getTown() + "\\n" + address.getCity() + "\\n" + address.getCountry() + "\\n" + address.getPostCode();
            //adds rows to table model
            stockOrderTableModel.addRow(new Object[]{
                //public StockOrder(int stockOrderId, boolean hasArrived, int stockOrderQuantity, Date dateOrdered, Product product , Address address)
                actualStockOrder.getStockOrderId(),
                actualStockOrder.getHasArrived(),
                actualStockOrder.getStockOrderQuantity(),
                actualStockOrder.getDateOrdered(),
                actualStockOrder.getProduct().getName(),
                addressString
                
            });
            
            
            
            
        }
        //sets product table model
        tblStockOrders.setModel(stockOrderTableModel);
        
        
        
        
        
        
        
        
        
    }
    
    public void LoadProductTagTable()
    {
        //loads productTags of database into hashmap
        HashMap<Integer,ProductTag> productTags = pManager.LoadProductTags();
        
        //gets product tag table model
        DefaultTableModel productTagTableModel = (DefaultTableModel) tblProductTags.getModel();
        
        
        //resets table row count to 1
        productTagTableModel.setRowCount(1);
        
        
        //loops through every product tag in the hashmap
        for(Map.Entry<Integer, ProductTag> entry : productTags.entrySet())
        {
            
            //gets product tag entry
            ProductTag actualProductTag = entry.getValue();


   
            //adds rows to table model
            productTagTableModel.addRow(new Object[]{
                //public ProductTag(int productTagId, String productTagName, boolean isRanged,String tagValue, List<Integer> productIds)
                actualProductTag.getProductTagId(),
                actualProductTag.getProductTagName(),
                actualProductTag.getIsRanged(),
                actualProductTag.getTagValue()
                
                
            });
            
            
            
            
        }
        //sets product table model
        tblProductTags.setModel(productTagTableModel);
    }
    
    public void LoadProductTagTable(int id)
    {
        //loads productTags of database into hashmap
        HashMap<Integer,ProductTag> productTags = pManager.LoadProductTags();
        
        //gets product tag table model
        DefaultTableModel productTagTableModel = (DefaultTableModel) tblProductTags.getModel();
        //resets table row count to 1
        productTagTableModel.setRowCount(1);
        //loops through every product tag in the hashmap
        for(Map.Entry<Integer, ProductTag> entry : productTags.entrySet())
        {
            
            //gets product tag entry
            ProductTag actualProductTag = entry.getValue();
            if(actualProductTag.getProductIds().contains(id)){
                //adds rows to table model
               productTagTableModel.addRow(new Object[]{
                //public ProductTag(int productTagId, String productTagName, boolean isRanged,String tagValue, List<Integer> productIds)
                actualProductTag.getProductTagId(),
                actualProductTag.getProductTagName(),
                actualProductTag.getIsRanged(),
                actualProductTag.getTagValue()
                
                
            });
    
            }


   
            
            
            
            
            
        }
        //sets product table model
        tblProductTags.setModel(productTagTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnDeleteProduct = new javax.swing.JButton();
        pnlMakeStockOrder = new javax.swing.JPanel();
        lblStockOrderQuantity = new javax.swing.JLabel();
        lblStreet = new javax.swing.JLabel();
        lblTown = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblPostCode = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        btnOrderMoreStock = new javax.swing.JButton();
        pnlManageStockOrders = new javax.swing.JPanel();
        lblOrderQuantity = new javax.swing.JLabel();
        lblOrderStreet = new javax.swing.JLabel();
        lblOrderTown = new javax.swing.JLabel();
        lblOrderCity = new javax.swing.JLabel();
        lblOrderCountry = new javax.swing.JLabel();
        lblOrderPostCode = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        txtOrderStreet = new javax.swing.JTextField();
        txtOrderCity = new javax.swing.JTextField();
        txtOrderTown = new javax.swing.JTextField();
        txtOrderCountry = new javax.swing.JTextField();
        txtOrderPostCode = new javax.swing.JTextField();
        btnEditORder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStockOrders = new javax.swing.JTable();
        btnCancelOrder = new javax.swing.JButton();
        pnlManageProduct = new javax.swing.JPanel();
        txtProductName = new javax.swing.JTextField();
        lblProductName = new javax.swing.JLabel();
        lblProductDescription = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtProductDescription = new javax.swing.JTextArea();
        lblModel = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        lblColour = new javax.swing.JLabel();
        txtSupplier = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        lblProductPrice = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtColour = new javax.swing.JTextField();
        lblMake = new javax.swing.JLabel();
        btnEditProduct = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        lblProductIcon = new javax.swing.JLabel();
        btnUploadImage = new javax.swing.JButton();
        lblSupplier = new javax.swing.JLabel();
        txtMake = new javax.swing.JTextField();
        lblProductQuantity = new javax.swing.JLabel();
        txtProductQuantity = new javax.swing.JTextField();
        pnlManagerTags = new javax.swing.JPanel();
        btnViewTags = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblProductTags = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        RemoveTag = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblRemoveTag = new javax.swing.JTextField();
        ckBoxIsScalable = new javax.swing.JCheckBox();
        lblTags = new javax.swing.JLabel();
        btnCreateTag = new javax.swing.JButton();
        btnEditTag = new javax.swing.JButton();
        btnDeleteTag = new javax.swing.JButton();
        btnViewProductTags = new javax.swing.JButton();
        pnlManageOffers = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOffers = new javax.swing.JTable();
        btnAddOffer = new javax.swing.JTextField();
        btnEditOffer = new javax.swing.JTextField();
        btnRemoveOffer = new javax.swing.JTextField();
        lblOffers = new javax.swing.JLabel();
        lblOfferQuantity = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        txtOfferQuantity = new javax.swing.JTextField();
        txtDiscountQuantity = new javax.swing.JTextField();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductId", "ProductName", "ProductDescription", "Tags", "ProductPrice", "StockAmount", "Colour", "Gender", "Brand", "Frame", "Image", "Offers"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        btnDeleteProduct.setText("Delete");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        lblStockOrderQuantity.setText("Quantity");

        lblStreet.setText("Street");

        lblTown.setText("Town");

        lblCity.setText("City");

        lblCountry.setText("Country");

        lblPostCode.setText("PostCode");

        btnOrderMoreStock.setText("Order More Stock");

        javax.swing.GroupLayout pnlMakeStockOrderLayout = new javax.swing.GroupLayout(pnlMakeStockOrder);
        pnlMakeStockOrder.setLayout(pnlMakeStockOrderLayout);
        pnlMakeStockOrderLayout.setHorizontalGroup(
            pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMakeStockOrderLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMakeStockOrderLayout.createSequentialGroup()
                            .addComponent(lblStreet)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMakeStockOrderLayout.createSequentialGroup()
                            .addComponent(lblStockOrderQuantity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMakeStockOrderLayout.createSequentialGroup()
                        .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTown)
                            .addComponent(lblCity)
                            .addComponent(lblCountry)
                            .addComponent(lblPostCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnOrderMoreStock))
                .addContainerGap())
        );
        pnlMakeStockOrderLayout.setVerticalGroup(
            pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMakeStockOrderLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStockOrderQuantity)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStreet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMakeStockOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPostCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrderMoreStock)
                .addContainerGap())
        );

        lblOrderQuantity.setText("Quantity");

        lblOrderStreet.setText("Street");

        lblOrderTown.setText("Town");

        lblOrderCity.setText("City");

        lblOrderCountry.setText("Country");

        lblOrderPostCode.setText("PostCode");

        btnEditORder.setText("Edit Order");

        tblStockOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Has Arrived", "Quantity", "Date", "Product Id", "Address"
            }
        ));
        jScrollPane2.setViewportView(tblStockOrders);

        btnCancelOrder.setText("Cancel Order");

        javax.swing.GroupLayout pnlManageStockOrdersLayout = new javax.swing.GroupLayout(pnlManageStockOrders);
        pnlManageStockOrders.setLayout(pnlManageStockOrdersLayout);
        pnlManageStockOrdersLayout.setHorizontalGroup(
            pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageStockOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addGroup(pnlManageStockOrdersLayout.createSequentialGroup()
                        .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelOrder)
                            .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlManageStockOrdersLayout.createSequentialGroup()
                                    .addComponent(lblOrderStreet)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtOrderStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlManageStockOrdersLayout.createSequentialGroup()
                                    .addComponent(lblOrderQuantity)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtOrderQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlManageStockOrdersLayout.createSequentialGroup()
                                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrderTown)
                                    .addComponent(lblOrderCity)
                                    .addComponent(lblOrderCountry)
                                    .addComponent(lblOrderPostCode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrderCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrderTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrderCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrderPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnEditORder))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlManageStockOrdersLayout.setVerticalGroup(
            pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageStockOrdersLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderQuantity)
                    .addComponent(txtOrderQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderStreet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtOrderTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderTown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageStockOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderPostCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditORder)
                .addGap(36, 36, 36))
        );

        lblProductName.setText("Product Name");

        lblProductDescription.setText("Product Description");

        txtProductDescription.setColumns(20);
        txtProductDescription.setLineWrap(true);
        txtProductDescription.setRows(5);
        txtProductDescription.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtProductDescription);

        lblModel.setText("Model");

        lblImage.setText("Image");

        lblColour.setText("Colour");

        lblProductPrice.setText("Product Price");

        lblGender.setText("Gender");

        lblMake.setText("Make");

        btnEditProduct.setText("Edit Product");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnAddProduct.setText("Add Product");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        lblProductIcon.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        btnUploadImage.setText("Upload Image");
        btnUploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadImageActionPerformed(evt);
            }
        });

        lblSupplier.setText("Supplier");

        lblProductQuantity.setText("Quantity");

        javax.swing.GroupLayout pnlManageProductLayout = new javax.swing.GroupLayout(pnlManageProduct);
        pnlManageProduct.setLayout(pnlManageProductLayout);
        pnlManageProductLayout.setHorizontalGroup(
            pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductDescription)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addComponent(lblProductName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlManageProductLayout.createSequentialGroup()
                                    .addComponent(lblColour)
                                    .addGap(47, 47, 47)
                                    .addComponent(txtColour))
                                .addGroup(pnlManageProductLayout.createSequentialGroup()
                                    .addComponent(lblProductPrice)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtProductPrice))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageProductLayout.createSequentialGroup()
                                    .addComponent(btnEditProduct)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                    .addComponent(btnAddProduct)
                                    .addGap(8, 8, 8))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageProductLayout.createSequentialGroup()
                                    .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblGender)
                                        .addComponent(lblModel)
                                        .addComponent(lblMake)
                                        .addComponent(lblProductQuantity))
                                    .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlManageProductLayout.createSequentialGroup()
                                            .addGap(45, 45, 45)
                                            .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtModel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtGender))
                                            .addGap(8, 8, 8))
                                        .addGroup(pnlManageProductLayout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(txtMake))
                                        .addGroup(pnlManageProductLayout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(txtProductQuantity))))
                                .addGroup(pnlManageProductLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(lblSupplier)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSupplier))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage)
                .addGap(18, 18, 18)
                .addComponent(lblProductIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUploadImage)
                .addGap(21, 21, 21))
        );
        pnlManageProductLayout.setVerticalGroup(
            pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductPrice)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColour))
                .addGap(9, 9, 9)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMake)
                    .addComponent(txtMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductQuantity)
                    .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUploadImage, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProductIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier))
                .addGap(29, 29, 29)
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditProduct)
                    .addComponent(btnAddProduct))
                .addContainerGap())
        );

        btnViewTags.setText("View Tags");
        btnViewTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTagsActionPerformed(evt);
            }
        });

        tblProductTags.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag Id", "Tag Name", "Is Scalable", "Value"
            }
        ));
        jScrollPane5.setViewportView(tblProductTags);
        if (tblProductTags.getColumnModel().getColumnCount() > 0) {
            tblProductTags.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton2.setText("Add Tag");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        RemoveTag.setText("Remove Tag");
        RemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveTagActionPerformed(evt);
            }
        });

        jLabel1.setText("TagName");

        ckBoxIsScalable.setText("IsScalable");

        lblTags.setText("Tags");

        btnCreateTag.setText("Create Tag");

        btnEditTag.setText("Edit Tag");

        btnDeleteTag.setText("Delete Tag");

        btnViewProductTags.setText("View Product Tags");
        btnViewProductTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductTagsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManagerTagsLayout = new javax.swing.GroupLayout(pnlManagerTags);
        pnlManagerTags.setLayout(pnlManagerTagsLayout);
        pnlManagerTagsLayout.setHorizontalGroup(
            pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                        .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2)
                            .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(RemoveTag))
                            .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                                .addComponent(lblRemoveTag, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateTag))))
                    .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                        .addComponent(lblTags)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewProductTags)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewTags)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlManagerTagsLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlManagerTagsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ckBoxIsScalable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteTag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditTag)))
                .addContainerGap())
        );
        pnlManagerTagsLayout.setVerticalGroup(
            pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewTags)
                    .addComponent(lblTags)
                    .addComponent(btnViewProductTags))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(RemoveTag))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(ckBoxIsScalable))
                    .addGroup(pnlManagerTagsLayout.createSequentialGroup()
                        .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRemoveTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateTag))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlManagerTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditTag)
                            .addComponent(btnDeleteTag))))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        tblOffers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OfferId", "Product", "Quantity", "Discount"
            }
        ));
        jScrollPane6.setViewportView(tblOffers);
        if (tblOffers.getColumnModel().getColumnCount() > 0) {
            tblOffers.getColumnModel().getColumn(2).setResizable(false);
        }

        btnAddOffer.setText("Add Offer");

        btnEditOffer.setText("Edit Offer");

        btnRemoveOffer.setText("Remove Offer");

        lblOffers.setText("Offers");

        lblOfferQuantity.setText("Quantity");

        lblDiscount.setText("Discount");

        txtOfferQuantity.setText("jTextField7");

        txtDiscountQuantity.setText("jTextField7");

        javax.swing.GroupLayout pnlManageOffersLayout = new javax.swing.GroupLayout(pnlManageOffers);
        pnlManageOffers.setLayout(pnlManageOffersLayout);
        pnlManageOffersLayout.setHorizontalGroup(
            pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageOffersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManageOffersLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(pnlManageOffersLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAddOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoveOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlManageOffersLayout.createSequentialGroup()
                        .addGroup(pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOffers)
                            .addGroup(pnlManageOffersLayout.createSequentialGroup()
                                .addComponent(lblOfferQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtOfferQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlManageOffersLayout.createSequentialGroup()
                                .addComponent(lblDiscount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiscountQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlManageOffersLayout.setVerticalGroup(
            pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageOffersLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblOffers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOfferQuantity)
                    .addComponent(txtOfferQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiscount)
                    .addComponent(txtDiscountQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnlManageOffersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnDeleteProduct)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMakeStockOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlManageStockOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlManageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlManageOffers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlManagerTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlManageStockOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlManageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeleteProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlMakeStockOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pnlManageOffers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlManagerTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        ProductManager pManager = new ProductManager();
        
         int row = tblProducts.getSelectedRow();
        
        if(row == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Item Selected");
        }
        
        else
        {
            DefaultTableModel productTableModel = (DefaultTableModel) tblProducts.getModel();
            pManager.DeleteProduct((int) tblProducts.getValueAt(row, 0));
            productTableModel.removeRow(row);
            tblProducts.setModel(productTableModel);
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnUploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadImageActionPerformed
        // TODO add your handling code here:
        
        
        
        //opens a file chooser dialog box 
        int result = fileChooser.showOpenDialog(this);

        //checks if result variable is approved 
        if (result == JFileChooser.APPROVE_OPTION) {
            //creates file using the selected file
            File selectedFile = fileChooser.getSelectedFile();
            try {
                //creates biffered image and sets it as the selected file
                BufferedImage img = ImageIO.read(selectedFile);
                //scales image to label icon
                Image scaledImg = img.getScaledInstance(lblProductIcon.getWidth(), lblProductIcon.getHeight(), Image.SCALE_SMOOTH);
                
                //sets label icon to image
                lblProductIcon.setIcon(new ImageIcon(scaledImg));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to load image.");
            }
        }
        
    }//GEN-LAST:event_btnUploadImageActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        

        
        try {
            //public Product( String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds)
            String name = txtProductName.getText();
            String make = txtMake.getText();
            String model = txtModel.getText();
            String description = txtProductDescription.getText();
            String colour = txtColour.getText();
            double price = Double.parseDouble(txtProductPrice.getText());
            int quantity = Integer.parseInt(txtProductQuantity.getText());
            String image = "";
            String supplierId = txtSupplier.getText();
            File selectedFile = fileChooser.getSelectedFile();
            //check if all fields are not empty

            if (name.equals("") || make.equals("") || model.equals("") || description.equals("") || colour.equals("") || price == Double.NaN  || supplierId.equals("")) {
                //display complete all fields error message
                JOptionPane.showMessageDialog(rootPane, "Please Complete All Fields");
            } else {
                try {
                    //creates buffered image and sets it as the selected file
                    BufferedImage bufferedImage = ImageIO.read(selectedFile);

                    String path = "data/images/" + selectedFile.getName() + ".png";
                    //creates new file pointing to a path in the images folder
                    File imageFile = new File("data/images/" + selectedFile.getName() + ".png");
                    //writes new  input file into images folder
                    ImageIO.write(bufferedImage, "png", imageFile);
                    //sets image as relative image file path
                    image = path;

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Failed to parse image.");
                }
                Product product = new Product(name, make, model, description, colour, price, quantity, image, supplierId, new ArrayList<>());

                ProductManager pManager = new ProductManager();

                pManager.CreateProduct(product);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Information");
        }

        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        // TODO add your handling code here:
        
        ProductManager pManager = new ProductManager();
        
        
        int row = tblProducts.getSelectedRow();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Item Selected");
            return;
        }
       
        
         
        try {

            int ProductId = (int) tblProducts.getValueAt(row, 0);

            //public Product( String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds)
            //gets all input product variables
            String name = txtProductName.getText();
            String make = txtMake.getText();
            String model = txtModel.getText();
            String description = txtProductDescription.getText();
            String colour = txtColour.getText();
            double price = Double.parseDouble(txtProductPrice.getText());
            int quantity = Integer.parseInt(txtProductQuantity.getText());
            String image = "";
            String supplierId = txtSupplier.getText();
            File selectedFile = fileChooser.getSelectedFile();
            //check if all fields are  empty
            if (name.equals("") || make.equals("") || model.equals("") || description.equals("") || colour.equals("") || price == Double.NaN  || supplierId.equals("")) {
                //display complete all fields error message
                JOptionPane.showMessageDialog(rootPane, "Please Complete All Fields");
            } else {
                try {
                    //creates buffered image and sets it as the selected file
                    BufferedImage bufferedImage = ImageIO.read(selectedFile);

                    //creates new file pointing to a path in the images folder
                    
                    String path = "data/images/" + selectedFile.getName() + ".png";
                    File imageFile = new File("data/images/" + selectedFile.getName() + ".png");
                    //writes new  input file into images folder
                    ImageIO.write(bufferedImage, "png", imageFile);
                    //sets image as relative image file path
                    image = path;

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Failed to parse image.");
                }
                Product product = new Product(ProductId, name, make, model, description, colour, price, quantity, image, supplierId, new ArrayList<>());

                

                pManager.UpdateProduct(product);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Information");
        }
        
        
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ProductManager pManager = new ProductManager();
        
         int productRow = tblProducts.getSelectedRow();
         int tagRow = tblProductTags.getSelectedRow();
         
        if(productRow == -1 || tagRow == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Tag or Product Selected");
        }
        
        else
        {
            Product product = pManager.LoadProduct((int) tblProducts.getValueAt(productRow, 0));
            ProductTag tag = pManager.LoadProductTag((int) tblProductTags.getValueAt(tagRow, 0));
            DefaultTableModel productTableModel = (DefaultTableModel) tblProducts.getModel();
            pManager.AddProductTagToProduct(tag ,  product);
            tblProducts.setModel(productTableModel);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnViewTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTagsActionPerformed
        // TODO add your handling code here:
        
        LoadProductTagTable();
    }//GEN-LAST:event_btnViewTagsActionPerformed

    private void RemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveTagActionPerformed
        // TODO add your handling code here:
        
        int productRow = tblProducts.getSelectedRow();
         int tagRow = tblProductTags.getSelectedRow();
         
        if(productRow == -1 || tagRow == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Tag or Product Selected");
        }
        
        else
        {
           Product product   = pManager.LoadProduct((int) tblProducts.getValueAt(productRow, 0));
           ProductTag tag   = pManager.LoadProductTag((int) tblProductTags.getValueAt(tagRow, 0));
            
            if(tag.getProductIds().contains(product.getProductId()))
            {
                
             pManager.RemoveProductTagFromProduct(product.getProductId() ,  (int) tblProductTags.getValueAt(tagRow, 0));
             JOptionPane.showMessageDialog(null, "tag removed");

            }
            else
            {
                JOptionPane.showMessageDialog(null, "this product does not have the selected tag");
            }
            
            
            LoadProductTagTable((int) tblProducts.getValueAt(productRow, 0));
        }
    }//GEN-LAST:event_RemoveTagActionPerformed

    private void btnViewProductTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductTagsActionPerformed
        // TODO add your handling code here:
        
        int productRow = tblProducts.getSelectedRow();

         
        if(productRow == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "No Product Selected");
        }
        else
        {
            LoadProductTagTable((int) tblProducts.getValueAt(productRow, 0));
        }
        
    }//GEN-LAST:event_btnViewProductTagsActionPerformed

    
    void UpdateProductFields()
    {
        ProductManager pManager = new ProductManager();
        
         int row = tblProducts.getSelectedRow();
         int ProductId = (int) tblProducts.getValueAt(row, 0);
         Product product = pManager.LoadProduct(ProductId);
         
         //public Product(int productId, String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds)
         txtProductName.setText(product.getName());
         txtMake.setText(product.getMake());
         txtModel.setText(product.getModel());
         txtProductDescription.setText(product.getDescription());
         txtColour.setText(product.getColour());
         txtProductPrice.setText(String.valueOf(product.getPrice()));
         txtProductQuantity.setText(String.valueOf(product.getQuantity())) ;
         
         
         //creates file using the selected file
            File imageFile = new File(product.getImage());
            try {
                //creates biffered image and sets it as the selected file
                BufferedImage img = ImageIO.read(imageFile);
                //scales image to label icon
                Image scaledImg = img.getScaledInstance(lblProductIcon.getWidth(), lblProductIcon.getHeight(), Image.SCALE_SMOOTH);
                
                //sets label icon to image
                lblProductIcon.setIcon(new ImageIcon(scaledImg));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to load image.");
            }
            
            txtSupplier.setText(product.getSupplierId());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RemoveTag;
    private javax.swing.JTextField btnAddOffer;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnCreateTag;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnDeleteTag;
    private javax.swing.JButton btnEditORder;
    private javax.swing.JTextField btnEditOffer;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnEditTag;
    private javax.swing.JButton btnOrderMoreStock;
    private javax.swing.JTextField btnRemoveOffer;
    private javax.swing.JButton btnUploadImage;
    private javax.swing.JButton btnViewProductTags;
    private javax.swing.JButton btnViewTags;
    private javax.swing.JCheckBox ckBoxIsScalable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMake;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblOfferQuantity;
    private javax.swing.JLabel lblOffers;
    private javax.swing.JLabel lblOrderCity;
    private javax.swing.JLabel lblOrderCountry;
    private javax.swing.JLabel lblOrderPostCode;
    private javax.swing.JLabel lblOrderQuantity;
    private javax.swing.JLabel lblOrderStreet;
    private javax.swing.JLabel lblOrderTown;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JLabel lblProductDescription;
    private javax.swing.JLabel lblProductIcon;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JLabel lblProductQuantity;
    private javax.swing.JTextField lblRemoveTag;
    private javax.swing.JLabel lblStockOrderQuantity;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTags;
    private javax.swing.JLabel lblTown;
    private javax.swing.JPanel pnlMakeStockOrder;
    private javax.swing.JPanel pnlManageOffers;
    private javax.swing.JPanel pnlManageProduct;
    private javax.swing.JPanel pnlManageStockOrders;
    private javax.swing.JPanel pnlManagerTags;
    private javax.swing.JTable tblOffers;
    private javax.swing.JTable tblProductTags;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblStockOrders;
    private javax.swing.JTextField txtColour;
    private javax.swing.JTextField txtDiscountQuantity;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtMake;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtOfferQuantity;
    private javax.swing.JTextField txtOrderCity;
    private javax.swing.JTextField txtOrderCountry;
    private javax.swing.JTextField txtOrderPostCode;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtOrderStreet;
    private javax.swing.JTextField txtOrderTown;
    private javax.swing.JTextArea txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txtSupplier;
    // End of variables declaration//GEN-END:variables
}
