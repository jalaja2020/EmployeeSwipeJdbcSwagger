package com.hcl.dao;

import java.util.List;

import com.hcl.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	List<Employee> getEmployeeById(String empId);
	List<Employee> getEmployeeByLocation(String location);
	List<Employee> getEmployeeByDate(String dob);
}
