package com.app.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.UserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository userRepo; //dao layer dependency injection
	
	@Override
	public User authenticateUser(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("User login failed : Invalid Credentials"));
	}

	@Override
	public User addUser(User newUser) {
		
		return userRepo.save(newUser);
	}

	@Override
	public User updateUserDetails(User updatedUser, Integer id) {
		User existingUser = userRepo.getById(id);
		
		if(updatedUser.getFirstname().equals("") != true) {
			existingUser.setFirstname(updatedUser.getFirstname());
		}
		if(updatedUser.getLastname().equals("") != true) {
			existingUser.setLastname(updatedUser.getLastname());
		}
		if(updatedUser.getEmail().equals("") != true) {
			existingUser.setEmail(updatedUser.getEmail());
		}
		if(updatedUser.getMobilenumber().equals("") != true) {
			existingUser.setMobilenumber(updatedUser.getMobilenumber());
		}
		if(updatedUser.getAddress().equals("") != true) {
			existingUser.setAddress(updatedUser.getAddress());
		}		
		return userRepo.save(existingUser);
	}

	@Override
	public void deleteUser(User user) {
		
		userRepo.delete(user);
	}

	@Override
	public User findById(Integer id) {
		
		return userRepo.getById(id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}

}
