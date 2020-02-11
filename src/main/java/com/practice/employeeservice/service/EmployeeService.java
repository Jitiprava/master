package com.practice.employeeservice.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practice.employeeservice.entity.Employee;
import com.practice.employeeservice.util.ReadCSV;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);
	
	public EmployeeService(){}
	
	@Autowired
	private ReadCSV readCsv;
	
	private List<Employee> empList;
	
	@PostConstruct
	@Cacheable("employeeList")
	public void init(){
		empList = readCsv.parseCSV("classpath:config/EmployeeData.csv");
	}
	
	public List<Employee> updateList(String place, String percentage){
		empList.stream().filter(e->e.getPlace().equals("Bbsr")).forEach(e->e.setSalary(e.getSalary()*(1+(Double.valueOf(percentage))/100)));
		LOGGER.info("updated employee list", empList);
        return empList;
	}
	
	public List<Employee> getList(){
        return empList;
	}

}
