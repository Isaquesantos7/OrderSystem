package com.OrderSystem.Order.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OrderSystem.Order.DTOS.UserDTO;
import com.OrderSystem.Order.entities.User;
import com.OrderSystem.Order.repositories.UserRepository;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/api/users")
	public ResponseEntity<List<User>> findAll() {
		List<User> listUser = this.userRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(listUser);
	}
	
	@PostMapping("/api/users")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO) {
		User user = new User();
		
		BeanUtils.copyProperties(userDTO, user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userRepository.save(user));
	}
}
