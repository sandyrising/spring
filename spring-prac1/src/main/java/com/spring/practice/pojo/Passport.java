package com.spring.practice.pojo;

public class Passport {

	public Passport() {
		System.out.println("passport created!!");
	}
	private int pptId;
	private String issueCity;

	public int getPptId() {
		return pptId;
	}

	public void setPptId(int pptId) {
		this.pptId = pptId;
	}

	public String getIssueCity() {
		return issueCity;
	}

	public void setIssueCity(String issueCity) {
		this.issueCity = issueCity;
	}
}
