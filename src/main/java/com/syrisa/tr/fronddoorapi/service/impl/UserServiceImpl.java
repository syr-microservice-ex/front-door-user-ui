package com.syrisa.tr.fronddoorapi.service.impl;

import com.syrisa.tr.fronddoorapi.data.UserRepository;
import com.syrisa.tr.fronddoorapi.model.User;
import com.syrisa.tr.fronddoorapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService<User> {

    private final UserRepository<User> userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public String delete(int id) {
        return userRepository.delete(id);
    }
}
