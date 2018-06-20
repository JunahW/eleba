package com.eleba.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleba.pojo.Addr;
import com.eleba.pojo.User;
import com.eleba.service.AddrService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;

@Controller
@RequestMapping(value = "/buyer/addr")
public class AddrController {

	@Autowired
	private AddrService addrService;
	@Autowired
	private SessionProvider sessionProvider;

	@RequestMapping(value = "/add")
	public String addAddr(Addr addr) {

		addrService.addAddr(addr);
		return "/addr/login";
	}

	@RequestMapping(value = "/delete")
	public String deleteAddr(Addr addr) {
		addrService.deleteAddr(addr);
		return "/addr/login";
	}

	@RequestMapping(value = "/update")
	public String updateAddr(Addr addr) {
		addrService.updateAddr(addr);
		return "/addr/login";
	}

	@ResponseBody
	@RequestMapping(value = "/list")
	public List<Addr> list(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("111111111111111111");
		User user = (User) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
		List<Addr> addrs = addrService.selectAddr(user);
		return addrs;
	}

}
