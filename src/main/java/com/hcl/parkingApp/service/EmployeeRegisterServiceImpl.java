package com.hcl.parkingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingApp.dto.EmployeeDTO;
import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.repository.EmployeeRegisterRepository;
@Service
public class EmployeeRegisterServiceImpl implements EmployeeRegisterService{

	@Autowired EmployeeRegisterRepository empRepository;
	@Override
	public String registerEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmpId(employeeDTO.getEmpId());
		employee.setEmpName(employeeDTO.getEmpName());
		employee.setDesignation(employeeDTO.getDesignation());
		employee.setJoinedYear(employeeDTO.getJoinedYear());
		employee.setPassword(employeeDTO.getPassword());
		
		if(empRepository.save(employee) != null) {
			return "Employee added successfully....";
		}else {
			return "something went wrong..try again";
		}
	}
	@Override
	public String LoginEmployee(String empName, String password) {
		
		Employee employee = empRepository.findByEmpName(empName);
		if(employee!=null) {
			
	         if(employee.getEmpName().equalsIgnoreCase(empName)&&employee.getPassword().equalsIgnoreCase(password)) {
	
	    return "Login Successfully....";
	        }
	else { 
	       return "something went wrong please try again....";
	}
	}
	return "Employee doen't exist";
}
	
	

}
