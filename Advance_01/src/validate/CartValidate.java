package validate;

import model.Product;
import service.ProductService;

import java.util.Scanner;

public class CartValidate {

    //        this.quantity = inputQuantity(sc);
    public static Product inputProduct(Scanner sc){
        while(true){
            System.out.println("Enter productID: ");
            String productID = sc.nextLine().trim();
            if(productID.isEmpty()){
                System.out.println("You just left the information blank");
                continue;
            }


            for(Product p:ProductService.products){
                if(p.getProductId().equals(productID)){
                    return p;
                }
            }
            System.out.println("Product ID does not exist!!!Please re-enter!!!");
        }
    }

    public static int inputQuantity(Scanner sc,Product p){
        while(true){
            try{
                System.out.println("Enter quantity: ");
                int quantity = sc.nextInt();
                if(quantity >p.getStock()){
                    System.out.println("The quantity you enter is greater than the quantity in stock");
                    System.out.println("Please re-enter");
                    continue;
                }
                return quantity;
            }catch (Exception e){
                System.err.println("selection must be numeric");
                sc.nextLine();
            }
        }
    }


}
