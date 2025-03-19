package com.example.backend.service;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Category;
import com.example.backend.entity.User;

import java.util.List;

public interface CategoryService {
    void save (CategoryDTO categoryDTO);
    List<Category> getAllCategories();
    void deleteCategory(int id);
    void updateCategory(CategoryDTO categoryDTO);

    CategoryDTO findIdByName(String name);
}
