package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practice.dao.EmployeeDao;
import com.practice.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("EmployeeDao") EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeDao.deleteEmployee(id);
	}

}
