package com.eleba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add")
	public void addUser() {
		userService.addUser();
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "admin/index";
	}

}
