package feature;

import model.CartItem;
import model.Product;
import service.CartService;
import service.ProductService;
import share.Share;

import java.util.Scanner;

public class CartFeature {
    public static CartService cartService = new CartService();


    public static void addProductToCart(Scanner sc){
        System.out.println("Enter product ID you want to add to cart : ");
        String productIDAddToCart = sc.nextLine();
        boolean checkProductInCart = false;

        for(Product p: ProductService.products){
            if(p.getProductId().equals(productIDAddToCart)){
                checkProductInCart = true;

                boolean check=false;
                for(CartItem cartItem:cartService.getAll()){
                    if(cartItem.getProduct().getProductId().equals(productIDAddToCart)){
                        check=true;
                        int quantity = Share.inputNumber(sc,"Product already in your cart, please enter quantity you want to add","Enter number please!!");
                        while (true){
                            if(quantity>p.getStock()){
                                System.out.println("Out of Stock, please try again");
                                quantity = Share.inputNumber(sc,"Product already in your cart, please enter quantity you want to add","Enter number please!!");
                            }else {
                                break;
                            }
                        }
                        cartItem.setQuantity(cartItem.getQuantity()+quantity);
                        p.setStock(p.getStock()-quantity);
                        System.out.println("Added product to the cart!!! DONE");
                        break;
                    }
                }
                if(!check){
                    CartItem newCartItem = new CartItem();
                    newCartItem.inputData(sc,p);
                    CartService.cartItems.add(newCartItem);
                    p.setStock(p.getStock()-newCartItem.getQuantity());
                    System.out.println("Added product to the cart!!! DONE");
                    break;
                }
            }
        }
        if(!checkProductInCart){
            System.out.println("Product not added to the cart!!! ");
        }
    }
    public static void displayAllProductToCart(){
        if(cartService.getAll().isEmpty()||CartService.cartItems==null){
            System.out.println("No cart found");
            return;
        }
        int counter=0;
        for(CartItem cartItem:cartService.getAll()){
            cartItem.displayData();
            counter++;
        }
        System.out.println("Cart has " + counter + " products");

    }
    public static void changeQuantityProductInCart(Scanner sc){
        if(cartService.getAll().isEmpty()||CartService.cartItems==null){
            System.out.println("No cart found");
            return;
        }
        int cartID= Share.inputNumber(sc,"Enter cart id: ","Enter a number, please try again");

        boolean checkProductToCart=false;
        for(CartItem cartItem:cartService.getAll()){
            if(cartItem.getCartItemId()==cartID){
                int quantityUpdateInCart = Share.inputNumber(sc,"Enter quantity you want to add","Enter number please!!");
                if(quantityUpdateInCart < (cartItem.getProduct().getStock() + cartItem.getQuantity())){
                    for(Product p : ProductService.products){
                        if(p.getProductId().equals(cartItem.getProduct().getProductId())){
                            p.setStock(cartItem.getProduct().getStock() + cartItem.getQuantity() - quantityUpdateInCart);
                        }
                    }
                    cartItem.setQuantity(quantityUpdateInCart);
                    System.out.println("Done updating quantity of cart item");
                    checkProductToCart=true;
                    break;
                }else {
                    System.out.println("Out of Stock, please try again");
                }
                break;
            }
        }
        if(!checkProductToCart){
            System.out.println("Cart ID not found !!");
        }

    }
    public static void deleteACart(Scanner sc){
        if(cartService.getAll().isEmpty()||CartService.cartItems==null){
            System.out.println("No cart found");
            return;
        }
        int cartIDDelete =Share.inputNumber(sc,"Enter cart id you want to delete: ","Enter a number, please try again");
        boolean checkProductToCart=false;
        for(CartItem cartItem:cartService.getAll()){
            if(cartItem.getCartItemId()==cartIDDelete){
                CartService.cartItems.remove(cartItem);
                System.out.println("Done removing product from cart");
                checkProductToCart=true;
                break;
            }
        }
        if(!checkProductToCart){
            System.out.println("Cart ID not found !!");
        }
    }
    public static void deleteAllCart(Scanner sc){
        if(cartService.getAll().isEmpty()||CartService.cartItems==null){
            System.out.println("No cart found");
            return;
        }
        CartService.cartItems.clear();
        System.out.println("Cart has been deleted");
    }
}
