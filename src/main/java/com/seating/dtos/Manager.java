package com.seating.dtos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "Manager", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID")})
public class Manager implements Serializable   {

	private static final long serialVersionUID = -2517851941873251699L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer managerId;
	
	
	@NaturalId
	private String  managerEmployeeId;

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerEmployeeId=" + managerEmployeeId +
				  ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", allocatedSeat=" + allocatedSeat + "]";
	}

	
	  @OneToMany(mappedBy="manager",fetch = FetchType.LAZY) private
	  List<EmployeeUser> employeeUsers;
	 
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(name = "LAST_NAME", unique = true, nullable = false, length = 100)
	private String lastName;
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String emailId;
	
	
	@Column(name = "SEAT_NO", unique = true, nullable = false)
	 private String allocatedSeat; 

	public String getAllocatedSeat() {
		return allocatedSeat;
	}

	public void setAllocatedSeat(String allocatedSeat) {
		this.allocatedSeat = allocatedSeat;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	public String getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(String managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public List<EmployeeUser> getEmployeeUsers() {
		return employeeUsers;
	}

	public void setEmployeeUsers(List<EmployeeUser> employeeUsers) {
		this.employeeUsers = employeeUsers;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
