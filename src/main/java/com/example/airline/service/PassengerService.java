package com.example.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airline.dao.PassengerRepository;
import com.example.airline.entity.Passengers;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	public List<Passengers> getAllPassengers(){
		return passengerRepository.findAll();
	}
	
	public Passengers getPassengersById(Long id) {
		return passengerRepository.findById(id).orElse(null);
	}
	
	public Passengers createPassengers(Passengers passengers) {
		return passengerRepository.save(passengers);
	}
	
	public Passengers updatePassengers(Long id, Passengers passengersDetails) {
		Passengers passengers = passengerRepository.findById(id).orElse(null);
		
		if(passengers != null) {
		    passengers.setName(passengersDetails.getName());
		    passengers.setPassportNumber(passengersDetails.getPassportNumber());
		    passengers.setAge(passengersDetails.getAge());
		    passengers.setEmail(passengersDetails.getEmail());
		    passengers.setPhoneNumber(passengersDetails.getPhoneNumber());
		    return passengerRepository.save(passengers);
		}
		
		return null;
	}
	
	public void deletePassenger(Long id) {
		passengerRepository.deleteById(id);
	}
}
