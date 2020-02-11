package com.practice.employeeservice.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.practice.employeeservice.entity.Employee;

@Component
public class ReadCSV {
	
	private static final Logger LOGGER = LogManager.getLogger(ReadCSV.class);

	public List<Employee> parseCSV(String filenmae) {
		
		List<Employee> empList = new ArrayList<>();
		try {
			File file = ResourceUtils.getFile(filenmae);

			LOGGER.info("File Found : " + file.exists());

			FileReader filereader = new FileReader(file); 
			  
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	        
	        for(String[] data : allData){
	        	Employee emp = new Employee(Integer.valueOf(data[0]),data[1],data[2],Double.valueOf(data[3]));	        	
	        	empList.add(emp);
	        }
	        LOGGER.info("Initial employee list", empList);
		} catch (IOException e) {
			LOGGER.error("Exception occurred while parsing CSV");
		}
		return empList;

	}

}
