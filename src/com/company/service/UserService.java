package com.company.service;

import com.company.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void findById(int id);
    void removeById(int id);
    List<User> getAllUsers();
}
