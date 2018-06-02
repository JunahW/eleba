package com.eleba.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Town;
import com.eleba.service.TownService;

public class TownController {

private TownService townService;
	
	@RequestMapping(value="/login")
	public String selectProvince(Town province){
		
		List<Town> selectUsers = townService.selectTown();

		return "/user/login";
		
	}
	
}
