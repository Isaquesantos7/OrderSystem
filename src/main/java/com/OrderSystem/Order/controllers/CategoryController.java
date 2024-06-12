package com.OrderSystem.Order.controllers;

import com.OrderSystem.Order.DTOS.CategoryDTO;
import com.OrderSystem.Order.entities.Category;
import com.OrderSystem.Order.repositories.CategoryRepository;
import com.OrderSystem.Order.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/categories")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = this.categoryService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/api/categories/{id}")
    public Object findById(@PathVariable(value = "id") Long id) {
        Object category = this.categoryService.findById(id);

        if (category == null) {
            System.out.println("Entrou aqui");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Category not found!\"}");
        }

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping("/api/categories")
    public Category saveCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        Category category = new Category();

        BeanUtils.copyProperties(categoryDTO, category);
        return this.categoryService.createCategory(category);
    }
}
