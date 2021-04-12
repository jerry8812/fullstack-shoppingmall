package dev.jerry.service;

import dev.jerry.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> findAll();
}
