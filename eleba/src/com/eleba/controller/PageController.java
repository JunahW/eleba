package com.eleba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	

	@RequestMapping(value="/index")
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping(value="/left")
	public String left(){
		return "admin/left";
	}
	
	@RequestMapping(value="/bottom")
	public String bottom(){
		return "admin/bottom";
	}
	
	@RequestMapping(value="/home")
	public String home(){
		return "admin/home";
	}
	
	@RequestMapping(value="/top")
	public String top(){
		return "admin/top";
	}
	
	@RequestMapping(value="/welcome")
	public String welcome(){
		return "admin/welcome";
	}
	
	@RequestMapping(value="/product_list")
	public String Product_list(){
		return "admin/product/list";
	}
	
	@RequestMapping(value="/order_list")
	public String Order_list(){
		return "admin/order/list";
	}
	
	@RequestMapping(value="/addProduct")
	public String adminProduct_addPage(){
		return "admin/product/add";
	}

	
}
