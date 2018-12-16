package com.spring.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.spring.practice.dao.IEmployeeDao;
import com.spring.practice.pojo.Employee;
import com.spring.practice.validation.EmployeeValidation;

public class EmployeeService {
	
	public EmployeeService() {
		System.out.println("employee service object created!!");
	}
//	EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	@Autowired
	IEmployeeDao empDao;
	
	@Autowired
//	@Qualifier("empSingle")
	Employee e1;

	@Autowired
//	@Qualifier("empSingle")
	Employee e2;

	@Autowired
//	@Qualifier("empDouble")
	Employee e3;

	Employee e4 = new Employee("Rohit");

	public String loginEmployee(Model m, String email, String pword) {
		
		System.out.println("------------------------------m--ioc testing here---------------------------");
		System.out.println(e1.getName() + "-" + e1.getCity() + "-" + e1.getComp() + "-" + e1.getSal() + "-" + e1.getPport().getPptId() +"-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getCity() + "-" + e2.getComp() + "-" + e2.getSal() + "-" + e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getCity() + "-" + e3.getComp() + "-" + e3.getSal() + "-" + e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
		System.out.println(e4);
		e1.setName("Raju");
		e1.setCity("Hyderabad");
		e1.setSal("50000");
		e1.getPport().setPptId(1234);
		e1.getPport().setIssueCity("Hyd");
		
		e3.setName("Lokesh");
		
		
		System.out.println("---------------");
		System.out.println(e1.getName() + "-" + e1.getCity() + "-" + e1.getComp() + "-" + e1.getSal() + "-" + e1.getPport().getPptId() +"-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getCity() + "-" + e2.getComp() + "-" + e2.getSal() + "-" + e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getCity() + "-" + e3.getComp() + "-" + e3.getSal() + "-" + e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
		System.out.println("---------------");
		
		e1.setName("Ravi Teja");

		e2.setName("Virat");
		e2.setCity("Banglore");
		e2.setSal("5000000");
		e2.getPport().setPptId(4578);
		e2.getPport().setIssueCity("Bang");
		
		
		System.out.println(e1.getName() + "-" + e1.getCity() + "-" + e1.getComp() + "-" + e1.getSal() + "-" + e1.getPport().getPptId() +"-" + e1.getPport().getIssueCity());
		System.out.println(e2.getName() + "-" + e2.getCity() + "-" + e2.getComp() + "-" + e2.getSal() + "-" + e2.getPport().getPptId() + "-" + e2.getPport().getIssueCity());
		System.out.println(e3.getName() + "-" + e3.getCity() + "-" + e3.getComp() + "-" + e3.getSal() + "-" + e3.getPport().getPptId() + "-" + e3.getPport().getIssueCity());
		System.out.println("-------------------------------ioc testing here---------------------------------");
		System.out.println("User name is : " + email);
		System.out.println("Password is : " + pword);

		EmployeeValidation validation = new EmployeeValidation();
		boolean result = validation.isTextEmpty(email);
		if(result) {
			m.addAttribute("message", "Mail should not be empty!!");
		}
		result = validation.isTextEmpty(pword);
		if(result) {
			m.addAttribute("message", "Password should not be empty!!");
		}
		// database logic starts here!!
		
		List<Employee> list = empDao.loginEmployee(email, pword);

		if (list.isEmpty()) {
			System.out.println("list is empty!! So, entered invalid credential!!");
			m.addAttribute("message", "Entered Invalid Credentials!! Please try again!!");
			return "login";
		} else {
			System.out.println("Entered valid credentials!!");
			m.addAttribute("userName", list.get(0).getName());
			return "profile";
		}
		// database logic ends here!!
	}
}
