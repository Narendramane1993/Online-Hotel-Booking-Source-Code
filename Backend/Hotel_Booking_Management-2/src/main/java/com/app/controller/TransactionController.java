package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.Response;
import com.app.pojos.Bookings;
import com.app.pojos.Transaction;

import com.app.service.IBookingService;
import com.app.service.IUserService;
import com.app.service.TransactionServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionServiceImpl transactionService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IBookingService bookingService;
	
	
	@PostMapping("/payment")
	public ResponseEntity<?> transactionHotel(@RequestParam int userid, @RequestParam int amount, @RequestParam int bookId){
		try {
		System.out.println("In TransactionHotel");
		System.out.println("id : "+userid);
		System.out.println("2");
		
		Bookings currentBooking = bookingService.findByBookId(bookId);
		
		Transaction newTransaction = new Transaction(amount,1);
		Transaction transaction = transactionService.transactionDetails(userid, newTransaction);
		
		currentBooking.setTransaction(transaction);
		bookingService.updateBooking(currentBooking);
		System.out.println("3");
		return Response.success(transaction);
		}catch(Exception e) {
			System.out.println("4");
			System.out.println(e);
			return Response.error("Transaction failed!!!");
		}
	}

}
