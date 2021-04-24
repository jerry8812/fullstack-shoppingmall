package dev.jerry.service.impl;

import dev.jerry.entity.User;
import dev.jerry.repository.UserRepository;
import dev.jerry.service.UserService;
import dev.jerry.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public int save(User user) {
        user.setUserId(CommonUtil.createUUID());
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        User userDB = userRepository.findUserByEmail(user.getEmail());
        if (!ObjectUtils.isEmpty(userDB) && userDB.getPassword().equals(CommonUtil.toMD5(user.getPassword()))) {
            return userDB;
        }else{
            throw new RuntimeException("Wrong email or password");
        }
    }
}
