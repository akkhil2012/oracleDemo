package com.user.mgmt.management_project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.mgmt.management_project.services.UserService;

@Controller
@ComponentScan("com.user.*")
public class UserController {
	
	//@Autowired
	//private UserService  userService;
	/*
	 * Yet to implement service to Repository  call
	 */
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String registerUser(){
		System.out.println("Before calling the Registration Service..........................");
		//model.addAttribute("message","Akkhil"); 
		return "RegistrationForm";
		//return new ModelAndView("RegistrationForm");
		
	}
	

}
