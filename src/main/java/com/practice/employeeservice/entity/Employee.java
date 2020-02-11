package com.practice.employeeservice.entity;

public class Employee {
	
	int employeeId;
	String employeeName;
	String place;
	double salary;
	
	
	public Employee(int employeeId, String employeeName, String place, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.place = place;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", place=" + place
				+ ", salary=" + salary + "]";
	}
	
	

}
