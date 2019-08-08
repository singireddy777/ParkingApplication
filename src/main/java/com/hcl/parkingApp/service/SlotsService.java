package com.hcl.parkingApp.service;

import org.springframework.stereotype.Service;

@Service
public interface SlotsService {

	public String assigningSlots();
	public String assignDailySlot();

	
}
