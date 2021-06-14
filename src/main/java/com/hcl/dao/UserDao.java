package com.hcl.dao;

import com.hcl.model.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    void insertUsers(List<User> users);
    List<User> getAllUsers();
    User getUserById(Long userId);
    void updateUser(User user);
    User getUserByUsername(String username);
    void deleteUserById(long userId);
}
