package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void findById(int id) {
        try {
            if (userDao.checkTrueOrFalse(id)) {
                throw new NoSuchIdException("There is no such id");
            }
            userDao.findById(id);
        } catch (NoSuchIdException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void removeById(int id) {
        userDao.removeById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
