package dev.jerry.repository;

import dev.jerry.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {
    public List<User> findAll();
    public User findById(String userId);
    User findUserByEmail(String email);
    int save(User user);
}
