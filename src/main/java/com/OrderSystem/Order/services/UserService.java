package com.OrderSystem.Order.services;

import com.OrderSystem.Order.entities.User;
import com.OrderSystem.Order.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public Object findById(Long id) {
        Optional<User> obj = this.userRepository.findById(id);

        if (obj.isEmpty()) {
            return null;
        }

        return obj.get();
    }

    public Object deleteById(Long id) {
        Optional<User> user0 = this.userRepository.findById(id);

        if (user0.isEmpty()) {
            return null;
        } else {
            this.userRepository.deleteById(user0.get().getId());
            return "{\"message\": \"User was delete with success!\"}";
        }
    }
}
