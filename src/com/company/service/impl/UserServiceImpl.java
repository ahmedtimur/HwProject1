package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public void addUser(List<User> user) {
        userDao.setUsers(user);
    }

    @Override
    public void findById(int id) {
        try {
            if (checkTrueOrFalse(id)) {
                throw new NoSuchIdException("There is no such id");
            }
            userDao.getUsers().stream().filter(user -> user.getId() == id).forEach(System.out::println);
        } catch (NoSuchIdException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void removeById(int id) {
        userDao.getUsers().removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUsers().stream().toList();
    }

    public boolean checkTrueOrFalse(int id) {
        return userDao.getUsers().stream().filter(user -> user.getId() == id).isParallel();
    }
}
