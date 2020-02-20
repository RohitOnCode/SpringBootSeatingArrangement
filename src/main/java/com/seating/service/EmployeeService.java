package com.seating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.seating.dtos.EmployeeUser;
import com.seating.repositories.EmployeeUserRepository;

public class EmployeeService {

	
	@Autowired
	private EmployeeUserRepository employeeRepo;
	
	public List<EmployeeUser> getEmployeeDetails() {
		return employeeRepo.findAll();
		
	}
}
