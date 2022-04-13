package com.app.service;
import java.util.List;
import com.app.pojos.*;

public interface IBookingService {
	List<Bookings> getAllBookingsById(int userId);
	Bookings bookRoom(int userid, Bookings booking);
	Bookings findByBookId(int bookId);
	Bookings updateBooking(Bookings booking);
	List<Bookings> getAllBookings();
}
