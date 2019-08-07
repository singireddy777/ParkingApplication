package com.hcl.parkingApp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Slots {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

	private long slotId;
    private String slotStatus;
	private String slotDesc;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empId")
	private Employee employee;
	
	
	public long getSlotId() {
		return slotId;
	}
	public void setSlotId(long slotId) {
		this.slotId = slotId;
	}
	
	public String getSlotStatus() {
		return slotStatus;
	}
	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getSlotDesc() {
		return slotDesc;
	}
	public void setSlotDesc(String slotDesc) {
		this.slotDesc = slotDesc;
	}
	@Override
	public String toString() {
		return "Slots [slotId=" + slotId + ", slotStatus=" + slotStatus + ", slotDesc=" + slotDesc + ", employee="
				+ employee + "]";
	}
	

}
