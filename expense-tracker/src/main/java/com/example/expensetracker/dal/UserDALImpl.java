package com.example.expensetracker.dal;

import java.util.ArrayList;
import java.util.List;


import com.example.expensetracker.model.User;
import com.example.expensetracker.model.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDALImpl implements UserDal {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List <User> getUsers(){
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUser(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User createUser(User user){
        mongoTemplate.save(user);
        return user;
    }

    @Override
    public List<Expense> getExpenses(List<String> ids){
        List <Expense> expenses = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++){
            Query query = new Query();
            query.addCriteria(Criteria.where("id").is(ids.get(i)));
            expenses.add(mongoTemplate.findOne(query, Expense.class));
        }
        return expenses;
    }

    // @Override 
    // public Expense addExpense(String id){
        
    // }

}