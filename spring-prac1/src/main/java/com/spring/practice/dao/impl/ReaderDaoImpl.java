package com.spring.practice.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.practice.pojo.Employee;

public class ReaderDaoImpl {

	static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public List<Employee> getEmployees() {
		System.out.println("Entered into ReaderDaoImpl");
		Session session = sf.openSession();
		Query query = session.createQuery("from Employee");

		List<Employee> list = query.list();
		System.out.println("Exit from ReaderDaoImpl");
		return list;
	}
}
