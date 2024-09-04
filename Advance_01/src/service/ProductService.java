package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product,String> {
    public static ArrayList<Product> products = new ArrayList<Product>();
//static {
//    products.add(new Product("P0001","Tao",20,"aaaaaaaa",12,CategoryService.catalogies.getFirst(),true));
//    products.add(new Product("P0022","TaoTau",28,"bbbbb",12,CategoryService.catalogies.getFirst(),true));
//    products.add(new Product("P0044","TaoMeo",10,"ccccc",12,CategoryService.catalogies.getFirst(),true));
//
//}



    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product pro) {
        int indexCheck=findById(pro.getProductId());
        if(indexCheck==-1){
            products.add(pro);
        }else {
            products.set(indexCheck, pro);
        }
    }

    @Override
    public int findById(String id) {
        return products.stream()
                .map(Product::getProductId)
                .toList()
                .indexOf(id);
    }

    @Override
    public void delete(String id) {
     // Cách 1:   products.removeIf(product -> product.getProductId().equals(id));
        products.remove(findById(id)); // cách 2
    }


}
