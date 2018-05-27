package com.eleba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value="/user")
@Controller
public class UserController {
	
	
	@RequestMapping(value="/add")
	public void addUser() {
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "admin/index";
	}
	
	@Value("${img.server}")
	private String imgServer;
	
	@RequestMapping(value="/test")
	public void test() {
		System.out.println(imgServer);
		
	}

}
