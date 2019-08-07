package com.hcl.parkingApp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hcl.parkingApp.entity.Slots;

@Service
public interface SlotsService {

	public List<Slots> getSlotDetails();

	
}
