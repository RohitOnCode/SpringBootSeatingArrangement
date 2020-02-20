package com.seating.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seating.dtos.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Optional<Admin> findByEmployeeId(String employeeId) ;
	
	

}
