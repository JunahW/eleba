package com.eleba.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Business;
import com.eleba.pojo.User;
import com.eleba.service.AdminBusinessService;
import com.eleba.service.AdminUserService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;

@RequestMapping(value = "/admin/business")
@Controller
public class AdminBusinessController {

	@Autowired
	private AdminBusinessService adminBusinessService;

	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private SessionProvider sessionProvider;

	@RequestMapping(value = "/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Business business = (Business) sessionProvider.getAttribute(request, response, Constants.SHOP_SESSION);
		User boss = adminUserService.selectUserByUid(business.getBossid());

		model.addAttribute("boss", boss);
		model.addAttribute("business", business);

		return "admin/business/detail";

	}

}
