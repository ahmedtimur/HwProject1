package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        UserDao.users.add(user);
    }

    @Override
    public void findById(int id) {
        try {
            if (checkTrueOrFalse(id)) {
                throw new NoSuchIdException("There is no such id");
            }
            UserDao.users.stream().filter(user -> user.getId() == id).forEach(System.out::println);
        } catch (NoSuchIdException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void removeById(int id) {
        UserDao.users.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return UserDao.users.stream().toList();
    }

    public boolean checkTrueOrFalse(int id) {
        return UserDao.users.stream().filter(user -> user.getId() == id).isParallel();
    }
}
