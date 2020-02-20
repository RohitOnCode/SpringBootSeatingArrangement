package com.seating.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seating.dtos.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long>{

	
	Optional<Manager> findByManagerEmployeeId(String managerEmployeeId);
}
