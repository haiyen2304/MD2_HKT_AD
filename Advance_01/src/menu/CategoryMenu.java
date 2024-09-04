package menu;

import feature.CategoryFeature;
import share.Share;

import java.util.Scanner;

public class CategoryMenu {
    public static void  showCatalogMenu(Scanner sc) {
        while (true){

            System.out.println("""
            **********************************CATALOG-MANAGEMENT**********************************
            1. Enter the number of newly added categories and enter information for each category
            2. Display information of all categories
            3. Edit the category name according to the category id
            4. Delete categories by Category code (note: do not delete when there are products
            5. Back""");

            int choice= Share.inputNumber(sc,"Enter your choice: ","You must enter a number, please try again");
            switch (choice){
                case 1:
                    System.out.println("(1). Enter the number of newly added categories and enter information for each category ");
                    CategoryFeature.addNewCategory(sc);
                    break;

                case 2:
                    System.out.println("2. Display information of all categories");
                    CategoryFeature.displayAllCategory();
                    break;

                case 3:
                    System.out.println("3. Edit the category name according to the category id");
                    CategoryFeature.UpdateNameCategoryById(sc);
                    break;

                case 4:
                    System.out.println("4. Delete categories by category code (note: do not delete when there are products)");
                    CategoryFeature.deleteCategoryById(sc);
                    break;

                case 5:
                    System.out.println("5. Back");
                    return;

                default:
                    System.err.println("You must choice option 1 -> 4");
            }
        }
    }
}
