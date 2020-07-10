package com.example.expensetracker.repository;

import com.example.expensetracker.model.Category;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{

    Category findByName(String name);
    
}