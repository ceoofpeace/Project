/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Address;
import Models.Customer;
import Models.Order;
import Models.Role;
import Models.Staff;
import Models.User;
import Models.UserManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucal
 */
public class ManageUsers extends javax.swing.JFrame {

    UserManager uManager = new UserManager();
    User loadedUser;
    Order loadedBasket;
    /**
     * Creates new form ManageUsers
     */
    public ManageUsers(User user, Order order) {
        
        loadedBasket = order;
        loadedUser = user;
        initComponents();
        
        LoadTables();
        
    }
    
    void LoadTables()
    {
        
        HashMap<String, User> users = uManager.LoadUsers();
        
        //gets model of user table
        DefaultTableModel userTableModel = (DefaultTableModel) tblUsers.getModel();

        
        
        //loops through every user in the hashmap
        for (Map.Entry<String, User> entry : users.entrySet()) {

            //gets user entry
            User actualUser = entry.getValue();
            //gets users address
            Address address = actualUser.getAddress();

            //adds rows to table model
            userTableModel.addRow(new Object[]{
                actualUser.getUserName(),
                actualUser.getEmailAddress(),
                actualUser.getFirstName(),
                actualUser.getSurname(),
               (actualUser.getClass().getName().equals("Models.Customer") ? false : true),
                actualUser.getRole().getRoleName(),
                address.getStreet() + "\n" + address.getTown()+ "\n" + address.getCity()+"\n" +  address.getCountry()+ "\n" +  address.getPostCode()+ "\n",
                

            });

            //creates action listener for table item selection
            tblUsers.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    //gets selected Row
                    int selectedRow = tblUsers.getSelectedRow();
                    //checks if row is not null
                    if (selectedRow != -1) {
                        UpdateUserFields();
                    }
                }
            });
            
            
            
            
        }
        //sets user table model
        tblUsers.setModel(userTableModel);
        
        HashMap<Integer,Role> roles = uManager.loadRoles();
        //gets model of roles table
        DefaultTableModel roleTableModel = (DefaultTableModel) tblRoles.getModel();
        for (Map.Entry<Integer, Role> entry : roles.entrySet()) {
            Role role = entry.getValue();
            
            //adds rows to table model
            roleTableModel.addRow(new Object[]{
                role.getRoleId(),
                role.getRoleName()
                
                

            });
            
        }
        
        tblRoles.setModel(roleTableModel);
    }
    void UpdateUserFields()
    {
        
        
         int row = tblUsers.getSelectedRow();
         String userId =  tblUsers.getValueAt(row, 0).toString();
         User user = uManager.loadUser(userId);
         
         //public Product(int productId, String name, String make, String model, String description, String colour, double price, int quantity, String image, String supplierId, List<Integer> productTagIds)
         txtUsername.setText(user.getUserName());
         txtFirstName.setText(user.getFirstName());
         txtLastName.setText(user.getSurname());
         txtEmailAddress.setText(user.getEmailAddress());
         txtStreet.setText(user.getAddress().getStreet());
         txtTown.setText(user.getAddress().getTown());
         txtCity.setText(user.getAddress().getCity()) ;
         txtCountry.setText(user.getAddress().getCountry()) ;
         txtPostCode.setText(user.getAddress().getPostCode()) ;
         txtPassword.setText(user.getPassword()) ;
         txtConfirmPassword.setText(user.getPassword()) ;
         txtPhoneNumber.setText(user.getPhoneNumber());

         //checks if user is a customer
         if(user.getClass().getName().equals("Models.Customer"))
         {
             //sets company name
             txtCompanyName.setText(((Customer) user).getCompanyName()) ;
             //sets is staff checkbox to false
             ckBoxIsStaffMember.setSelected(false);
             txtPreferredPaymentMethod.setText(((Customer) user).getPreferredPaymentMethod());
             txtDateEmployed.setVisible(false);
             txtCompanyName.setVisible(true);
             txtPreferredPaymentMethod.setVisible(true);
         }
         else
         {
             //sets date employed
             txtDateEmployed.setText(String.valueOf(((Staff) user).getDateEmployed())) ;
             //sets is staff checkbox to false
             ckBoxIsStaffMember.setSelected(true);
             txtDateEmployed.setVisible(true);
             txtCompanyName.setVisible(false);
             txtPreferredPaymentMethod.setVisible(false);
         }
         
         if(user.getDateOfAccountLock() != null)
         {
             txtDateOfAccountLock.setVisible(true);
             txtDateOfAccountLock.setText(String.valueOf(user.getDateOfAccountLock()));
         }
         else
         {
             ckBoxAccountLocked.setSelected(false);
             txtDateOfAccountLock.setVisible(false);
         }
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblEmailAddress = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        txtStreet = new javax.swing.JTextField();
        lblStreet = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        lblTown = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblCIty = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        txtPostCode = new javax.swing.JTextField();
        lblPostCode = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        lblCompanyName = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        ckBoxIsStaffMember = new javax.swing.JCheckBox();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JTextField();
        txtDateEmployed = new javax.swing.JTextField();
        lblDateEmployed = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        txtPreferredPaymentMethod = new javax.swing.JTextField();
        lblPreferredPaymentMethod = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        ckBoxAccountLocked = new javax.swing.JCheckBox();
        txtDateOfAccountLock = new javax.swing.JTextField();
        lblDateOfAccountLock = new javax.swing.JLabel();
        btnAddRole = new javax.swing.JButton();
        btnEditRole = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtRoleName = new javax.swing.JTextField();
        btnDeleteRole = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "email", "firstname", "surname", "isstaff", "role", "Address"
            }
        ));
        jScrollPane1.setViewportView(tblUsers);

        lblUsername.setText("UserName");

        lblFirstName.setText("First Name");

        lblLastName.setText("Last Name");

        lblEmailAddress.setText("Email Address");

        lblStreet.setText("Street");

        lblTown.setText("Town");

        lblCIty.setText("City");

        lblCountry.setText("Country");

        lblPostCode.setText("PostCode");

        lblCompanyName.setText("CompanyName");

        lblPassword.setText("Password");

        ckBoxIsStaffMember.setText("Is Staff Member");
        ckBoxIsStaffMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckBoxIsStaffMemberActionPerformed(evt);
            }
        });

        lblConfirmPassword.setText("ConfirmPassword");

        lblDateEmployed.setText("Date Employed");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RoleId", "Role Name"
            }
        ));
        jScrollPane2.setViewportView(tblRoles);

        lblPreferredPaymentMethod.setText("PreferredPayment Method");

        lblPhoneNumber.setText("PhoneNumber");

        ckBoxAccountLocked.setText("Account Locked");
        ckBoxAccountLocked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckBoxAccountLockedActionPerformed(evt);
            }
        });

        txtDateOfAccountLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateOfAccountLockActionPerformed(evt);
            }
        });

        lblDateOfAccountLock.setText("Date Of Account Lock");

        btnAddRole.setText("Add");
        btnAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoleActionPerformed(evt);
            }
        });

        btnEditRole.setText("Edit");
        btnEditRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRoleActionPerformed(evt);
            }
        });

        lblName.setText("Name");

        btnDeleteRole.setText("Delete");
        btnDeleteRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate)
                                .addGap(210, 210, 210)
                                .addComponent(btnEdit))
                            .addComponent(ckBoxIsStaffMember))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDateEmployed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDateEmployed, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDateOfAccountLock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDateOfAccountLock, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ckBoxAccountLocked, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUsername)
                                            .addComponent(lblFirstName)
                                            .addComponent(lblLastName)
                                            .addComponent(lblEmailAddress)
                                            .addComponent(lblStreet)
                                            .addComponent(lblTown)
                                            .addComponent(lblCIty)
                                            .addComponent(lblCountry)
                                            .addComponent(lblPostCode)
                                            .addComponent(lblCompanyName)
                                            .addComponent(lblPreferredPaymentMethod)
                                            .addComponent(lblPhoneNumber)
                                            .addComponent(lblPassword)
                                            .addComponent(lblConfirmPassword))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCompanyName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPostCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtStreet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmailAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPreferredPaymentMethod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 86, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddRole)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditRole)
                            .addComponent(btnDeleteRole))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirstName)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLastName)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmailAddress)
                            .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNumber)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStreet)
                            .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTown)
                            .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCIty)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountry)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPostCode)
                            .addComponent(txtPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCompanyName)
                            .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPreferredPaymentMethod)
                            .addComponent(txtPreferredPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfirmPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckBoxIsStaffMember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateEmployed)
                            .addComponent(txtDateEmployed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(ckBoxAccountLocked)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateOfAccountLock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateOfAccountLock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddRole)
                            .addComponent(lblName)
                            .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(btnEditRole)
                        .addGap(3, 3, 3)
                        .addComponent(btnDeleteRole)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        
        UserManager uManager = new UserManager();
        User userToEdit;
        try
        {
            
             //gets selected Row
             int selectedRow = tblUsers.getSelectedRow();
             if(selectedRow != -1)
             {
                 userToEdit = uManager.loadUser(tblUsers.getValueAt(selectedRow, 0).toString());
             }  
             else
             {
                 //display no selected user error messages
                JOptionPane.showMessageDialog(rootPane, "Please Select a User");
                return;
             }
            //public Staff(Date dateEmployed, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) 
            String userName = txtUsername.getText();
            String password = txtPassword.getText();
            String firstName = txtFirstName.getText();
            String surname = txtLastName.getText();
            String emailAddress = txtEmailAddress.getText();
            String phoneNumber = txtPhoneNumber.getText();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateEmployed = (ckBoxIsStaffMember.isSelected() ?  formatter.parse(txtDateEmployed.getText())  : null);
            String companyName = txtCompanyName.getText();
            String preferredPaymentMethod = txtPreferredPaymentMethod.getText();
            
            
            
        
            String street = txtStreet.getText();
            String town = txtTown.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String postCode = txtPostCode.getText();
            
            Date dateOfAccountLock;
            if(ckBoxAccountLocked.isSelected())
            {
                 dateOfAccountLock = formatter.parse(txtDateOfAccountLock.getText());
            }
            else
            {
                dateOfAccountLock = null;
            }
            //check if all fields are not empty
            if(userName.equals("") || password.equals("")  || firstName.equals("") || surname.equals("") || emailAddress.equals("") || phoneNumber.equals("") || street.equals("") || town.equals("") || city.equals("") || country.equals("") || postCode.equals("")  )
            {
                //display complete all fields error message
                JOptionPane.showMessageDialog(rootPane, "Please Complete All Fields");
            }
            else
            {
                //creates hashmap of users
                //loads users into hashmap
               HashMap<String, User> users = uManager.LoadUsers();
               
               //check if input username matches with an existing user
               if(users.containsKey(userName) && userName != userToEdit.getUserName())
               {
                   //show user already exists error message
                   JOptionPane.showMessageDialog(rootPane, "UserName Already Exists");
                   //end method
                   return;
               }

               
               //creates new address
               // public Address(String street, String town, String city, String country, String postCode)
               Address address = new Address(street, town, city, country, postCode);
               
               
               if(ckBoxIsStaffMember.isSelected())
               {
                   Staff staffToEdit = (Staff) userToEdit;
                   //creates new Staff
                   // public Staff(Date dateEmployed, String username, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, List<Integer> roleIds) {
                   Staff staff = new Staff(dateEmployed,userName, password, firstName, surname,emailAddress,phoneNumber, address, staffToEdit.getNumberOfFailedLoginAttempts() , dateOfAccountLock, staffToEdit.getDateRegistered(), uManager.LoadRole((int) tblRoles.getValueAt(tblRoles.getSelectedRow(),0)));
                   userToEdit = staff;
               }
               else
               {
                   Customer customerToEdit = (Customer) userToEdit;
                   //creates new Customer
                   //public Customer(String preferredPaymentMethod, String paymentDetails, Address preferredDeliveryAddress, String companyName, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) {
                   Customer customer = new Customer(preferredPaymentMethod, customerToEdit.getPaymentDetails(),customerToEdit.getPreferredDeliveryAddress(), companyName, userName, password,firstName, surname, emailAddress, phoneNumber, address, customerToEdit.getNumberOfFailedLoginAttempts(), dateOfAccountLock , customerToEdit.getDateRegistered(), uManager.LoadRole((int) tblRoles.getValueAt(tblRoles.getSelectedRow(),0)));
                   userToEdit = customer;
               }
               
               
               //creates hashmap of addresses
               //loads address from database into hashmap
               HashMap<Integer,Address> addresses = uManager.loadAddresses();
               
               //checks if address exists in the database
               
               if(!uManager.IsAddressRegistered(address))
               {
                   address = uManager.RegisterAddress(address);
                   userToEdit.setAddress(address);
               }
               else
               {
                   userToEdit.setAddress(uManager.GetRegisteredAddress(address));
               }

               
               
                
            
               if(ckBoxIsStaffMember.isSelected())
               {
                   uManager.RegisterStaff((Staff) userToEdit);
               }
               else
               {
                   uManager.RegisterCustomer((Customer) userToEdit);
               }
               JOptionPane.showMessageDialog(rootPane, "Registeration Successful");

               
               
               
               
               
               
               
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Information");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void ckBoxIsStaffMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckBoxIsStaffMemberActionPerformed
        // TODO add your handling code here:
        
        if(ckBoxIsStaffMember.isSelected()){
            txtDateEmployed.setVisible(true);
            txtCompanyName.setVisible(false);
            txtPreferredPaymentMethod.setVisible(false);
            txtDateEmployed.setVisible(true);
        }
        else{
             txtDateEmployed.setVisible(false);
            txtCompanyName.setVisible(true);
            txtPreferredPaymentMethod.setVisible(true);
            txtDateEmployed.setVisible(false);
        }
        
    }//GEN-LAST:event_ckBoxIsStaffMemberActionPerformed

    private void ckBoxAccountLockedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckBoxAccountLockedActionPerformed
        // TODO add your handling code here:
        if(ckBoxAccountLocked.isSelected()){
            txtDateOfAccountLock.setVisible(true);
        }
        else{
             txtDateOfAccountLock.setVisible(false);
        }
    }//GEN-LAST:event_ckBoxAccountLockedActionPerformed

    private void txtDateOfAccountLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateOfAccountLockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateOfAccountLockActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        

        User userToEdit;
        try
        {
            
             //gets selected Row
             int selectedRow = tblUsers.getSelectedRow();
             if(selectedRow != -1)
             {
                 userToEdit = uManager.loadUser(tblUsers.getValueAt(selectedRow, 0).toString());
             }  
             else
             {
                 //display no selected user error messages
                JOptionPane.showMessageDialog(null, "Please Select a User");
                return;
             }
            //public Staff(Date dateEmployed, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) 
            String userName = txtUsername.getText();
            String password = txtPassword.getText();
            String firstName = txtFirstName.getText();
            String surname = txtLastName.getText();
            String emailAddress = txtEmailAddress.getText();
            String phoneNumber = txtPhoneNumber.getText();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateEmployed = (ckBoxIsStaffMember.isSelected() ?  formatter.parse(txtDateEmployed.getText())  : null);
            String companyName = txtCompanyName.getText();
            String preferredPaymentMethod = txtPreferredPaymentMethod.getText();
            
            
            if(!userToEdit.getUserName().equals(userName))
            {
                //display cannot edit username error emssage
                JOptionPane.showMessageDialog(null, "Cannot Edit Username");
                return;
            }
        
            String street = txtStreet.getText();
            String town = txtTown.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String postCode = txtPostCode.getText();
            
            Date dateOfAccountLock;
            if(ckBoxAccountLocked.isSelected())
            {
                 dateOfAccountLock = formatter.parse(txtDateOfAccountLock.getText());
            }
            else
            {
                dateOfAccountLock = null;
            }
            //check if all fields are not empty
            if(userName.equals("") || password.equals("")  || firstName.equals("") || surname.equals("") || emailAddress.equals("") || phoneNumber.equals("") || street.equals("") || town.equals("") || city.equals("") || country.equals("") || postCode.equals("")  )
            {
                //display complete all fields error message
                JOptionPane.showMessageDialog(rootPane, "Please Complete All Fields");
            }
            else
            {
                //creates hashmap of users
                //loads users into hashmap
               HashMap<String, User> users = uManager.LoadUsers();
               
               
               
               //creates new address
               // public Address(String street, String town, String city, String country, String postCode)
               Address address = new Address(street, town, city, country, postCode);
               
               
               if(ckBoxIsStaffMember.isSelected())
               {
                   Staff staffToEdit = (Staff) userToEdit;
                   //creates new Staff
                   // public Staff(Date dateEmployed, String username, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, List<Integer> roleIds) {
                   Staff staff = new Staff(dateEmployed,userName, password, firstName, surname,emailAddress,phoneNumber, address, staffToEdit.getNumberOfFailedLoginAttempts() , dateOfAccountLock, staffToEdit.getDateRegistered(), uManager.LoadRoleByName(tblRoles.getValueAt(tblRoles.getSelectedRow(),0).toString()));
                   userToEdit = staff;
               }
               else
               {
                   Customer customerToEdit = (Customer) userToEdit;
                   //creates new Customer
                   //public Customer(String preferredPaymentMethod, String paymentDetails, Address preferredDeliveryAddress, String companyName, String userName, String password, String firstName, String surname, String emailAddress, String phoneNumber, Address address, int numberOfFailedLoginAttempts, Date dateOfAccountLock, Date dateRegistered, Role role) {
                   Customer customer = new Customer(preferredPaymentMethod, customerToEdit.getPaymentDetails(),customerToEdit.getPreferredDeliveryAddress(), companyName, userName, password,firstName, surname, emailAddress, phoneNumber, address, customerToEdit.getNumberOfFailedLoginAttempts(), dateOfAccountLock , customerToEdit.getDateRegistered(), uManager.LoadRoleByName(tblRoles.getValueAt(tblRoles.getSelectedRow(),0).toString()));
                   userToEdit = customer;
               }
               
               
               //creates hashmap of addresses
               //loads address from database into hashmap
               HashMap<Integer,Address> addresses = uManager.loadAddresses();
               
               //checks if address exists in the database
               
               if(!uManager.IsAddressRegistered(address))
               {
                   address = uManager.RegisterAddress(address);
                   userToEdit.setAddress(address);
               }
               else
               {
                   userToEdit.setAddress(uManager.GetRegisteredAddress(address));
               }

               
               
                
            
               //registers customer
               uManager.UpdateUser(userToEdit);
               JOptionPane.showMessageDialog(rootPane, "User Edited Successfully");
               UpdateUserFields();

               
               
               
               
               
               
               
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Information");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRoleActionPerformed
        // TODO add your handling code here:
        //gets selected Row
             int selectedRow = tblRoles.getSelectedRow();
             if(selectedRow != -1)
             {
                 uManager.DeleteRole((int)tblRoles.getValueAt(selectedRow, 0));
                 LoadTables();
             }  
             else
             {
                 //display no selected role error messages
                JOptionPane.showMessageDialog(null, "Please Select a Role");
                return;
             }
    }//GEN-LAST:event_btnDeleteRoleActionPerformed

    private void btnEditRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRoleActionPerformed
        // TODO add your handling code here:
        try 
        {
            String roleName = txtRoleName.getText();
            
            //gets selected Row
             int selectedRow = tblRoles.getSelectedRow();
             if(selectedRow != -1)
             {
                 Role role = uManager.LoadRole((int)tblRoles.getValueAt(selectedRow, 0));
                 uManager.UpdateRole(role);
                 LoadTables();
             }  
             else
             {
                 //display no selected role error messages
                JOptionPane.showMessageDialog(null, "Please Select a Role");
                return;
             }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Information");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEditRoleActionPerformed

    private void btnAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoleActionPerformed
        // TODO add your handling code here:
        try 
        {
            String roleName = txtRoleName.getText();
            
            //gets selected Row
             int selectedRow = tblRoles.getSelectedRow();
             if(selectedRow != -1)
             {
                 //public Role(int roleId, String roleName, List<String> userIds)
                 Role role = new Role(roleName, new ArrayList<>());
                 uManager.CreateRole(role);
                 LoadTables();
             }  
             else
             {
                 //display no selected role error messages
                JOptionPane.showMessageDialog(null, "Please Select a Role");
                return;
             }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter Valid Information");
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btnAddRoleActionPerformed

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
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRole;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteRole;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditRole;
    private javax.swing.JCheckBox ckBoxAccountLocked;
    private javax.swing.JCheckBox ckBoxIsStaffMember;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCIty;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDateEmployed;
    private javax.swing.JLabel lblDateOfAccountLock;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JLabel lblPreferredPaymentMethod;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblTown;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblRoles;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtDateEmployed;
    private javax.swing.JTextField txtDateOfAccountLock;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPostCode;
    private javax.swing.JTextField txtPreferredPaymentMethod;
    private javax.swing.JTextField txtRoleName;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
