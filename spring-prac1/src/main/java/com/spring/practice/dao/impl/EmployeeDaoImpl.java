package com.spring.practice.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.practice.dao.IEmployeeDao;
import com.spring.practice.pojo.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public void registerEmployee(Employee e) {
		System.out.println("entered into registerEmployee method from EmployeeDaoImpl");
		Session session = sf.openSession();
		session.save(e);
		session.beginTransaction().commit();
		session.close();
		System.out.println("exit from loginEmployee method from EmployeeDaoImpl");
	}
	
	public List<Employee> loginEmployee(String mail, String password) {
		System.out.println("entered into loginEmployee method from EmployeeDaoImpl");
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee where mail = ? AND pwd = ?");

		query.setString(0, mail);
		query.setString(1, password);

		List<Employee> list = query.list();
		System.out.println("exist from loginEmployee method from EmployeeDaoImpl");
		return list;
	}
}
