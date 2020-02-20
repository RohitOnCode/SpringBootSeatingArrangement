package com.seating.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seating.dtos.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long>{

	
Optional<Seat> findBySeatNo(String seatNo);
}
