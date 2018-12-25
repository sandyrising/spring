package com.spring.practice.dao;

import java.util.List;

import com.spring.practice.pojo.Employee;

public interface IEmployeeDao {

	public void registerEmployee(Employee e);

	public List<Employee> loginEmployee(String mail, String password);
	
	public Employee getEmployeeByUserName(String userName);
}
