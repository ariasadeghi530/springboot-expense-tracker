package com.example.expensetracker.model;

import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("user")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private Date creationDate = new Date();

    public String getUserId(){
        return id;
    }

    public void setUserId(String id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Date getCreationDate(){
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

}