package validate;

import model.Category;
import service.CategoryService;

import java.util.Scanner;

public class CategoryValidate {
    public static String inputCategoryName(Scanner sc){

        while(true){
            System.out.print("Enter category Name: ");
            String categoryName = sc.nextLine().trim();
            if(categoryName.isBlank()){
                System.out.println("category Name cannot be blank");
                continue;
            }

            if(CategoryService.catalogies.stream()
                        .map(Category::getcategoryName)
                        .anyMatch(categoryName::equalsIgnoreCase)){
                    System.err.println("category Name is had");
                continue;
            }
            return categoryName;
        }
    }
    public static String inputCategoryDescription(Scanner sc){
        while (true){
            System.out.println("Enter category Description");
            String categoryDescription = sc.nextLine().trim();
            if(categoryDescription.isBlank()){
                System.out.println("category Description cannot be blank");
                continue;
            }
            return categoryDescription;
        }
    }
}
