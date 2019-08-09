package com.hcl.parkingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingApp.dto.EmployeeDTO;
import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.entity.RequestForSlot;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.repository.EmployeeRegisterRepository;
import com.hcl.parkingApp.repository.RequestSlotRepository;
import com.hcl.parkingApp.repository.SlotsRepository;
@Service
public class EmployeeRegisterServiceImpl implements EmployeeRegisterService{

	@Autowired EmployeeRegisterRepository empRepository;
	@Autowired RequestSlotRepository requestRepo;
	@Autowired SlotsRepository slotsRepo;
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
			
	         if(employee.getEmpName().equalsIgnoreCase(empName)&&employee.getPassword().equals(password)) {
	
	    return "Login Successfully....";
	        }
	else { 
	       return "something went wrong please try again....";
	}
	}
	return "Employee doen't exist";
}
	@Override
	public String sendRequest(long empId) {
		
		Employee employee= empRepository.findById(empId).get();	
		RequestForSlot req = new RequestForSlot();
		req.setEmployee(employee);
		req.setSlotId(req.getSlotId());
		
		requestRepo.save(req);
		
		return "Request for slot has been sent successfully.. ";
	}
	
	@Override
	public String releaseSlot(int slotId, int days) {
		
		Slots slot = slotsRepo.findBySlotId(slotId);
		slot.setSlotStatus("Available");
		slot.setDays(days);
		slotsRepo.save(slot);
		
		return "your slot released successfully for days";
	}

	

}
