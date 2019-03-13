package com.example.demojquery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojquery.model.User;
import com.example.demojquery.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/api/users")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/api/users/{id}")
	public Optional<User> getUserById(@PathVariable(name = "id") int id) {
		return userService.getUserById(id);
	}

	@PostMapping("/api/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@PutMapping("/api/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable(name = "id") int id) {
		Optional<User> u = userService.getUserById(id);
		if (u != null) {
			User userTemp = u.get();
			userTemp.setName(user.getName());
			userTemp.setEmail(user.getEmail());
			userTemp.setPassword(user.getPassword());
			userTemp.setLanguage(user.getLanguage());
			userTemp.setRole(user.getRole());
			userService.updateUser(userTemp);
		}
	}

	@DeleteMapping("/api/users/{id}")
	public void deleteUser(@PathVariable(name = "id") int id) {
		userService.deleteUser(id);
	}
}
