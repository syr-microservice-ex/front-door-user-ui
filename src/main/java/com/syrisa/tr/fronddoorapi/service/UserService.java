package com.syrisa.tr.fronddoorapi.service;


import java.util.List;

public interface UserService<T> {
    T create(T t);

    T update(T t);

    T getById(int id);

    List<T> getAll();

    T getByEmail(String email);

    String delete(int id);
}
