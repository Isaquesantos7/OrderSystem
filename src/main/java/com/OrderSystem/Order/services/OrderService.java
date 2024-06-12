package com.OrderSystem.Order.services;

import com.OrderSystem.Order.entities.Order;
import com.OrderSystem.Order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() {

        return this.orderRepository.findAll();
    }

    public Object findById(Long id) {
        Optional<Order> order0 = this.orderRepository.findById(id);

        if (order0.isEmpty()) {
            return null;
        }

        return order0.get();
    }

    public Order createOrder(Order order) {

        return this.orderRepository.save(order);
    }
}
