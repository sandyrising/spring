package com.spring.practice.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.practice.dao.IEmployeeDao;
import com.spring.practice.pojo.Employee;
import com.spring.practice.pojo.Passport;
import com.spring.practice.pojo.User;
import com.spring.practice.service.EmployeeService;
import com.spring.practice.validation.EmployeeValidation;

@Controller
public class EmployeeController {

	public EmployeeController() {
		System.out.println("employee controller object created!!");
	}
	static SessionFactory sf;
	
	@Autowired
	Employee e1;
//	EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	@Autowired
	IEmployeeDao empDao;

	@Autowired
	EmployeeService empService;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}

	@RequestMapping(value = "/loginUser")
	public String loginEmployee(Model m, @RequestParam("mail") String email, @RequestParam("pwd") String pword) {

		String result = empService.loginEmployee(m, email, pword);
		return result;
	}
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerEmployee(Model model, Employee employee) {

		System.out.println("preparing pojo object");

		//Validation logic starts here
		EmployeeValidation validation = new EmployeeValidation();
		
		boolean result = validation.isTextEmpty(employee.getName());
		if(result) {
			model.addAttribute("message", "Name should not be empty!!");
			model.addAttribute("emp", employee);
			return "Register";
		}
		
		result = validation.isTextEmpty(employee.getMail());
		if(result) {
			model.addAttribute("message", "Mail id should not be empty!!");
			model.addAttribute("emp", employee);
			return "Register";
		}
		result = validation.isTextEmpty(employee.getMbl());
		if(result) {
			model.addAttribute("message", "Mobile number should not be empty!!");
			model.addAttribute("emp", employee);
			return "Register";
		}
		result = validation.isTextEmpty(employee.getPwd());
		if(result) {
			model.addAttribute("message", "Password should not be empty!!");
			model.addAttribute("emp", employee);
			return "Register";
		}
		//Validation logic ends here
		
		
		// Database logic using hibernate mappings
		try {
			empDao.registerEmployee(employee);
		} catch (ConstraintViolationException e) {
			model.addAttribute("message", "Already registered with this mail id. Please try with other mail id!!");
			return "Register";
		} catch (Exception e) {
			model.addAttribute("message", "Please try after sometime!! Something went wrong!!");
			return "Register";
		}

		System.out.println("EmployeeController :: registerEmployee() method!!");

		return "login";
	}

	@RequestMapping(value="/test")
	public String testCon() {
		
		return "";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteEmployee(Model model, @RequestParam("mailId") String email) {
		System.out.println("Entered into deleteEmployee method :: EmployeeController");
		System.out.println(email);
		// database to delete record
		Session session = sf.openSession();
		Query query = session.createQuery("delete from Employee where mail=?");
		query.setString(0, email);
		query.executeUpdate();

		// get all records from database and set to empList in model object

		Query fetchQuery = session.createQuery("from Employee");

		List<Employee> list = fetchQuery.list();
		model.addAttribute("empList", list);

		session.beginTransaction().commit();
		session.close();

		return "details";
	}

	@RequestMapping(value = "/openInEditView", method = RequestMethod.POST)
	public String openEditView(Model model, @RequestParam("mailId") String email) {
		System.out.println(email);
		Session session = sf.openSession();
		Query fetchQuery = session.createQuery("from Employee where mail=?");
		fetchQuery.setString(0, email);

		List<Employee> list = fetchQuery.list();
		model.addAttribute("empl", list.get(0));

		session.beginTransaction().commit();
		session.close();

		return "editView";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(Model model, Employee emp) {
		Session session = sf.openSession();
		// update databasse request triggering
		session.update(emp);

		// get employee list form database..
		Query fetchQuery = session.createQuery("from Employee");
		List<Employee> employeeList = fetchQuery.list();
		// get employee list form database ends here

		// setting employee llist into model object
		model.addAttribute("empList", employeeList);

		session.beginTransaction().commit();
		session.close();
		return "details";
	}
	
	@RequestMapping(value="/goToLoginPage")
	public String gotToLoginPage() {
		
		System.out.println("executing gotToLoginPage......");
		return "login";
	}
	
	@RequestMapping(value="/home")
	public String goToHome() {
		
		System.out.println("executing goToHome page");
		return "profile";
	}
	
	@RequestMapping(value="/goToFailure")
	public String goToFail(Model model) {
		model.addAttribute("message", "Invalid Credentials!! Please try with valid credentials provided in authentication manager");
		System.out.println("Failure page");
		return "login";
	}
}
