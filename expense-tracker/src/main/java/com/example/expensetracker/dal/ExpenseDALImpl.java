package com.example.expensetracker.dal;

import java.util.List;

import com.example.expensetracker.model.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseDALImpl implements ExpenseDal {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Expense> getAllExpenses(){
        return mongoTemplate.findAll(Expense.class);

    }

    @Override
    public Expense getExpense(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Expense.class);
    }
    
    @Override
    public Expense addNewExpense(Expense expense){
        mongoTemplate.save(expense);
        return expense;
    }

    @Override
    public String deleteExpense(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Expense.class);
        return "Delete success.";
    }
}

