package com.example.expensetracker.dal;

import java.util.List;

import com.example.expensetracker.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class CategoryDALImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List <Category> getCategories(){
        return mongoTemplate.findAll(Category.class);
    }

    public Category addCategory(Category category){
        mongoTemplate.save(category);
        return category;
    }

    public Category getCategory(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Category.class);
    }
}

