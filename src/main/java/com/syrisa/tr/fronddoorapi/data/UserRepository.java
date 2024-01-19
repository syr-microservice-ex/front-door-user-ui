package com.syrisa.tr.fronddoorapi.data;


import java.util.List;

public interface UserRepository<T>  {
    T create(T t);

    T update(T t);

    T getById(int id);

    List<T> getAll();

    T getByEmail(String email);

    String delete(int id);
}
