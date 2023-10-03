package com.example.testeusuario.model.repository;

import com.example.testeusuario.model.entity.User;

public interface UserRepository {
    User findById(int id);
    User findByUsername(String username);
    void save(User user);
    void delete(User user);
}

