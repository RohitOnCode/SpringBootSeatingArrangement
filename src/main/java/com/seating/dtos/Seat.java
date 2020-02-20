package com.seating.dtos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity(name = "Seat")
@Table(name = "Seat", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Seat implements Serializable {
	private static final long serialVersionUID = -2517851941873851698L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", isAllocated=" + isAllocated + ", occupiedBy= ]";
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

   
	@Column(name = "SEAT_NO", unique = false, nullable = true)
	private String seatNo;
	
	@Column(name = "IS_ALLOCATED", unique = false, nullable = true)
	private String isAllocated;
	

	
	@Column(name = "OCCUPIED_BY", unique = false, nullable = true)
	private String occupiedBy;
	
	

	public String getOccupiedBy() {
		return occupiedBy;
	}

	public void setOccupiedBy(String occupiedBy) {
		this.occupiedBy = occupiedBy;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	

	public String getIsAllocated() {
		return isAllocated;
	}

	public void setIsAllocated(String isAllocated) {
		this.isAllocated = isAllocated;
	}


}
