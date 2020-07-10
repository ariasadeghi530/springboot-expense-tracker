package com.example.expensetracker.repository;

import java.util.List;

import com.example.expensetracker.model.Expense;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String>{
    
    @Query(value = "{'users.id' :?0}", fields = "{'users': 0}")
    List<Expense> findExpensesByUserId(String userId);
}