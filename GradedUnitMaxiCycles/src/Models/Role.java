package Models;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30479752
 */
public class Role 
{
    private int roleId;
    
    private String roleName;
    
    private List<String> userIds;
    
    //getters

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    
    //setters
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
    
    //constructors

    public Role(int roleId, String roleName, List<String> userIds) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userIds = userIds;
    }
    
    public Role( String roleName, List<String> userIds) {
        this.roleId = 0;
        this.roleName = roleName;
        this.userIds = userIds;
    }
    
    public Role() {
        this.roleId = 0;
        this.roleName = "";
        this.userIds = new ArrayList<>();
    }
    
    //adders
    
    public void AddUserId(String id)
    {
        userIds.add(roleName);
    }
    
    

    
    
    
    
    
    
}
