package com.practice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.practice.domain.Employee;
import com.practice.service.EmployeeService;

public class EmployeeControllerTest {
	
	private EmployeeService employeeService;
	private EmployeeController employeeController;
	private Employee employee;
	private Integer id = 1;
	
	@Before
	public void setUp() {
		employeeService = mock(EmployeeService.class);
		employeeController = new EmployeeController(employeeService);
		employee = new Employee(1, "Amlan", "amlan@gmail.com", 100D);
	}
	
	@Test
	public void getEmployeeByIdTest() {
		when(employeeService.getEmployeeById(id)).thenReturn(employee);
		Employee emp = employeeController.getEmployeeById(id);
		verify(employeeService).getEmployeeById(id);
		assertEquals("Amlan", emp.getName());
	}

	@Test
	public void getAllEmployeesTest(){
		List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		when(employeeService.getAllEmployees()).thenReturn(employees);
		List<Employee> emps = employeeController.getAllEmployees();
		verify(employeeService).getAllEmployees();
		assertEquals("amlan@gmail.com", emps.get(0).getEmailId());
	}

	@Test
	public void saveEmployeeTest() {
		doNothing().when(employeeService).saveEmployee(employee);
		employeeController.saveEmployee(employee);
		verify(employeeService, times(1)).saveEmployee(employee);
	}
	
	@Test
	public void updateEmployeeTest() {
		doNothing().when(employeeService).updateEmployee(employee);
		employeeController.updateEmployee(employee);
		verify(employeeService).updateEmployee(employee);
	}

	@Test
	public void deleteEmployeeTest() {
		doNothing().when(employeeService).deleteEmployee(id);
		employeeController.deleteEmployee(id);
		verify(employeeService).deleteEmployee(id);
	}
}
