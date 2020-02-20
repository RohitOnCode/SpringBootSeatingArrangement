package com.seating.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seating.dtos.EmployeeUser;

@Repository
public interface EmployeeUserRepository extends JpaRepository<EmployeeUser, Long> {
	
	Optional<EmployeeUser> findByEmployeeId(String employeeId);
	


}
