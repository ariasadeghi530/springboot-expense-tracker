package com.example.expensetracker.dal;

import java.util.List;

import com.example.expensetracker.model.User;

public interface UserDal {

    List<User> getAllUsers();

    User getUserById(String id);

    User addNewUser(User user);


}