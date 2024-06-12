package com.OrderSystem.Order.controllers;

import com.OrderSystem.Order.DTOS.OrderDTO;
import com.OrderSystem.Order.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.OrderSystem.Order.entities.Order;

@RestController
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/orders")
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = this.orderService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Object order = this.orderService.findById(id);

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Order not found!\"}");
        }

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping("/api/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid OrderDTO orderDTO) {
        Order order = new Order();

        BeanUtils.copyProperties(orderDTO, order);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.orderService.createOrder(order));
    }
}
