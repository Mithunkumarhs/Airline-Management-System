package com.example.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.airline.dao.FlightRepository;
import com.example.airline.entity.Flights;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flights> getAllFlights(){
		return flightRepository.findAll();
	}
	
	public Flights getFlightsById(Long id) {
		return flightRepository.findById(id).orElse(null);
	}
	
	public Flights createFlights(Flights flights) {
		return flightRepository.save(flights);
	}
	
	public Flights updateFlights(Long id, Flights flightsDetails) {
		Flights flights = flightRepository.findById(id).orElse(null);
		
		if(flights != null) {
			flights.setOrigin(flightsDetails.getOrigin());
			flights.setDestination(flightsDetails.getDestination());
            flights.setDepartureTime(flightsDetails.getDepartureTime());
            flights.setArrivalTime(flightsDetails.getArrivalTime());
            flights.setCapacity(flightsDetails.getCapacity());
            flights.setAvailableSeats(flightsDetails.getAvailableSeats());
            return flightRepository.save(flights);
		}
		
		return null;
	}
	
	public void deleteFlights(Long id) {
		flightRepository.deleteById(id);
	}

}
