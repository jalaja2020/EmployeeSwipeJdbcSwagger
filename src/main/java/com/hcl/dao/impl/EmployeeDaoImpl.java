package com.hcl.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcl.dao.EmployeeDao;
import com.hcl.model.Employee;
@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
	Logger logger=LoggerFactory.getLogger(EmployeeDaoImpl.class);
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employeeswipe";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			emp.setLocationName((String)row.get("locationName"));
			emp.setSwipeIn((String)row.get("swipeIn"));
			emp.setSwipeIn((String)row.get("swipeOut"));
			emp.setCreateDate((Date)row.get("createDate"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public List<Employee> getEmployeeById(String empId) {
		
		  String sql = "SELECT * FROM employeeswipe WHERE empId = :empId"; 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
	      parameters.addValue("empId", empId);
		  List<Map<String,Object>> queryForList = getJdbcTemplate().queryForList(sql,parameters); 
		  List<Employee> result = new ArrayList<Employee>(); 
		  for(Map<String, Object>row:queryForList){ Employee emp = new Employee();
		  emp.setEmpId((String)row.get("empId"));
		  emp.setEmpName((String)row.get("empName"));
		  emp.setLocationName((String)row.get("locationName"));
		  emp.setSwipeIn((String)row.get("swipeIn"));
		  emp.setSwipeIn((String)row.get("swipeOut"));
		  emp.setCreateDate((Date)row.get("createDate")); result.add(emp); }
		  return result;
		
	}

	@Override
	public List<Employee> getEmployeeByLocation(String location) {
		String sql = "SELECT * FROM employeeswipe WHERE locationName = :location";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	      parameters.addValue("location", location);
		List<Map<String, Object>> queryForList = getJdbcTemplate().queryForList(sql,parameters);
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:queryForList){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			emp.setLocationName((String)row.get("locationName"));
			emp.setSwipeIn((String)row.get("swipeIn"));
			emp.setSwipeIn((String)row.get("swipeOut"));
			emp.setCreateDate((Date)row.get("createDate"));
			result.add(emp);
		}
		return result;
	}


	@Override
	public List<Employee> getEmployeeByDate(String dob) {
		String sql = "SELECT * FROM employeeswipe WHERE createDate = :createDate";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	      parameters.addValue("createDate", dob);
		List<Map<String, Object>> queryForList = getJdbcTemplate().queryForList(sql);
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:queryForList){
			Employee emp = new Employee();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			emp.setLocationName((String)row.get("locationName"));
			emp.setSwipeIn((String)row.get("swipeIn"));
			emp.setSwipeIn((String)row.get("swipeOut"));
			emp.setCreateDate((Date)row.get("createDate"));
			result.add(emp);
		}
		return result;
	}
	

}
