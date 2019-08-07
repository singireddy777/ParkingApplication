package com.hcl.parkingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.parkingApp.entity.Slots;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Long>{

}
