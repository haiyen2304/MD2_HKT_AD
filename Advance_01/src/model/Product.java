package model;

import validate.ProductValidate;

import java.util.Scanner;

public class Product implements IModel{
    private String productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private int stock;
    private Category category;
    private Boolean status;


    public Product() {}

    public Product(String productId, String productName, double productPrice, String productDescription, int stock, Category category, Boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.stock = stock;
        this.category = category;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        if (this.getProductId() == null || this.getProductId().isEmpty()) {
            this.productId = ProductValidate.inputProductId(sc);
        }
        this.productName = ProductValidate.inputProductName(sc);
        this.productPrice = ProductValidate.inputProductPrice(sc);
        this.productDescription = ProductValidate.inputProductDescription(sc);
        this.stock = ProductValidate.inputProductStock(sc);
        this.category = ProductValidate.inputCategory(sc);
        this.status = ProductValidate.inputProductStatus(sc);

    }

    @Override
    public void displayData() {
        System.out.printf("[ ID: %-5s | Name: %-15s | Price: %-10f | Description: %-20s | Stock: %-5d | Category: %-5s | Status: %-5s ]\n",
                this.productId,
                this.productName,
                this.productPrice,
                this.productDescription,
                this.stock,
                this.category.getcategoryId()+this.category.getcategoryName(),
                this.status?"Sell": "Not for sale");
    }
}
//return "Product{" +
//                "productId='" + productId + '\'' +
//                ", productName='" + productName + '\'' +
//                ", description='" + description + '\'' +
//                ", productPrice=" + productPrice +
//                ", stock=" + stock +
//                ", catalog=" + catalog.getCatalogName() +
//                ", status=" + (status ?"Sell":"notSell") +
//                '}';
