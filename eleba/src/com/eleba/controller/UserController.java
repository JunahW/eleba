package com.eleba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.User;
import com.eleba.service.UserService;

/**
 * 这是普通用户管理模块
 * @author sunwei
 *
 */
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	//@Value("${}")
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String register(User user){
		
		userService.addUser(user);
		
		return "/user/login";
	}
	
	@RequestMapping(value="/login")
	public String selectUser(User user){
		
		List<User> selectUsers = userService.selectUser(user);

		return "/user/login";
		
	}
	
	@RequestMapping(value="/login")
	public String deleteUser(User user){
		userService.deleteUser(user);
		return "/user/login";
		
	}
	
	@RequestMapping(value="/login")
	public String updateUser(User user){
		userService.updateUser(user);
		return "/user/login";
		
	}


}
