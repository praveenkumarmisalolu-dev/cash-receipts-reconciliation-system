package com.crrs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crrs.entity.Employees;
import com.crrs.repository.EmployeesRepository;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;
    

    public List<Employees> getAllUsers() {
        return employeesRepository.findAll();
    }

    public Employees saveUser(Employees user) {
        return employeesRepository.save(user);
    }
    
//    public Employees deleteUser(Employees user) {
//    	
//    	
//        return employeesRepository.save(user);
//    }
}
