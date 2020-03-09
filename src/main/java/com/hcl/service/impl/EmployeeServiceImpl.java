package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.EmployeeDao;
import com.hcl.model.Employee;
@Service
public class EmployeeServiceImpl {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
		return employees; 
	}

	public List<Employee> getEmployeeById(String empid) {
		List<Employee> employee = employeeDao.getEmployeeById(empid);
		System.out.println(employee);
		return employee;
	}

	public List<Employee> getEmployeeByLocation(String location) {
		List<Employee> employee = employeeDao.getEmployeeById(location);
		System.out.println(employee);
		return employee;
	}


	public List<Employee> getEmployeeByDate(String dob) {
		List<Employee> employee = employeeDao.getEmployeeById(dob);
		System.out.println(employee);
		return null;
	}
	



}
