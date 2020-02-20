package com.seating.dtos;

public class SeatingRequest {
	
	
	private String managerId;
	
	private String employeeId;
	
	private String adminId;
	
	private String oldSeat;
	
	private boolean isAllocated;
	
	public boolean isAllocated() {
		return isAllocated;
	}

	public void setAllocated(boolean isAllocated) {
		this.isAllocated = isAllocated;
	}

	public String getSeatAllocated() {
		return seatAllocated;
	}

	public void setSeatAllocated(String seatAllocated) {
		this.seatAllocated = seatAllocated;
	}

	private String seatAllocated;
	
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getOldSeat() {
		return oldSeat;
	}

	public void setOldSeat(String oldSeat) {
		this.oldSeat = oldSeat;
	}

	public String getNewSeat() {
		return newSeat;
	}

	public void setNewSeat(String newSeat) {
		this.newSeat = newSeat;
	}

	private String newSeat;
	
	

}
