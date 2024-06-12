package com.OrderSystem.Order.services;

import com.OrderSystem.Order.entities.Category;
import com.OrderSystem.Order.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {

        return this.categoryRepository.findAll();
    }

    public Category createCategory(Category category) {

        return this.categoryRepository.save(category);
    }

    public Object findById(Long id) {
        Optional<Category> category0 = this.categoryRepository.findById(id);

        if (category0.isEmpty()) {
            return null;
        }

        return category0.get();
    }

}
