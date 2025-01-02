package com.example.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.entity.Passengers;
import com.example.airline.service.PassengerService;

@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@GetMapping
	public List<Passengers> getAllPassengers(){
		return passengerService.getAllPassengers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Passengers> getPassengersById(@PathVariable Long id){
		Passengers passengers = passengerService.getPassengersById(id);
		return passengers != null ? ResponseEntity.ok(passengers) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Passengers createPassengers(@RequestBody Passengers passengers) {
		return passengerService.createPassengers(passengers);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Passengers> updatePassenger(@PathVariable Long id, @RequestBody Passengers passengersDetails){
		Passengers updatedPassengers = passengerService.updatePassengers(id, passengersDetails);
		return updatedPassengers != null ? ResponseEntity.ok(updatedPassengers) : ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Void> deletePassengers(@PathVariable Long id){
		passengerService.deletePassenger(id);
		return ResponseEntity.noContent().build();
	}

}
