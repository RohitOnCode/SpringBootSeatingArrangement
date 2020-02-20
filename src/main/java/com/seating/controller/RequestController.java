package com.seating.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seating.dtos.EmployeeUser;
import com.seating.dtos.SeatingRequest;
import com.seating.service.SeatingRequestService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired 
	private SeatingRequestService requestService;
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(SeatingRequest.class);
	@PostMapping("/change/seating")
	public EmployeeUser changeSeating(@RequestBody SeatingRequest request) {
		try {
			LOGGER.info("Received Request : {}", request );
			return requestService.changeSeatingForEmployee(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@PostMapping("/change/seating/admin")
	public EmployeeUser changeSeatingByAdminy(@RequestBody SeatingRequest request) {
		try {
			LOGGER.info("Received Request : {}", request );
			return requestService.changeSeatingForEmployeeByAdmin(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
