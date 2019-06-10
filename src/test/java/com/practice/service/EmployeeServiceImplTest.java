package com.practice.service;

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

import com.practice.dao.EmployeeDao;
import com.practice.domain.Employee;

public class EmployeeServiceImplTest {

	private EmployeeDao employeeDao;
	
	private EmployeeServiceImpl employeeServiceImpl;
	
	private Employee employee;
	private Integer id = 1;
	
	@Before
	public void setUp() {
		employeeDao = mock(EmployeeDao.class);
		employeeServiceImpl = new EmployeeServiceImpl(employeeDao);
		employee = new Employee(1, "Amlan", "amlan@gmail.com", 100D);
	}
	
	@Test
	public void givenIdThenReturnTheEmployeeDetails() {
		when(employeeDao.getEmployeeById(id)).thenReturn(employee);
		Employee employee = employeeServiceImpl.getEmployeeById(id);
		verify(employeeDao).getEmployeeById(id);
		assertEquals(new Double(100), employee.getSalary());
	}
	
	@Test
	public void getAllTheEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		when(employeeDao.getAllEmployees()).thenReturn(employees);
		List<Employee> emps = employeeServiceImpl.getAllEmployees();
		verify(employeeDao).getAllEmployees();
		assertEquals(1, emps.size());
	}
	
	@Test
	public void givenEmployeeDetailsItShouldPersist() {
		doNothing().when(employeeDao).saveEmployee(employee);
		employeeServiceImpl.saveEmployee(employee);
		verify(employeeDao, times(1)).saveEmployee(employee);
	}
	
	@Test
	public void givenUpdatedDetailsThenPersisttheChanges() {
		doNothing().when(employeeDao).updateEmployee(employee);
		employeeServiceImpl.updateEmployee(employee);
		verify(employeeDao).updateEmployee(employee);
	}
	
	@Test
	public void givenIdThenDeleteTheEmployeeWithGivenId() {
		doNothing().when(employeeDao).deleteEmployee(id);
		employeeServiceImpl.deleteEmployee(id);
		verify(employeeDao).deleteEmployee(id);
	}
	
}
