package com.app.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.BookingRepository;
import com.app.pojos.Bookings;
import com.app.pojos.User;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService{
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	IUserService userService;
	

	@Override
	public Bookings bookRoom(int userid, Bookings booking) {
		User user = userService.findById(userid);
		booking.setUser(user);
		return bookingRepo.save(booking);
	}


	@SuppressWarnings("null")
	@Override
	public List<Bookings> getAllBookingsById(int userId) {
		List<Bookings> allBookings = bookingRepo.findAll();
		List<Bookings> userBookings = new ArrayList<Bookings>();
		for (Bookings bookings : allBookings) {
			User user = bookings.getUser();
			System.out.println(user.getId());
			System.out.println(user.getId() == userId);
			System.out.println(user == null);
			if (user.getId() == userId) {
				System.out.println("In foreach");
				System.out.println(userBookings.add(bookings));
			}
		}
		return userBookings;
	}


	@Override
	public Bookings findByBookId(int bookId) {
		
		return bookingRepo.getById(bookId);
	}


	@Override
	public Bookings updateBooking(Bookings booking) {
		
		return bookingRepo.save(booking);
	}


	@Override
	public List<Bookings> getAllBookings() {
		
		return bookingRepo.findAll();
	}

	

}
