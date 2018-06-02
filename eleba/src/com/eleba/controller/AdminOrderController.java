package com.eleba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/order")
public class AdminOrderController {
	
	@RequestMapping(value="list")
	public String listOrder() {
		return "/admin/order/list";
	}

}
