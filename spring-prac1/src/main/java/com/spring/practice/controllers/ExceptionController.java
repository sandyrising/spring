package com.spring.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping(value="/accessDenied")
	public String errorPage(Model model) {
		model.addAttribute("message", "You dont have permisson to access this page!!");
		return "error";
	}
}
