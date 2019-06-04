package com.practice.dao;

import java.util.List;

import com.practice.domain.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
}
