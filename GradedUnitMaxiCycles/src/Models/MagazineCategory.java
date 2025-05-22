/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucal
 */
public class MagazineCategory 
{
    private int magazineCategoryId;
    private String magazineCategoryName;
    private List<Integer> magazines;
    
    //getters

    public int getMagazineCategoryId() {
        return magazineCategoryId;
    }

    public String getMagazineCategoryName() {
        return magazineCategoryName;
    }

    public List<Integer> getMagazines() {
        return magazines;
    }
    
    //setters

    public void setMagazineCategoryId(int magazineCategoryId) {
        this.magazineCategoryId = magazineCategoryId;
    }

    public void setMagazineCategoryName(String magazineCategoryName) {
        this.magazineCategoryName = magazineCategoryName;
    }

    public void setMagazines(List<Integer> magazines) {
        this.magazines = magazines;
    }
    
    //constructors

    public MagazineCategory(int magazineCategoryId, String magazineCategoryName, List<Integer> magazines) {
        this.magazineCategoryId = magazineCategoryId;
        this.magazineCategoryName = magazineCategoryName;
        this.magazines = magazines;
    }
    
    public MagazineCategory( String magazineCategoryName, List<Integer> magazines) {
        this.magazineCategoryId = 0;
        this.magazineCategoryName = magazineCategoryName;
        this.magazines = magazines;
    }
    
    public MagazineCategory() {
        this.magazineCategoryId = 0;
        this.magazineCategoryName = "";
        this.magazines = new ArrayList<>();
    }
    
    
    
}
