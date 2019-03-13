package com.example.demojquery.service;

import java.util.List;
import java.util.Optional;

import com.example.demojquery.model.User;

public interface UserService {
	public List<User> getAllUser();

	public Optional<User> getUserById(int id);

	public void updateUser(User user);

	public void deleteUser(int id);

	public void addUser(User user);

}
