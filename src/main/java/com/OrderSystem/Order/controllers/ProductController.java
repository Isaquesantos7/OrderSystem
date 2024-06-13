package com.OrderSystem.Order.controllers;

import com.OrderSystem.Order.DTOS.ProductDTO;
import com.OrderSystem.Order.entities.Product;
import com.OrderSystem.Order.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = this.productService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Object product = this.productService.findById(id);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Product not found!\"}");
        }

        return  ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDTO productDTO) {
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.createProduct(product));
    }

}
