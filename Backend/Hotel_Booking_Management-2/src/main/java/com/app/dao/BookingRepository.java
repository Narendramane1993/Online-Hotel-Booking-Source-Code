package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer>{
	
}
