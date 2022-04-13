package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	User authenticateUser(String email, String password);
	User addUser(User newUser);
	User updateUserDetails(User updatedUser, Integer id);
	void deleteUser(User user);
	User findById(Integer id);
	List<User> getAllUsers();
}
