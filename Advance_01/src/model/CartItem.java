package model;

import validate.CartValidate;
import validate.CategoryValidate;

import java.util.Scanner;

public class CartItem {
    private static int count=1;
    private int cartItemId;
    private Product product;
    private double price;
    private int quantity;

    public CartItem(){
    }

    public CartItem(int cartItemId, Product product, double price, int quantity) {
        this.cartItemId = cartItemId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void inputData(Scanner sc,Product product) {
        this.cartItemId = count++;
        this.product = product;

        assert this.product != null;
        this.price = this.product.getProductPrice()*this.quantity;
        this.quantity = CartValidate.inputQuantity(sc,this.product);
    }


    public void displayData() {
        System.out.printf("[ ID: %-5d | Product: %-25s | Price: %-10f | Quantity: %-10d  ]\n",
                this.cartItemId,
                this.product.getProductId()+this.product.getProductName(),
                this.price,
                this.quantity);
    }
}
