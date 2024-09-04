package menu;

import feature.CartFeature;
import feature.CategoryFeature;
import feature.ProductFeature;
import share.Share;

import java.util.Scanner;

public class UserMenu {
    public static void showMenuUser(Scanner sc) {
        while (true){

            System.out.println("""
                    **************************USER MENU**************************
                    1. View product list
                    2. Add to cart
                    3. View all products in cart
                    4. Change product quantity in cart
                    5. Remove a product from cart
                    6. Remove all products from cart
                    7. Go back""");

            int choice= Share.inputNumber(sc,"Enter your choice: ","You must enter a number, please try again");
            switch (choice){
                case 1:
                    System.out.println("(1). View product list ");
                    ProductFeature.displayAllProduct();
                    break;

                case 2:
                    System.out.println("(2). Add to cart");
                    CartFeature.addProductToCart(sc);
                    break;

                case 3:
                    System.out.println("(3).View all products in cart");
                    CartFeature.displayAllProductToCart();
                    break;

                case 4:
                    System.out.println("(4). Change product quantity in cart");
                    CartFeature.changeQuantityProductInCart(sc);
                    break;
                case 5:
                    System.out.println("(5). Remove a product from cart");
                    CartFeature.deleteACart(sc);
                    break;
                case 6:
                    System.out.println("(6). Remove all products from cart");
                    CartFeature.deleteAllCart(sc);
                    break;

                case 7:
                    System.out.println("(7). Back");
                    return;

                default:
                    System.err.println("You must choice option 1 -> 4");
            }
        }

    }
}
