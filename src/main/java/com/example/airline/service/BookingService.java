package com.example.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dao.BookingRepository;
import com.example.airline.entity.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id).orElse(null);
	}
	
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	public Booking updateBooking(Long id, Booking bookingDetails) {
		Booking booking = bookingRepository.findById(id).orElse(null);
		
		if(booking != null) {
			booking.setBookingDate(bookingDetails.getBookingDate());
			booking.setSeatNumber(bookingDetails.getSeatNumber());
			booking.setFlights(bookingDetails.getFlights());
			booking.setPassengers(bookingDetails.getPassengers());
			
			return bookingRepository.save(booking);
		}
		
		return null;
	}
	
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
	}
	
	
}
