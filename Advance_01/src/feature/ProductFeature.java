package feature;

import model.Product;
import service.ProductService;
import share.Share;

import java.util.Comparator;
import java.util.Scanner;

public class ProductFeature {
    public static ProductService productService = new ProductService();


    public static void addNewProduct(Scanner sc) {
        int number= Share.inputNumber(sc,"Enter the number product you want to add: ","You must enter a number, please try again");
        for(int i=1;i<=number;i++) {
            Product p = new Product();
            System.out.println("Adding product "+i+" to the list");
            p.inputData(sc);
            productService.save(p);
        }
    }

    public static void displayAllProduct(){
        if(ProductService.products.isEmpty()){
            System.err.println("List product is empty");
            return;
        }
        for(Product p : ProductService.products){
            p.displayData();
        }
    }

    public static void sortProduct(Scanner sc){
        ProductService.products.stream()
                .sorted(Comparator.comparingDouble(Product::getProductPrice).reversed())
                .toList()
                .forEach(Product::displayData);
        System.out.println("Sort success");
    }


    public static void deleteProductById(Scanner sc){
        if(ProductService.products.isEmpty()){
            System.err.println("List product is empty");
            return;
        }
        System.out.println("Enter product Id you want to delete");
        String productId = sc.nextLine().trim();
        productService.delete(productId);

    }

    public static void searchProductByName(Scanner sc){
        if(ProductService.products.isEmpty()){
            System.err.println("List product is empty");
            return;
        }
        System.out.println("Enter product name you want to search");
        String productNameInput = sc.nextLine().trim();
        int count=0;
        for(Product p : ProductService.products){
            if(p.getProductName().contains(productNameInput)){
                p.displayData();
                count++;
            }
        }
        System.out.println("Found " + count + " products");
    }

    public static void updateProductInformation(Scanner sc){
        if(ProductService.products.isEmpty()){
            System.err.println("List product is empty");
            return;
        }
        System.out.print("Enter product id you want to update: ");
        String productIdUpdate = sc.nextLine().trim();
        int indexUpdate=productService.findById(productIdUpdate);
        if(indexUpdate!=-1){
            System.out.println("Found product with id: "+productIdUpdate);
            Product pUpdate = ProductService.products.get(indexUpdate);
            pUpdate.inputData(sc);
            productService.save(pUpdate);
        }else {
            System.err.println("Product not found with Id: " + productIdUpdate);
        }
    }
}
