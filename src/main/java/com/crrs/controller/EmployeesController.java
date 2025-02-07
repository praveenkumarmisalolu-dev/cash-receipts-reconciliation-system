package com.crrs.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crrs.entity.Employees;
import com.crrs.service.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
	
	private static final Logger logger = LogManager.getLogger(EmployeesController.class);
	
	
	@Autowired
    private EmployeesService employeesService;
	

	// Getting all employee data
    @GetMapping
    public List<Employees> getEmployees(){
    	logger.info(" Getting all Employee data {} ");
    	
        return employeesService.getAllEmployees();
    }
    
    // Getting data based on id
    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Long id) {
    	
    	logger.info(" Getting Employee based on id {} " + id);
        Optional<Employees> product = employeesService.getEmployeeById(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    // Creating employee
    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
    	
    	logger.info(" Adding the new employee {} ");
        return employeesService.saveEmployee(employee);
    }
    
    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployees(@PathVariable Long id, @RequestBody Employees employeesDetails) {
        try {
        	logger.info(" Updating the existing employee {} "+ id);
        	
        	Employees updatedEmployee = employeesService.updateEmployee(id, employeesDetails);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    // 	Deleting employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployees(@PathVariable Long id) {
    	
    	logger.info(" Deleting the existing employee {} "+ id);
    	employeesService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    
}
