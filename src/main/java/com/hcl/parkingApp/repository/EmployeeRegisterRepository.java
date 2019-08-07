package com.hcl.parkingApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkingApp.entity.Employee;
@Repository
public interface EmployeeRegisterRepository extends JpaRepository<Employee, Long>{

	public Employee findByEmpName(String empName);

}
