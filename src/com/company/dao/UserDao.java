package com.company.dao;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void findById(int id) {
        users.stream().filter(user -> user.getId() == id).forEach(System.out::println);
    }

    public void removeById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public List<User> getAllUsers() {
        return users.stream().toList();
    }

    public boolean checkTrueOrFalse(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().isEmpty();
    }


}
