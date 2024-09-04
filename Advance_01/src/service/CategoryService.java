package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements IGenericService<Category,Integer>{
    public static List<Category> catalogies=new ArrayList<Category>();

static {
    catalogies.add(new Category(1,"Hoa qua ","Re"));
    catalogies.add(new Category(2,"Do uong","Ngon"));
    catalogies.add(new Category(3,"Banh my","Bo"));
}

    @Override
    public List<Category> getAll() {
        return catalogies;
    }

    @Override
    public void save(Category c) {
        int indexCheck=findById(c.getcategoryId());
        if(indexCheck==-1){
            catalogies.add(c);
        }else {
            catalogies.set(indexCheck,c);
        }
    }

    @Override
    public int findById(Integer id) {
        return  catalogies.stream()
                .map(Category::getcategoryId)
                .toList()
                .indexOf( id );
    }

    @Override
    public void delete(Integer index) {
        catalogies.remove(index.intValue());
    }
}
