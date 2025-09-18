package com.example.demo.service;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

public interface EmployeeService {

	EmployeeDTO add(EmployeeDTO  dto);
	   
	EmployeeDTO update(Integer id,EmployeeDTO  dto);
	   
	void delete(Integer id);
	   
	EmployeeDTO get(Integer id);
	   
	   
	   
}
