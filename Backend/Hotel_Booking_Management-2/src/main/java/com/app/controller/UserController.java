package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.User;
import com.app.service.IUserService;
import com.app.model.Credentials;
import com.app.model.Response;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService; //service layer dependency injection
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> autheticate(@RequestParam String email, @RequestParam String password) {
		try {
			User user = userService.authenticateUser(email, password);
			System.out.println(user.getFirstname()+" "+user.getLastname());
			
			return Response.success(user);
		} catch (Exception e) {
			System.out.println("Error");
			return Response.error(e.getMessage());
		}

	}
	//method to register the user into database
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@ModelAttribute User user) {
		System.out.println(user);
		try {
			User newuser = userService.addUser(user);
			System.out.println("Name : "+user.getFirstname()+" "+user.getLastname());
			return Response.success(newuser);
		} catch (RuntimeException e) {
			return Response.error(e.getMessage());
		}

	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<?> updateUser(@ModelAttribute User newUser, @PathVariable int id) {
		try {
			System.out.println("In update user");
		newUser.setId(id);
		
		System.out.println("User Name : "+newUser.getFirstname()+"User id : "+newUser.getId());
		//newUser.setId(id);
		
		User modUser = userService.updateUserDetails(newUser,id);
		return Response.success(modUser);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return Response.error("Update Failed");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.findById(id);
		userService.deleteUser(user);
	}
	
	@GetMapping("/userprofile/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id){
		System.out.println("In get user details");
		User user = userService.findById(id);
		System.out.println(""+user.getFirstname()+""+user.getLastname());
		return Response.success(user);
	}
}
