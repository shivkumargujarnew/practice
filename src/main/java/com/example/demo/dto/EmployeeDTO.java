package com.example.demo.dto;


import com.example.demo.entity.Employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeDTO {

	
	 private Integer id;
	 private String name;
	 private Double salary;
	
	  
}
