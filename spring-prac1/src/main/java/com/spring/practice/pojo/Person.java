package com.spring.practice.pojo;

import java.util.ArrayList;
import java.util.List;

public class Person {

	Person() {
		System.out.println("Object created for Person");
	}
	private String name;
	private List<String> cities;
	private String college;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void populateCities() {
		List<String> cities = new ArrayList<>();
		cities.add("Kolkata");
		cities.add("Delhi");
		cities.add("Bhubaneshwar");
		this.setCities(cities);
		System.out.println("init method triggered");
	}
	
	public void cleanUpObjects() {
		this.cities = null;
		System.out.println("destroy method triggered");
	}
}
