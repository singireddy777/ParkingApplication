package com.hcl.parkingApp.dto;

import java.io.Serializable;
import java.util.Date;

public class SlotsDTO implements Serializable{
	
	private static final long serialVersionUID = -325844461450241868L;
	
	private long SlotId;
	private String slotDesc;
	
	public long getSlotId() {
		return SlotId;
	}
	public void setSlotId(long slotId) {
		SlotId = slotId;
	}
	
	public String getSlotDesc() {
		return slotDesc;
	}
	public void setSlotDesc(String slotDesc) {
		this.slotDesc = slotDesc;
	}
	
	@Override
	public String toString() {
		return "SlotsDTO [SlotId=" + SlotId + ", slotDesc=" + slotDesc + "]";
	}
	
	
}
