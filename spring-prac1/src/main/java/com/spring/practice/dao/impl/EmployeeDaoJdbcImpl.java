package com.spring.practice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.practice.dao.IEmployeeDao;
import com.spring.practice.pojo.Employee;

public class EmployeeDaoJdbcImpl implements IEmployeeDao {

	public EmployeeDaoJdbcImpl() {
		System.out.println("EmployeeDaoJdbc object created!!");
	}
	public void registerEmployee(Employee e) {
		System.out.println("entered into registerEmployee from EmployeeDaoJdbcImpl");
		System.out.println("------------Jdbc logic comes here---------------TODO");
		System.out.println("exit from registerEmployee from EmployeeDaoJdbcImpl");
	}

	public List<Employee> loginEmployee(String email, String pword) {
		System.out.println("entered into login from EmployeeDaoJdbcImpl");
		System.out.println("------------Jdbc logic comes here---------------TODO");
		System.out.println("exit from login from EmployeeDaoJdbcImpl");
		return new ArrayList<Employee>();
	}
}
