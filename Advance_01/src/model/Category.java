package model;

import validate.CategoryValidate;

import java.util.Scanner;

public class Category implements IModel {
    private static int count =1;
    private int categoryId;
    private String categoryName;
    private String description;
    public Category() {
    }

    public Category(int categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Category.count = count;
    }

    public int getcategoryId() {
        return categoryId;
    }

    public void setcategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getcategoryName() {
        return categoryName;
    }

    public void setcategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Category getCategory(){
        return this;
    }


    @Override
    public void inputData(Scanner sc) {
        this.categoryId = count++;

        this.categoryName = CategoryValidate.inputCategoryName(sc);
        this.description = CategoryValidate.inputCategoryDescription(sc);
    }

    @Override
    public void displayData() {
        System.out.println( "CatalogID: " +this.categoryId + "   |   CatalogName: "+this.categoryName +"\n"
                +"------------------------------------------------------------------");

    }
}
