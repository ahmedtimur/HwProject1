package com.company;

import com.company.dao.UserDao;
import com.company.enums.Gender;
import com.company.model.User;
import com.company.service.UserService;
import com.company.service.impl.UserServiceImpl;

import java.util.*;

import static com.company.enums.Gender.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        User person1 = new User("Masha", 1,34,FEMALE);
        User person2 = new User("Bob", 2, 23, MALE);
        User person3 = new User("Jessica", 3, 15, FEMALE);

        List<User> newList = new ArrayList<>();
        newList.add(person1); newList.add(person2); newList.add(person3);

        UserService userService = new UserServiceImpl();
        userService.addUser(newList);

        System.out.println(userService.findById(1));
        System.out.println();

        userService.getAllUsers().forEach(System.out::println);
        System.out.println();

        userService.removeById(2);
        userService.getAllUsers().forEach(System.out::println);


    }

}
