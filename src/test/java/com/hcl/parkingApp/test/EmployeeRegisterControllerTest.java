package com.hcl.parkingApp.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.parkingApp.controller.EmplyeeRegistrationController;
import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.service.EmployeeRegisterService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class EmployeeRegisterControllerTest {

	@Mock
	EmployeeRegisterService empService;
	@InjectMocks
	EmplyeeRegistrationController employeeRegisterController;
	private MockMvc mockmvc;
	Employee employee;
	Slots slots = new Slots();
	@Before
	public void setUp() {
		employee = new Employee(1L, "12345", "Venkat", "CEO", 2001);
//		employee.setDesignation("president");
//		employee.setEmpId(1L);
//		employee.setEmpName("mahesh");
//		employee.setJoinedYear(2012);
//		employee.setPassword("gowtham");
		mockmvc = MockMvcBuilders.standaloneSetup(employeeRegisterController).build();	
	}
	@Test
	public void userRegistrationTest() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/employeeRegistration").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employee)));
	}
	@Test
	public void employeeLogin() throws Exception{
		
		mockmvc.perform(MockMvcRequestBuilders.post("/empLogin").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employee)));	
	}
	
	@Test
	public void employeeReleaseTest() throws Exception {
		
		mockmvc.perform(MockMvcRequestBuilders.post("/releaseSlot/{slotId}/{days}",1,3).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(employee)));
	}
	
	public static String asJsonString(final Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
