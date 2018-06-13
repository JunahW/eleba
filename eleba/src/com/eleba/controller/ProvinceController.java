package com.eleba.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Province;
import com.eleba.service.ProvinceService;

@Controller
@RequestMapping(value="/province")
public class ProvinceController {

	private ProvinceService provinceService;
	
	@RequestMapping(value="/find")
	public String selectProvince(Province province){
		
		List<Province> selectUsers = provinceService.selectProvince();

		return "/user/login";
		
	}
	
}
