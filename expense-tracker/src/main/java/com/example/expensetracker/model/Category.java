package com.example.expensetracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "category")
public class Category {
    @Id
    private Long id;

    // Travel, Grocery,...
    private String name;

 
}