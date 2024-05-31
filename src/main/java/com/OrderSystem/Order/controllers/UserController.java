package com.OrderSystem.Order.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderSystem.Order.entities.User;

@RestController
public class UserController {

	@GetMapping("/api/users")
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Isaque", "isaquesantos.1998@gmail.com", "+5571987308769", "86992134");
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}
