/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


/**
 *
 * @author Mahmoud
 */
public class Category {


    private Integer categoryId;

    private String categoryName;

    private String categoryDiscruption;


    public Category() {
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Integer categoryId, String categoryName, String categoryDiscruption) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDiscruption = categoryDiscruption;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDiscruption() {
        return categoryDiscruption;
    }

    public void setCategoryDiscruption(String categoryDiscruption) {
        this.categoryDiscruption = categoryDiscruption;
    }

 
    
}
