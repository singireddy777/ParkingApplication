package com.hcl.parkingApp.dto;

public class EmployeeDTO {
	
	private long empId;
	private String empName;
	private String password;
	private String designation;
	private int joinedYear;
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getJoinedYear() {
		return joinedYear;
	}
	public void setJoinedYear(int joinedYear) {
		this.joinedYear = joinedYear;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", joinedYear="
				+ joinedYear + "]";
	}
	
	
}
