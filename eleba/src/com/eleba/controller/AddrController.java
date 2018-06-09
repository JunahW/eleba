package com.eleba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Addr;
import com.eleba.service.AddrService;

public class AddrController {

	@Autowired
	private AddrService addrService;
	
	@RequestMapping(value="/login")
	public String addAddr(Addr addr){
		
		addrService.addAddr(addr);
		return "/addr/login";
	}
	
	@RequestMapping(value="/login")
	public String selectAddr(Addr addr){
		
		List<Addr> selectAddrs = addrService.selectAddr();
		
		return "/addr/login";
	}
	
	@RequestMapping(value="/login")
	public String deleteAddr(Addr addr){
		addrService.deleteAddr(addr);
		return "/addr/login";
	}
	
	@RequestMapping(value="/login")
	public String updateAddr(Addr addr){
		addrService.updateAddr(addr);
		return "/addr/login";
	}
	
}
