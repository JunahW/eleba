package com.eleba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Town;
import com.eleba.service.TownService;

@RequestMapping(value = "/town")
@Controller
public class TownController {

	@Autowired
	private TownService townService;

	@RequestMapping(value = "/find")
	public String selectProvince(Town province) {

		List<Town> selectUsers = townService.selectTown();

		return "/user/login";

	}

}
