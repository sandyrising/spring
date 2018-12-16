package com.spring.practice.validation;

public class EmployeeValidation {

	/**
	 * This method return true if the text is empty
	 * 			   returns false if the text is not empty
	 * @param text
	 * @return
	 */
	public boolean isTextEmpty(String text) {
		if(text == null || text.isEmpty())
			return true;
		
		return false;
	}
}
