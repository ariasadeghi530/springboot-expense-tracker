package com.example.expensetracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Data
@Table(name="CATEGORY")
public class Category {
    @Id
    private Long id;

    // Travel, Grocery,...
    @NonNull
    private String name;

 
}