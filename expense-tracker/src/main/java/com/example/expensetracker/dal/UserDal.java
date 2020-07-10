package com.example.expensetracker.dal;

import java.util.List;

import com.example.expensetracker.model.User;
import com.example.expensetracker.model.Expense;

public interface UserDal {

    List<User> getUsers();

    User getUser(String id);

    User createUser(User user);

    List <Expense> getExpenses(List<String> ids);

    // Expense addExpense(String id);
    
}