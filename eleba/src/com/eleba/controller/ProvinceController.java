package com.eleba.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Province;
import com.eleba.service.ProvinceService;


public class ProvinceController {

	private ProvinceService provinceService;
	
	@RequestMapping(value="/login")
	public String selectProvince(Province province){
		
		List<Province> selectUsers = provinceService.selectProvince();

		return "/user/login";
		
	}
	
}
