package com.crrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crrs.entity.Employees;
import com.crrs.service.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public List<Employees> getUsers() {
        return employeesService.getAllUsers();
    }

    @PostMapping
    public Employees createUser(@RequestBody Employees employee) {
        return employeesService.saveUser(employee);
    }
}
