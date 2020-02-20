package com.seating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seating.dtos.EmployeeUser;
import com.seating.repositories.EmployeeUserRepository;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeUserRepository employeeRepo;
	
	
	@GetMapping("/getAllEmployees")
	public List<EmployeeUser> getAllEmployees() {
		return employeeRepo.findAll();
		
		
	}

}
