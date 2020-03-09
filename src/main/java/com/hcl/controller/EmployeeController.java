package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.exceptions.EmployeeNotFoundExcepetion;
import com.hcl.model.Employee;
import com.hcl.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl empService;

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public void getAllEmployees(Model model)
	{
		List<Employee> employees = empService.getAllEmployees();
		if(employees.isEmpty()) {
			throw new EmployeeNotFoundExcepetion();
		}
		 
	}

	@RequestMapping(value = "/getAllEmployees/admin/{id}", method = RequestMethod.GET)
	public List<Employee> getAdminEmployeeById(@RequestParam String id)
	{
		List<Employee> employeeById = empService.getEmployeeById(id);
		if(employeeById.isEmpty())
			throw new EmployeeNotFoundExcepetion(Integer.parseInt(id));
		else
		return empService.getEmployeeById(id);
	}


	@RequestMapping(value = "/getAllEmployees/admin/location/{location}", method= RequestMethod.GET) 
	public List<Employee> getUserEmployeeByLocation(@RequestParam String location) { return
			empService.getEmployeeByLocation(location); }

	@RequestMapping(value = "/getAllEmployees/admin/date/{date}", method =RequestMethod.GET)
	public List<Employee> getUserEmployeeByDate(@RequestParam
					String date) { return empService.getEmployeeByDate(date); }

}
