package dev.jerry.service;

import dev.jerry.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserByEmail(String email);

    int save(User user);

    User login(User user);
}
