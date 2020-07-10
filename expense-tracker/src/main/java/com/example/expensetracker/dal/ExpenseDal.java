package com.example.expensetracker.dal;

import java.util.List;

import com.example.expensetracker.model.Expense;

public interface ExpenseDal {
    List<Expense> getAllExpenses();

    Expense getExpense(String id);

    Expense addNewExpense(Expense expense);

    String deleteExpense(String id);
}