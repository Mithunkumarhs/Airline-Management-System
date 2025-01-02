package com.example.airline.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.airline.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
