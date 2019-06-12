package com.practice.domain;

/**
 * This is a domain class to represent Employee table in Database
 */

public class Employee {
	private Integer id;
	private String name;
	private String emailId;
	private Double salary;

	public Employee() {
	}

	public Employee(Integer id, String name, String emailId, Double salary) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
