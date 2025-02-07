package com.crrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crrs.entity.Employees;
import com.crrs.repository.EmployeesRepository;

@SpringBootApplication
public class CashReceiptsReconciliationSystem {

	public static void main(String[] args) {
		SpringApplication.run(CashReceiptsReconciliationSystem.class, args);
	}
}
