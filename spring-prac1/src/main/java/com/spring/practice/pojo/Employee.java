package com.spring.practice.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="employee")
public class Employee {

	private String name;
	private String mbl;
	@Id
	private String mail;
	private String pwd;
	private String city;
	
	private String sal;
	private String comp;
	private String role="USER";
	
/*	@Autowired
	private Passport pport;*/
	
	public Employee() {
		System.out.println("default no arg constructor from employee");
	}
	
	/*public Employee(Passport p) {
		this.pport = p;
		System.out.println("injected passport object!!");
	}*/
	
	public Employee(String name) {
		System.out.println("Name came from constructor injection " + name);
		System.out.println("Employee Object createed!!");
	}
	
	public Employee(String name, String sal) {
		System.out.println("Name and sal " + name + "-" + sal);
		System.out.println("Employee objcet by 2 string arg constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMbl() {
		return mbl;
	}

	public void setMbl(String mbl) {
		this.mbl = mbl;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public Passport getPport() {
		return pport;
	}

	public void setPport(Passport pport) {
		this.pport = pport;
	}*/
	

}
