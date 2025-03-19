package com.example.backend.controller;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.dto.ResponseDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Category;
import com.example.backend.entity.User;
import com.example.backend.service.CategoryService;
import com.example.backend.util.ResponseUtil;
import com.example.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> getCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        System.out.println(categoryDTO.getName());
        categoryService.save(categoryDTO);
        System.out.println("save wenwd");
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Category Saved Successfully", null));
    }

    @GetMapping(path = "/getAll")
    public ResponseUtil getAllCategories() {
        List<Category> categoryList = categoryService.getAllCategories();

        for (Category category : categoryList) {
            System.out.println(category.toString());
        }
        return new ResponseUtil(200, "User saved successfully", categoryList);
    }
}
