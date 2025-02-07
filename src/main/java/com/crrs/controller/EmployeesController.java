package com.crrs.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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
    public List<Employees> getUsers() {
        return employeesService.getAllUsers();
    }
    
    // Getting data based on id
    @GetMapping("/{id}")
    public ResponseEntity<Employees> getProductById(@PathVariable Long id) {
        Optional<Employees> product = employeesService.getEmployeeById(id);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    // Creating employee
    @PostMapping
    public Employees createUser(@RequestBody Employees employee) {
        return employeesService.saveUser(employee);
    }
    
    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateProduct(@PathVariable Long id, @RequestBody Employees employeesDetails) {
        try {
        	Employees updatedProduct = employeesService.updateProduct(id, employeesDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    // 	Deleting employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    	employeesService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    
    

    
    
}
