package com.example.backend.service.impl;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.entity.Category;
import com.example.backend.entity.User;
import com.example.backend.repo.CategoryRepo;
import com.example.backend.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(CategoryDTO categoryDTO) {
        if (categoryRepo.existsById(categoryDTO.getId())) {
            throw new RuntimeException("Category already exists");
        }
        categoryRepo.save(modelMapper.map(categoryDTO, Category.class));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(int id) {

    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {

    }

    @Override
    public CategoryDTO findIdByName(String name) {
        Category category = categoryRepo.findByName(name);
        return modelMapper.map(category, CategoryDTO.class);
    }
}
