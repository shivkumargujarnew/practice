package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDTO add(EmployeeDTO dto) {
		Employee emp = mapper.map(dto, Employee.class);

		Employee saved = repo.save(emp);

		EmployeeDTO empdto = mapper.map(saved, EmployeeDTO.class);

		return empdto;
	}

	@Override
	public EmployeeDTO update(Integer id, EmployeeDTO dto) {
	    Optional<Employee> empOptional = repo.findById(id);
	    
	    if (empOptional.isPresent()) {
	        Employee existingEmployee = empOptional.get();

	        // Update only necessary fields from dto to entity
	        existingEmployee.setName(dto.getName());
	        existingEmployee.setSalary(dto.getSalary());

	        // Save updated entity
	        Employee updatedEmployee = repo.save(existingEmployee);

	        // Convert back to DTO and return
	        return mapper.map(updatedEmployee, EmployeeDTO.class);
	    }

	    return null; // Or throw an exception like ResourceNotFoundException
	}


	@Override
	public void delete(Integer id) {
	    if (repo.existsById(id)) {
	        repo.deleteById(id);
	    } else {
	        throw new ResourceNotFoundException("Employee not found with ID: " + id);
	    }
	}

	@Override
	public EmployeeDTO get(Integer id) {
	    Employee employee = repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

	    return mapper.map(employee, EmployeeDTO.class);
	}


}
