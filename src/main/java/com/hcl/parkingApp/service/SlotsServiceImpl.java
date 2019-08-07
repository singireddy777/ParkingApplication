package com.hcl.parkingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.repository.EmployeeRegisterRepository;
import com.hcl.parkingApp.repository.SlotsRepository;

@Service
public class SlotsServiceImpl implements SlotsService{

	@Autowired SlotsRepository slotRepo;
	@Autowired EmployeeRegisterRepository empRepository;
	
	public List<Slots> getSlotDetails() {
		List<Employee> employee = empRepository.findAll();
		//List<Slots> slots = slotRepo.findAll();
		Slots slots1 = null;
		for(Employee emp :employee) {
			
			if(emp.getDesignation().equalsIgnoreCase("CEO")||emp.getDesignation().equalsIgnoreCase("CHAIRMAN")||emp.getDesignation().equalsIgnoreCase("President")||emp.getJoinedYear()>15) {
				slots1 = new Slots();
				slots1.setEmployee(emp);
				slots1.setSlotDesc(slots1.getSlotDesc());
				slots1.setSlotId(slots1.getSlotId());
				slots1.setSlotStatus(slots1.getSlotStatus());
				slotRepo.save(slots1);
			}
		}
		return slotRepo.findAll();
	}
}
