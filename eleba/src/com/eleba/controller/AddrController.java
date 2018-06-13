package com.eleba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleba.pojo.Addr;
import com.eleba.service.AddrService;
@Controller
@RequestMapping(value="/addr")
public class AddrController {

	@Autowired
	private AddrService addrService;
	
	@RequestMapping(value="/add")
	public String addAddr(Addr addr){
		
		addrService.addAddr(addr);
		return "/addr/login";
	}
	
	@RequestMapping(value="/find")
	@ResponseBody
	public List<Addr> selectAddr(Addr addr){
		
		List<Addr> addrs = addrService.selectAddr();
		
		return addrs;
	}
	
	@RequestMapping(value="/delete")
	public String deleteAddr(Addr addr){
		addrService.deleteAddr(addr);
		return "/addr/login";
	}
	
	@RequestMapping(value="/update")
	public String updateAddr(Addr addr){
		addrService.updateAddr(addr);
		return "/addr/login";
	}
	
}
