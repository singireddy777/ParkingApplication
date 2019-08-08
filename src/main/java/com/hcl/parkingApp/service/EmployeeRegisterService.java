package com.hcl.parkingApp.service;

import org.springframework.stereotype.Service;

import com.hcl.parkingApp.dto.EmployeeDTO;

@Service
public interface EmployeeRegisterService {

	public String registerEmployee(EmployeeDTO employeeDTO);

	public String LoginEmployee(String empName, String password);

	public String sendRequest(long empId);

	public String releaseSlot(int slotId, int days);
	
	
}
