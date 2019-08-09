package com.hcl.parkingApp.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.entity.RequestForSlot;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.repository.EmployeeRegisterRepository;
import com.hcl.parkingApp.repository.RequestSlotRepository;
import com.hcl.parkingApp.repository.SlotsRepository;
import com.hcl.parkingApp.service.SlotsServiceImpl;

@RunWith(MockitoJUnitRunner.class)

public class SlotServiceTest {
  
	@Mock EmployeeRegisterRepository empRepo;
	@Mock SlotsRepository slotsRepo;
	@Mock RequestSlotRepository requestSlotRepo;
	@InjectMocks SlotsServiceImpl slotService;
	@Test
	public void assigningSlotsTest() {
		List<Employee> list = new ArrayList();
		Employee employee = new Employee();
		employee.setDesignation("ceo");
		employee.setEmpId(1);
		employee.setEmpName("shiva");
		employee.setJoinedYear(1990);
		employee.setPassword("kumar");
		list.add(employee);
		Slots slots = new Slots();
		slots.setDays(1);
		slots.setSlotDesc("blockA");
		slots.setEmployee(employee);
		slots.setSlotId(1);
		slots.setSlotStatus("available");
		Mockito.when(empRepo.findAll()).thenReturn(list);
		Mockito.when(slotsRepo.save(Mockito.any())).thenReturn(slots);
		String result = slotService.assigningSlots();
		assertEquals("slot assigned for you successfully....", result);
		
	}
	@Test
	
	public void assignDailySlotTest() {
		
		List<Slots> list = new ArrayList();
		Slots slots = new Slots();
		List<RequestForSlot> list1 = new ArrayList();
		RequestForSlot reqSlot = new RequestForSlot();
		slots.setEmployee(slots.getEmployee());
		slots.setDays(2);
		slots.setSlotId(22);
		slots.setSlotStatus("available");
		slots.setSlotDesc("blockB");
		
		reqSlot.setEmployee(reqSlot.getEmployee());
		reqSlot.setId(2);
		reqSlot.setSlotId(23);
		
		Mockito.when(slotsRepo.findAll()).thenReturn(list);
		Mockito.when(slotsRepo.save(Mockito.any())).thenReturn(list);
		
		Mockito.when(requestSlotRepo.findAll()).thenReturn(list1);
		Mockito.when(requestSlotRepo.save(Mockito.any())).thenReturn(reqSlot);
		
		String result = slotService.assignDailySlot();
		
		assertEquals("assign the daily slots successfully", result);
		
		
		
		
		
	}
}
