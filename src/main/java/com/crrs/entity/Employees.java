package com.crrs.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	private String name;

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + "]";
	}
}
