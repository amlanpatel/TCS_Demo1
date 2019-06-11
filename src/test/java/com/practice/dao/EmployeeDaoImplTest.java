package com.practice.dao;

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
import com.practice.mapper.EmployeeMapper;

public class EmployeeDaoImplTest {

	private EmployeeMapper employeeMapper;
	private EmployeeDaoImpl employeeDaoImpl;
	private Employee employee;
	private Integer id = 1;
	
	@Before
	public void setUp() {
		employeeMapper = mock(EmployeeMapper.class);
		employeeDaoImpl = new EmployeeDaoImpl(employeeMapper);
		employee = new Employee(1, "Amlan Patel", "amlan.patel@gmail.com", 100D);
	}
	
	@Test
	public void getEmployeeByIdTest() {
		when(employeeMapper.getEmployeeById(id)).thenReturn(employee);
		Employee emp = employeeDaoImpl.getEmployeeById(id);
		verify(employeeMapper).getEmployeeById(id);
		assertEquals("Amlan Patel", emp.getName());
	}

	@Test
	public void getAllEmployeesTest(){
		List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		when(employeeMapper.getAllEmployees()).thenReturn(employees);
		List<Employee> emps = employeeDaoImpl.getAllEmployees();
		verify(employeeMapper).getAllEmployees();
		assertEquals("amlan.patel@gmail.com", emps.get(0).getEmailId());
	}

	@Test
	public void saveEmployeeTest() {
		doNothing().when(employeeMapper).insertEmployee(employee);
		employeeDaoImpl.saveEmployee(employee);
		verify(employeeMapper, times(1)).insertEmployee(employee);
	}
	
	@Test
	public void updateEmployeeTest() {
		doNothing().when(employeeMapper).updateEmployee(employee);
		employeeDaoImpl.updateEmployee(employee);
		verify(employeeMapper).updateEmployee(employee);
	}

	@Test
	public void deleteEmployeeTest() {
		doNothing().when(employeeMapper).deleteEmployee(id);
		employeeDaoImpl.deleteEmployee(id);
		verify(employeeMapper).deleteEmployee(id);
	}

}
