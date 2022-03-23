package com.company.service;

import com.company.model.User;

import java.util.List;

public interface UserService {
    void addUser(List<User> user);
    List<User> findById(int id);
    void removeById(int id);
    List<User> getAllUsers();
}
