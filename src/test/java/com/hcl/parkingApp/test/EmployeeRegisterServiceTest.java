package com.hcl.parkingApp.test;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.parkingApp.dto.EmployeeDTO;
import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.repository.EmployeeRegisterRepository;
import com.hcl.parkingApp.repository.SlotsRepository;
import com.hcl.parkingApp.service.EmployeeRegisterServiceImpl;
import com.hcl.parkingApp.service.SlotsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRegisterServiceTest {
	@Mock
	EmployeeRegisterRepository empRepo;
	
	@Mock
	SlotsRepository slotRepo;
	
	@InjectMocks
	EmployeeRegisterServiceImpl empService;
	
	@Mock 
	SlotsServiceImpl slotService;
	
	@Test
	public void registerEmployeeTest() {
		
		Employee employee = new Employee();
		EmployeeDTO empDTO = new EmployeeDTO();
		employee.setDesignation("president");
		employee.setEmpId(12);
		employee.setEmpName("goutham");
		employee.setPassword("reddy");
		employee.setJoinedYear(2012);
		BeanUtils.copyProperties(employee, empDTO);
		Mockito.when(empRepo.save(Mockito.any())).thenReturn(employee);
		String result = empService.registerEmployee(empDTO);
		assertEquals("Employee added successfully....", result);
	}
	@Test
	public void LoginEmployeeTest() {
		Employee employee = new Employee();
		employee.setDesignation("chairmaan");
		employee.setEmpId(11);
		employee.setEmpName("raja");
		employee.setJoinedYear(2011);
		employee.setPassword("rani");
		
		Mockito.when(empRepo.findByEmpName(employee.getEmpName())).thenReturn(employee);
	String result = empService.LoginEmployee(employee.getEmpName(), employee.getPassword());
	assertEquals("Login Successfully....", result);
	}
	
	@Test
	public void sendRequestTest() {
		Employee employee = new Employee();
		employee.setDesignation("ceo");
		employee.setEmpId(34);
		employee.setEmpName("shivakumar");
		employee.setJoinedYear(1990);
		employee.setPassword("kurni");
		
		Slots slots = new Slots();
		slots.setSlotId(22);
		slots.setSlotDesc("blockA");
		slots.setSlotStatus("Available");
		slots.setDays(4);
		
		Mockito.when(empRepo.findById(Mockito.any())).thenReturn(Optional.of(employee));
		String result = empService.sendRequest(employee.getEmpId());
		assertEquals("Request for slot has been sent successfully..", result);
	}
	
	@Test
	public void releaseSlotTest() {
		
		Slots slots = new Slots();
		slots.setDays(slots.getDays());
		slots.setEmployee(slots.getEmployee());
		slots.setSlotDesc("blockA");
		slots.setSlotId(21);
		slots.setSlotStatus("available");
		
		Mockito.when(slotRepo.findBySlotId(Mockito.anyInt())).thenReturn(slots);
		String result = empService.releaseSlot(slots.getSlotId(), slots.getDays());
		
		assertEquals("your slot released successfully for days", result);

	}
	
}
