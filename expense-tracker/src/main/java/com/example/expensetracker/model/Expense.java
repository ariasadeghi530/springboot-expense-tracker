package com.example.expensetracker.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("expenses")
public class Expense {
   @Id
    private Long id;
    private Instant expensedate;
    private String description;

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Instant getExpenseDate(){
        return this.expensedate;

    }
    public void setExpenseDate(Instant expensedate){
        this.expensedate = expensedate;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}