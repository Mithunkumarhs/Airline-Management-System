package com.example.airline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@Column(name = "booking_date")
	private  String bookingDate;
	
	@Column(name = "seat_number")
	private String seatNumber;
	
	@ManyToOne
	@JoinColumn(name = "flight_id", nullable = false)
	private Flights flights;
	
	@ManyToOne
	@JoinColumn(name = "passenger_id", nullable = false)
	private Passengers passengers;

	public Booking(Long bookingId, String bookingDate, String seatNumber, Flights flights, Passengers passengers) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.seatNumber = seatNumber;
		this.flights = flights;
		this.passengers = passengers;
	}
	
	public Booking() {
		
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Flights getFlights() {
		return flights;
	}

	public void setFlights(Flights flights) {
		this.flights = flights;
	}

	public Passengers getPassengers() {
		return passengers;
	}

	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}
	
	
}
