package feature;

import model.Category;
import model.Product;
import service.CategoryService;
import service.IGenericService;
import service.ProductService;
import share.Share;
import validate.CategoryValidate;

import java.util.Scanner;

public class CategoryFeature {
    public static CategoryService categoryService = new CategoryService();
    public static IGenericService<Product,String> productService = new ProductService();
    public static void addNewCategory(Scanner sc) {
        int number= Share.inputNumber(sc,"Enter your number: ","You must enter a number, please try again");
        for(int i=0;i<number;i++) {
            Category category = new Category();
            System.out.println("Add Catalog " + (i+1));
            category.inputData(sc);
            categoryService.save(category);
        }
        System.out.println("Add "+number +" success");
    }

    public static void displayAllCategory() {
        // Kiểm tra xem mảng cos rỗng hay không?
        if(CategoryService.catalogies.isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
        for(Category category : CategoryService.catalogies) {
            category.displayData();
        }
    }

    public static void UpdateNameCategoryById(Scanner sc) {
        // Kiểm tra xem mảng cos rỗng hay không?
        if(CategoryService.catalogies.isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }

        int idUpdate= Share.inputNumber(sc,"Enter catagory id you want to change name: ","You must enter a number, please try again");
        int index = categoryService.findById(idUpdate);
        if( index!=-1){
            Category c= CategoryService.catalogies.get(index);
            String nameUpdate= CategoryValidate.inputCategoryName(sc);
            c.setcategoryName(nameUpdate);
            categoryService.save(c);
        }else {
            System.err.println("Category not found");
        }

//        String categoryNameUpdate="";
//        Category cUpdate = null;
//        for(Category c:CategoryService.catalogies) {
//            if(c!=null&& c.getcategoryName().equals(categoryNameUpdate)) {
//                cUpdate = c;
//            }
//        }
//        if(cUpdate!=null) {
//            String nameUpdate= CategoryValidate.inputCategoryName(sc);
//            cUpdate.setcategoryName(nameUpdate);
//            categoryService.addOrUpdate(cUpdate);
//        }else {
//            System.err.println("Category not found");
//        }
    }

    public static void deleteCategoryById(Scanner sc) {
        // Kiểm tra xem mảng cos rỗng hay không?
        if(CategoryService.catalogies.isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
        int idDelete=Share.inputNumber(sc,"Enter catagory id you want to delete: ","You must enter a number, please try again");

        int index = categoryService.findById(idDelete);
        if(index!=-1){
            boolean check=false;
            for(Product p : ProductService.products) {
                if(p.getCategory().getcategoryId()==idDelete){
                    System.err.println("Cant delete category has products");
                    check=true;
                    break;
                }
            }
            if(!check){
                categoryService.delete(index);
                System.out.println("Delete success");
            }
        }else {
            System.err.println("Category not found");
        }
    }
}
