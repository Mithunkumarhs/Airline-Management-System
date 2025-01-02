package com.example.airline.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airline.entity.Flights;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Long> {

}
