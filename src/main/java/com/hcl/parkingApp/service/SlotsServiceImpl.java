package com.hcl.parkingApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingApp.entity.Employee;
import com.hcl.parkingApp.entity.RequestForSlot;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.repository.EmployeeRegisterRepository;
import com.hcl.parkingApp.repository.RequestSlotRepository;
import com.hcl.parkingApp.repository.SlotsRepository;

@Service
public class SlotsServiceImpl implements SlotsService{

	@Autowired SlotsRepository slotRepo;
	@Autowired EmployeeRegisterRepository empRepository;
	@Autowired RequestSlotRepository requestSlotRepo;
	Slots slots1 = null;
	public String assigningSlots() {
		List<Employee> employee = empRepository.findAll();
		//List<Slots> slots = slotRepo.findAll();
		
		for(Employee emp :employee) {
			
			if(emp.getDesignation().equalsIgnoreCase("CEO")||emp.getDesignation().equalsIgnoreCase("CHAIRMAN")||emp.getDesignation().equalsIgnoreCase("President")||emp.getJoinedYear()>15) {
				slots1 = new Slots();
				slots1.setEmployee(emp);
				slots1.setSlotDesc("blockA");
				slots1.setSlotId(slots1.getSlotId());
				slots1.setSlotStatus("Available");
				slots1.setDays(1);
				slotRepo.save(slots1);
			}else {
				
				Slots slots2 = new Slots();
				
				slots2.setEmployee(emp);
				slots2.setSlotDesc("blockB");
				slots2.setSlotId(slots2.getSlotId());
				slots2.setSlotStatus("occupied");
				slots2.setDays(0);
				slotRepo.save(slots2);
			}
		}
		return "slot assigned for you successfully....";
	}
	
	@Override
	public String assignDailySlot() {
		int arr[] = new int[5];
		int i = 0;
		List<Slots> list = slotRepo.findAll();
		for(Slots slot : list) {
			if(slot.getSlotStatus().equalsIgnoreCase("occupied")) {
				arr[i] = slot.getSlotId();
				if(slot.getDays()!=0) {
				int a = slot.getDays()-1;
					slot.setDays(a);
					if(a==0) {
						slot.setSlotStatus("Available");
						}
					slotRepo.save(slot);
				}
				i++;
			}
			i=0;
			List<RequestForSlot> re = requestSlotRepo.findAll();
			for(RequestForSlot r : re) {
				r.setSlotId(arr[i]);
				requestSlotRepo.save(r);
				i++;
			}
		}
		System.out.println("end"+new Date());
		return "assign the daily slots successfully";
	}

}
