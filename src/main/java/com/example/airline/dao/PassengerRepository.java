package com.example.airline.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.airline.entity.Passengers;

@Repository
public interface PassengerRepository extends JpaRepository<Passengers, Long>{
}
