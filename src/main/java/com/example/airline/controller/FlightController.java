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

import com.example.airline.entity.Flights;
import com.example.airline.service.FlightService;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping
	public List<Flights> getAllFlights(){
		return flightService.getAllFlights();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Flights> getFlightsById(@PathVariable Long id){
		Flights flights = flightService.getFlightsById(id);
		return flights != null ? ResponseEntity.ok(flights) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Flights createFlights(@RequestBody Flights flights) {
		return flightService.createFlights(flights);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Flights> updateFlights(@PathVariable Long id, @RequestBody Flights flightDetails){
		Flights updateFlights = flightService.updateFlights(id, flightDetails);
		return updateFlights != null ? ResponseEntity.ok(updateFlights) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFlights(@PathVariable Long id){
		flightService.deleteFlights(id);
		return ResponseEntity.noContent().build();
	}

}
