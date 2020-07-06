package com.example.expensetracker.dal;

import java.util.List;


import com.example.expensetracker.model.User;

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
    public List <User> getAllUsers(){
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserById(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User addNewUser(User user){
        mongoTemplate.save(user);
        return user;
    }

}