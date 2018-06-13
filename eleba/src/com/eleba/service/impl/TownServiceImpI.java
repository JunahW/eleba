package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.TownMapper;
import com.eleba.pojo.Town;
import com.eleba.pojo.TownExample;
import com.eleba.service.TownService;
@Service
public class TownServiceImpI implements TownService{

	@Autowired
	private TownMapper provinceMapper;
	
	@Override
	public List<Town> selectTown() {
		return  provinceMapper.selectByExample(new TownExample());
	}

	
	
}
