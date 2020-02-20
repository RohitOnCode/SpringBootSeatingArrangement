package com.seating.dtos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Employee", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class EmployeeUser implements Serializable  {
	
	
	private static final long serialVersionUID = -2517851941873251698L;

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
	
	/*
	 * @OneToOne(optional=true,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="SEAT_ALLOCATED", referencedColumnName = "seatNo") private
	 * Seat seat;
	 */

	public String getAllocatedSeat() {
		return allocatedSeat;
	}

	public void setAllocatedSeat(String allocatedSeat) {
		this.allocatedSeat = allocatedSeat;
	}

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@Override
	public String toString() {
		return "EmployeeUser [id=" + id + ", employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", manager=" + manager + ", allocatedSeat=" + allocatedSeat + "]";
	}

	@ManyToOne(optional=false,cascade = CascadeType.ALL)
	@JoinColumn(name = "MANAGER_ID", referencedColumnName = "managerEmployeeId")
	@JsonIgnoreProperties("employeeUsers")
	private Manager manager;

	@Column(name = "SEAT_NO", unique = true, nullable = false)
	private String allocatedSeat;

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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	
	/*
	 * public Seat getSeat() { return seat; }
	 * 
	 * public void setSeat(Seat seat) { this.seat = seat; }
	 */

}
