package com.practice.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.practice.domain.Employee;

public class EmployeeDaoJavaImplTest {

	private EmployeeDaoJavaImpl employeeDaoJavaImpl = new EmployeeDaoJavaImpl();
	private Employee employee = new Employee(2, "Kumar", "kumar@gmail.com", 200.0);
	private Integer id = 2;
	
	
	@Test
	public void getEmployeeByIdTest() {
		Employee emp = employeeDaoJavaImpl.getEmployeeById(id);
		assertEquals("Kumar", emp.getName());
	}

	@Test
	public void getAllEmployeesTest(){
		List<Employee> emps = employeeDaoJavaImpl.getAllEmployees();
		assertEquals(3, emps.size());
	}

	@Test
	public void saveEmployeeTest() {
		employeeDaoJavaImpl.saveEmployee(employee);
	}
	
	@Test
	public void updateEmployeeTest() {
		employeeDaoJavaImpl.updateEmployee(employee);
	}

	@Test
	public void deleteEmployeeTest() {
		employeeDaoJavaImpl.deleteEmployee(id);
	}

}
