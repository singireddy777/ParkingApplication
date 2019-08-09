package com.hcl.parkingApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 
	private long empId;
    private String password;
    private String empName;
	private String designation;
	private int joinedYear;
	
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long empId, String password, String empName, String designation, int joinedYear) {
		super();
		this.empId = empId;
		this.password = password;
		this.empName = empName;
		this.designation = designation;
		this.joinedYear = joinedYear;
	}
	public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
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
		return "Employee [empId=" + empId + ", password=" + password + ", empName=" + empName + ", designation="
				+ designation + ", joinedYear=" + joinedYear + "]";
	}
	
	
}
