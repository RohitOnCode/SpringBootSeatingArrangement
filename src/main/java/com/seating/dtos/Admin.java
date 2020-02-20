package com.seating.dtos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Admin")
@Table(name = "Admin", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	private String employeeId;

	@Column(name = "FIRST_NAME", unique = true, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", unique = true, nullable = false)
	private String lastName;

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@Column(name = "SEAT_NO", unique = true, nullable = false)
	private String allocatedSeat;

	public String getAllocatedSeat() {
		return allocatedSeat;
	}

	public void setAllocatedSeat(String allocatedSeat) {
		this.allocatedSeat = allocatedSeat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
