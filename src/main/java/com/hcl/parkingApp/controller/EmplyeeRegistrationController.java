package com.hcl.parkingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parkingApp.dto.EmployeeDTO;
import com.hcl.parkingApp.service.EmployeeRegisterService;

@RestController
public class EmplyeeRegistrationController {
	@Autowired
	EmployeeRegisterService empService;
	@PostMapping("/employeeRegistration")
public String userRegistration(@RequestBody EmployeeDTO employeeDTO) {
	
	return empService.registerEmployee(employeeDTO);
}
	
@PostMapping("empLogin")	
public String employeeLogin(@RequestParam ("empName") String empName, @RequestParam ("password") String password) {
	
return empService.LoginEmployee(empName, password);

}

@PostMapping("/requestaSlot")
public String requestAslot(long empId){
	return empService.sendRequest(empId);
}
	
@PutMapping("/releaseSlot/{slotId}/{days}")
public String employeeRelease(@PathVariable int slotId, @PathVariable int days){
	return empService.releaseSlot(slotId,days);
}
}
