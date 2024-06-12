package com.OrderSystem.Order.controllers;

import com.OrderSystem.Order.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.OrderSystem.Order.DTOS.UserDTO;
import com.OrderSystem.Order.entities.User;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/api/users")
	public ResponseEntity<List<User>> findAll() {
		List<User> listUser = this.userService.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(listUser);
	}

	@GetMapping("/api/users/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Object user = this.userService.findById(id);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"User not found!\"}");
		}

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PostMapping("/api/users")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO) {
		User user = new User();

		BeanUtils.copyProperties(userDTO, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
	}
}
