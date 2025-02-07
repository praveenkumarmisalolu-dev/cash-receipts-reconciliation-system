package com.crrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crrs.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
	

}
