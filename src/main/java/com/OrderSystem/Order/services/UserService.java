package com.OrderSystem.Order.services;

import com.OrderSystem.Order.DTOS.UserDTO;
import com.OrderSystem.Order.entities.User;
import com.OrderSystem.Order.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
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

    public User deleteById(Long id) {
        User user = this.userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        this.userRepository.deleteById(id);

        return user;
    }

    public User updateUser(Long id, UserDTO updateUserDTO) {
        User user = this.userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        BeanUtils.copyProperties(updateUserDTO, user, "id");
        return this.userRepository.save(user);
    }

}
