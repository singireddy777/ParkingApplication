package com.hcl.parkingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.parkingApp.entity.RequestForSlot;

public interface RequestSlotRepository extends JpaRepository<RequestForSlot, Integer>{

}
