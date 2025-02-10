package com.crrs.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crrs.entity.Employees;
import com.crrs.service.EmployeesService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	
	private static final Logger logger = LogManager.getLogger(EmployeesController.class);
	
	
	@Autowired
    private EmployeesService employeesService;
	

	// Getting all employee data
    @GetMapping
    public String getEmployees(Model model){
    	
    	logger.info(" Getting all Employee data {} ");
    	model.addAttribute("employees", employeesService.getAllEmployees());
        return "employee-list";
    }
    
    // Getting data based on id
    @GetMapping("/view/{id}")
    public String getEmployeeById(@PathVariable Long id,  Model model) {
    	
    	logger.info(" Getting Employee based on id {} " + id);
    	model.addAttribute("employee", employeesService.getEmployeeById(id));
    	return "employee-details";
    }
    
    
    // Creating employee
    @GetMapping("/new")
    public String createEmployee(@ModelAttribute Employees employee) {
    	
    	
    	logger.info(" Adding the new employee {} ");
    	employeesService.saveEmployee(employee);
        return "redirect:/employees";
    }
    
    // Update employee
    @PutMapping("/edit/{id}")
    public String updateEmployees(@PathVariable Long id, Model model) {
        
    	model.addAttribute("employee", employeesService.getEmployeeById(id));
    	return "employee-details";	
    }
    
    
    // 	Deleting employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployees(@PathVariable Long id) {
    	
    	logger.info(" Deleting the existing employee {} "+ id);
    	employeesService.deleteEmployee(id);
    	
        return "redirect:/employees";
    }
    
}
