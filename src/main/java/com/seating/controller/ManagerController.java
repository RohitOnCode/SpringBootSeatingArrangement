package com.seating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seating.dtos.Manager;
import com.seating.repositories.ManagerRepository;



@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	
	@Autowired
	private ManagerRepository managerRepo;
	
	
	@GetMapping("/getAllManagers")
	public List<Manager> getAllEmployees() {
		return managerRepo.findAll();
		
		
	}

}
