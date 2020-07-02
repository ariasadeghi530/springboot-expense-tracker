package com.example.expensetracker.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="EXPENSE")
public class Expense {
    @Id
    private Long id;

    private Instant expensedate;

    private String description;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToOne
    private User user;



}