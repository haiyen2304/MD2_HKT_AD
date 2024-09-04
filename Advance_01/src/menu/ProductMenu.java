package menu;

import feature.CategoryFeature;
import feature.ProductFeature;
import share.Share;

import java.util.Scanner;

public class ProductMenu {
    public static void showProductMenu(Scanner sc){
        while (true){

            System.out.println("""
                    ********************PRODUCT-MANAGEMENT********************
                    1. Enter the product number and enter product information
                    2. Display product information
                    3. Sort products by price in descending order
                    4. Delete products by id
                    5. Search for products by name
                    6. Change book information according to book id
                    7. Back""");

            int choice= Share.inputNumber(sc,"Enter your choice: ","You must enter a number, please try again");
            switch (choice){
                case 1:
                    System.out.println("(1). Enter the product number and enter product information");
                    ProductFeature.addNewProduct(sc);
                    break;

                case 2:
                    System.out.println("(2). Display product information");
                    ProductFeature.displayAllProduct();
                    break;

                case 3:
                    System.out.println("(3). Sort products by price in descending order");
                    ProductFeature.sortProduct(sc);
                    break;

                case 4:
                    System.out.println("(4). Delete products by id");
                    ProductFeature.deleteProductById(sc);
                    break;
                case 5:
                    System.out.println("5. Search for products by name");
                    ProductFeature.searchProductByName(sc);
                    break;
                case 6:
                    System.out.println("6. Change book information according to book id");
                    ProductFeature.updateProductInformation(sc);
                    break;

                case 7:
                    System.out.println("7. Back");
                    return;

                default:
                    System.err.println("You must choice option 1 -> 7");
            }
        }
    }
}
