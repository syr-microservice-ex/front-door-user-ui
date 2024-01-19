package com.syrisa.tr.fronddoorapi.model;

import java.util.Random;

public record User(Integer id, String username, String surname, String email, int age) {
    public User{
     //   id = (id == null || id==0)  ? new Random().nextInt(5,1000) : id;
        id = (id == null || id==0)  ? new Random().nextInt(9,1000) : id;

    }
}
