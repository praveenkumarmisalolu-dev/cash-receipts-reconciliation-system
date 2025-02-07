package com.crrs.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crrs.controller.EmployeesController;
import com.crrs.entity.Employees;
import com.crrs.repository.EmployeesRepository;

@Service
public class EmployeesService {
	
	private static final Logger logger = LogManager.getLogger(EmployeesController.class);
	
    @Autowired
    private EmployeesRepository employeesRepository;
    

    public List<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }
    
    
    public Optional<Employees> getEmployeeById(Long id) {
        return employeesRepository.findById(id);
    }
    

    public Employees saveEmployee(Employees user) {
        return employeesRepository.save(user);
    }
    
    public void deleteEmployee(Long id) {
    	
    	logger.info("deleted the employee based on user id {} : "+ id);

    	employeesRepository.deleteById(id); 
    }
    
    public Employees updateEmployee(Long id, Employees employeeDetails) {
        return employeesRepository.findById(id).map(employee -> {
        	    employee.setFirstName(employeeDetails.getFirstName());
        	    employee.setLastName(employeeDetails.getLastName());
        	    employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        	    employee.setGender(employeeDetails.getGender());
        	    employee.setEmail(employeeDetails.getEmail());
        	    employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        	    employee.setAddress(employeeDetails.getAddress());
        	    employee.setEmployeeCode(employeeDetails.getEmployeeCode());
        	    employee.setDesignation(employeeDetails.getDesignation());
        	    employee.setDepartment(employeeDetails.getDepartment());
        	    employee.setDateOfJoining(employeeDetails.getDateOfJoining());
        	    employee.setEmploymentType(employeeDetails.getEmploymentType());
        	    employee.setManager(employeeDetails.getManager());
        	    employee.setSalary(employeeDetails.getSalary());
        	    employee.setBonus(employeeDetails.getBonus());
        	    employee.setTaxDeductions(employeeDetails.getTaxDeductions());
        	    employee.setUsername(employeeDetails.getUsername());
        	    employee.setPasswordHash(employeeDetails.getPasswordHash());
        	    employee.setRole(employeeDetails.getRole());
        	    employee.setStatus(employeeDetails.getStatus());
        	    employee.setProfilePictureUrl(employeeDetails.getProfilePictureUrl());
        	    employee.setEmergencyContactName(employeeDetails.getEmergencyContactName());
        	    employee.setEmergencyContactNumber(employeeDetails.getEmergencyContactNumber());
        	    employee.setCreatedAt(employeeDetails.getCreatedAt());
        	    employee.setUpdatedAt(employeeDetails.getUpdatedAt());
        	return employeesRepository.save(employee);
                        
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    
    
}
