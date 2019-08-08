package com.hcl.parkingApp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parkingApp.service.SlotsService;

@RestController
public class SlotsController {

	@Autowired SlotsService slotService;
	@GetMapping("/assignSlots")
	
public String assignSlotDetails() {
	return slotService.assigningSlots();
}
	
	@PutMapping("/dailySlots")
	@Scheduled(fixedRate = 200000)
	public String assignDailySlots() {
		System.out.println("start"+new Date());
		return slotService.assignDailySlot();
		
	}
	
}
