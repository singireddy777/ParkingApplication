package com.hcl.parkingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.parkingApp.entity.Slots;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Long>{

//@Query(value="SELECT * FROM parking_slot where user_id=?1", nativeQuery = true)
public Slots findBySlotId(int slotId);
}


