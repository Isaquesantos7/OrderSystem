package com.OrderSystem.Order.services;

import com.OrderSystem.Order.entities.Product;
import com.OrderSystem.Order.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll() {

        return this.productRepository.findAll();
    }

    public Object findById(Long id) {
        Optional<Product> product0 = this.productRepository.findById(id);

        if (product0.isEmpty()) {
            return null;
        }

        return product0.get();
    }

    public Product createProduct(Product product) {

        return this.productRepository.save(product);
    }
}
