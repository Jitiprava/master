package com.practice.employeeservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employeeservice.entity.Employee;
import com.practice.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService empService;
	
	@CachePut(value = "employeeList")
	@PutMapping("/employee/place/{place}/salary/{percentage}")
	public List<Employee> updateEmployeeList(@PathVariable String place, @PathVariable String percentage) {
		
		List<Employee> empList = empService.updateList(place, percentage);
		LOGGER.info("updated employee list+++++", empList);
		return empList;
		
	}
	
	@Cacheable(value = "employeeList")
	@GetMapping("/employee")
	public List<Employee> getEmployeeList() {
		
		List<Employee> empList = empService.getList();
		LOGGER.info("get employee list", empList);
		return empList;
		
	}

}
