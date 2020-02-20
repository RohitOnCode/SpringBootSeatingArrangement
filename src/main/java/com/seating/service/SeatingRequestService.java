package com.seating.service;

import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seating.dtos.Admin;
import com.seating.dtos.EmployeeUser;
import com.seating.dtos.Manager;
import com.seating.dtos.Seat;
import com.seating.dtos.SeatingRequest;
import com.seating.notification.EmailSender;
import com.seating.repositories.AdminRepository;
import com.seating.repositories.EmployeeUserRepository;
import com.seating.repositories.ManagerRepository;
import com.seating.repositories.SeatRepository;

@Component
public class SeatingRequestService {

	@Autowired
	private EmployeeUserRepository employeeUserRepository;

	@Autowired
	private ManagerRepository managerRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private EmailSender emailSender;

	private static final Logger LOGGER = LoggerFactory.getLogger(SeatingRequestService.class);

	public EmployeeUser changeSeatingForEmployee(SeatingRequest request) throws Exception {

		String oldseatNo = null;
		String newSeatNo = null;
		String managerId = null;
		String employeeId = request.getEmployeeId();
		Optional<Manager> manager = null;
		Optional<EmployeeUser> employee = null;
		EmployeeUser updatedEmployee = null;
		String email=null;
		String managerEmail=null;
		if (Objects.nonNull(managerId = request.getManagerId())) {
			manager = managerRepo.findByManagerEmployeeId(managerId);
			LOGGER.info("Manager fetched from DB : {}", manager);
		}

		if (manager.isPresent() && Objects.nonNull(employeeId)) {
			employee = employeeUserRepository.findByEmployeeId(employeeId);
			LOGGER.info("Employee fetched from DB : {}", employee);
		}

		if (employee.isPresent()) {
			EmployeeUser fetchedEmployee = employee.get();
			email=fetchedEmployee.getEmail();
			managerEmail=fetchedEmployee.getManager().getEmailId();
			LOGGER.info("Sending Email");
			//emailSender.sendEmail(email,managerEmail);
			fetchedEmployee.setAllocatedSeat(request.getNewSeat());
			updateSeatingDetails(request, fetchedEmployee);
			LOGGER.info("The fetched Employee Object is : {}", fetchedEmployee.getManager());

			updatedEmployee = employeeUserRepository.save(employee.get());
			

			LOGGER.info("Updated Employee with new Seating arrangements with Seat no as : {} , {}", updatedEmployee, updatedEmployee.getAllocatedSeat() );
		}

		else {
			 throw new Exception("Employee Does not Exists");
		}

		return updatedEmployee;
	}

	/**
	 * 
	 * This method is used to cover the use case of seating update by manager
	 * @param request
	 * @param fetchedEmployee
	 */
	private void updateSeatingDetails(SeatingRequest request, EmployeeUser fetchedEmployee) {
		String oldseatNo;
		String newSeatNo;
		if (Objects.nonNull(fetchedEmployee.getAllocatedSeat())) {

			// find By Seat Number
			oldseatNo = request.getOldSeat();
			newSeatNo = request.getNewSeat();
			Seat oldSeatDet=seatRepo.findBySeatNo(oldseatNo).get();
			Seat seatDet = seatRepo.findBySeatNo(newSeatNo).get();
			
			oldSeatDet.setOccupiedBy(null);
			oldSeatDet.setIsAllocated("NO");
			LOGGER.info("Updating Old Seating Details ");
			seatRepo.save(oldSeatDet);
			
			seatDet.setOccupiedBy(fetchedEmployee.getEmployeeId());
			seatDet.setIsAllocated("YES");
		
			
			
			
			LOGGER.info("Updating New Employee Details");
			seatRepo.save(seatDet);
			
			fetchedEmployee.setAllocatedSeat(newSeatNo);
			
		}
	}

	/**
	 * 
	 * 
	 * THis method is used to cover the use case of an update by an admin 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public EmployeeUser changeSeatingForEmployeeByAdmin(SeatingRequest request) throws Exception {

		String oldseatNo = null;
		String newSeatNo = null;
		String adminId = null;
		
		//get the employee ID of employee whose seat has to be changed
		String employeeId = request.getEmployeeId();
		Optional<Admin> admin = null;
		Optional<EmployeeUser> employee = null;
		EmployeeUser updatedEmployee = null;
		if (Objects.nonNull(adminId = request.getAdminId())) {
			admin = adminRepo.findByEmployeeId(adminId);
			LOGGER.info("Admin fetched from DB : {}", admin.get());
		}

		if (admin.isPresent() && Objects.nonNull(employeeId)) {
			employee = employeeUserRepository.findByEmployeeId(employeeId);
			LOGGER.info("Employee fetched from DB : {}", employee);
		}

		if (employee.isPresent()) {
			EmployeeUser fetchedEmployee = employee.get();
			fetchedEmployee.setAllocatedSeat(request.getNewSeat());
			updateSeatingDetails(request, fetchedEmployee);
			LOGGER.info("The fetched Employee Object is : {}", fetchedEmployee.getManager());

			updatedEmployee = employeeUserRepository.save(employee.get());
			

			LOGGER.info("Updated Employee with new Seating arrangements with Seat no as : {} , {}", updatedEmployee, updatedEmployee.getAllocatedSeat());
		}

		else {
			 throw new Exception("Employee Does not Exists");
		}

		return updatedEmployee;
	}
}
