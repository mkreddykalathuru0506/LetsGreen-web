package com.letsGreen.controller;

import com.letsGreen.entity.User;
import com.letsGreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return new ResponseEntity<>("User created with ID: " + createdUser.getUserId(), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<String> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>("All Users: " + users.toString(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
		User updatedUser = userService.updateUser(id, user);
		if (updatedUser != null) {
			return new ResponseEntity<>("User updated: " + updatedUser.toString(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted", HttpStatus.NO_CONTENT);
	}
}
