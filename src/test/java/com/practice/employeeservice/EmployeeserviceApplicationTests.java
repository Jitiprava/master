package com.practice.employeeservice;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.employeeservice.controller.EmployeeController;
import com.practice.employeeservice.entity.Employee;
import com.practice.employeeservice.service.EmployeeService;
import com.practice.employeeservice.util.ReadCSV;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeserviceApplicationTests {
	
	@Mock
	private EmployeeService empService;
	
	@Mock
	private EmployeeController empController;
	
	@Mock
	private ReadCSV readCsv;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testGetEmployeeListSuccess() throws Exception 
	{
		Employee emp = new Employee(1,"Jiti","Bbsr",10000);
		Employee emp1 = new Employee(2,"Swati","Kolkata",20000);
		List<Employee> list = new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		
		when(empController.getEmployeeList()).thenReturn(list);
		List<Employee> empList = empController.getEmployeeList();
        
        assertEquals(2, empList.size());
	    
	}
	
	@Test
	public void testUpdateEmployeeListSuccess() throws Exception 
	{
		Employee emp = new Employee(1,"Jiti","Bbsr",12500);
		Employee emp1 = new Employee(2,"Swati","Kolkata",20000);
		List<Employee> list = new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		
		when(empController.updateEmployeeList("Bbsr", "25")).thenReturn(list);
		List<Employee> empList = empController.updateEmployeeList("Bbsr", "25");
        
        assertEquals(12500.0, empList.get(0).getSalary(), 0.00);
	    
	}
	
	@Test
	public void initTest(){
		Employee emp = new Employee(1,"Jiti","Bbsr",10000);
		Employee emp1 = new Employee(2,"Swati","Kolkata",20000);
		List<Employee> list = new ArrayList<>();
		list.add(emp);
		list.add(emp1);
		lenient().when(readCsv.parseCSV("file")).thenReturn(list);
	}

}
