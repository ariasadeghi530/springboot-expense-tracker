package com.example.expensetracker.dal;

import java.util.List;
import com.example.expensetracker.model.Category;

public interface CategoryDal {
    List <Category> getCategories();

    Category addCategory(Category category);

    Category getCategory(Category category);
}