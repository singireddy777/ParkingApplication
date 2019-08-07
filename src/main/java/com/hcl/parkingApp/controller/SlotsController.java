package com.hcl.parkingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.parkingApp.entity.Slots;
import com.hcl.parkingApp.service.SlotsService;

@RestController
public class SlotsController {

	@Autowired SlotsService slotService;
	@GetMapping("/getAllSlots")
public List<Slots> gettingSlotDetails() {
	return slotService.getSlotDetails();
	
}
	
}
