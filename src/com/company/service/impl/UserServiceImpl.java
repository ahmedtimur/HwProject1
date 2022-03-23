package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public void addUser(List<User> user) {
        userDao.setUsers(user);
    }

    @Override
    public User findById(int id) {
            if (checkTrueOrFalse(id)) {
                try {
                    throw new NoSuchIdException("There is no such id");
                }catch (NoSuchIdException e) {
                    System.out.println(e.getMessage());
                }
            }
            User newUser = null;
            for(User i: userDao.getUsers()) {
                if(i.getId() == id)
                    newUser = i;
            }
            return newUser;
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
        return userDao.getUsers().stream().filter(user -> user.getId() == id).findFirst().isEmpty();
    }
}
