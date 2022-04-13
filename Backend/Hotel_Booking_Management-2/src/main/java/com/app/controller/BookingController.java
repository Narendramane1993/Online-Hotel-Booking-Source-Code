package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.Response;
import com.app.pojos.Bookings;
import com.app.service.BookingServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingServiceImpl bookingService;
	
	@PostMapping("/book/{userid}")
	public ResponseEntity<?> bookRoom(@PathVariable int userid, @ModelAttribute Bookings booking){
		try {
		System.out.println("In book room");
		System.out.println("id : "+userid+" Booking date : "+booking.getStart_date()+" - "+booking.getEnd_date());
		System.out.println("City : "+booking.getCity());
		System.out.println("2");
		Bookings newBooking = bookingService.bookRoom(userid, booking);
		System.out.println("3");
		return Response.success(newBooking);
		}catch(Exception e) {
			System.out.println("4");
			return Response.error("Booking failed!!!");
		}
	}
	
	@GetMapping("/allbookings/{userid}")
	public ResponseEntity<?> getAllBookings(@PathVariable int userid){
		try {
			List<Bookings> allBookings = bookingService.getAllBookingsById(userid);
			return Response.success(allBookings);
		}catch (Exception e) {
			return Response.error("No Bookings");
		}
	}

}
