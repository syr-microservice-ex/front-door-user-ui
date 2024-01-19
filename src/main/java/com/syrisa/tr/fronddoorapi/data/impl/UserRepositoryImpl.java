package com.syrisa.tr.fronddoorapi.data.impl;

import com.syrisa.tr.fronddoorapi.data.UserRepository;
import com.syrisa.tr.fronddoorapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository<User> {
    private static HashMap<Integer, User> userMap;
    static {
        userMap = new HashMap<>();
        userMap.put(1, new User(1, "Alice", "Black", "alice.black@frondoor.api.com", 36));
        userMap.put(2, new User(2, "Shack", "Black", "shack.black@frondoor.api.com", 40));
        userMap.put(3, new User(3, "Micheal", "Black", "mcheal.black@frondoor.api.com", 51));
        userMap.put(4, new User(4, "İsabella", "Black", "isbll.black@frondoor.api.com", 25));
        userMap.put(5, new User(5, "Ronaldo", "Chris", "cr.rd@frondoor.api.com", 36));
        userMap.put(6, new User(6, "Messi", "Lionel", "lionel.black@frondoor.api.com", 40));
        userMap.put(7, new User(7, "Kaka", "Lite", "kaka.black@frondoor.api.com", 51));
        userMap.put(8, new User(8, "Sandro", "Green", "sdr.gree@frondoor.api.com", 25));
    }
    @Override
    public User create(User user) {
        userMap.putIfAbsent(user.id(), user);
        return user;
    }

    @Override
    public User update(User user) {
        if (userMap.get(user.id()) != null) {
            userMap.put(user.id(), user);
            return user;
        }
        return null;
    }

    @Override
    public User getById(int id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAll() {
        return userMap.values().stream().toList();
    }

    @Override
    public User getByEmail(String email) {
        return userMap.values().stream().filter(user -> user.email().equals(email)).findFirst().orElse(null);
    }

    @Override
    public String delete(int id) {
        return userMap.remove(id) != null ? "User deleted." : "User not found.";
    }
}
