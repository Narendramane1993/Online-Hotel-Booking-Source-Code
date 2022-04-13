package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.Response;
import com.app.pojos.Admin;
import com.app.pojos.Bookings;
import com.app.pojos.User;
import com.app.service.IAdminService;
import com.app.service.IBookingService;
import com.app.service.ITransactionService;
import com.app.service.IUserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	@Autowired
	IBookingService bookingService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ITransactionService transactionService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> autheticate(@RequestParam String email, @RequestParam String password) {
		try {
			Admin admin = adminService.authenticateAdmin(email, password);
			System.out.println(admin.getFirstName()+" "+admin.getLastName());
			
			return Response.success(admin);
		} catch (Exception e) {
			System.out.println("Error");
			return Response.error(e.getMessage());
		}

	}
	
	@GetMapping("/getallbookings")
	public ResponseEntity<?> getAllBookings(){
		try {
			List<Bookings> allBookings = bookingService.getAllBookings();
			return Response.success(allBookings);
		}catch (Exception e) {
			System.out.println("Error");
			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<?> getAllUsers(){
		try {
			List<User> allUsers = userService.getAllUsers();
			return Response.success(allUsers);
		}catch (Exception e) {
			System.out.println("Error");
			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping("/revenue")
	public ResponseEntity<?> generateRevenue(){
		try {
			
			double revenue = transactionService.generateRevenue();
			return Response.success(revenue);
			
		}catch (Exception e) {
			System.out.println("Error");
			return Response.error(e.getMessage());
		}
	}
}
