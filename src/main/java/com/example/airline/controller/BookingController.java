package com.example.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.entity.Booking;
import com.example.airline.service.BookingService;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
		Booking booking = bookingService.getBookingById(id);
		return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails){
		Booking updatedBooking = bookingService.updateBooking(id, bookingDetails);
		return updatedBooking != null ? ResponseEntity.ok(updatedBooking) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
	    bookingService.deleteBooking(id);
		return ResponseEntity.noContent().build();
		
	}
}
