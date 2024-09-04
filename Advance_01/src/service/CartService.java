package service;

import model.CartItem;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService implements IGenericService<CartItem,Integer>{
    public static List<CartItem> cartItems = new ArrayList<CartItem>();


    @Override
    //3. hiển thị danh sách giỏ hàng
    public List<CartItem> getAll() {
        return cartItems;
    }

    @Override
    public void save(CartItem c) {
        int indexCheck=findById(c.getCartItemId());
        if(indexCheck==-1){
            cartItems.add(c);
        }else {
            cartItems.set(indexCheck,c);
        }
    }

    @Override
    public int findById(Integer id) {
        return cartItems.stream()
                .map(CartItem::getCartItemId)
                .toList()
                .indexOf(id);
    }

    @Override
    public void delete(Integer index) {
        cartItems.remove(index.intValue());

    }
}
