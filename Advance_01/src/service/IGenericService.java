package service;

import java.util.List;

public interface IGenericService <T,E>{

    List<T> getAll();
    void save(T t);
    int findById(E e);
    void delete(E e);
}
