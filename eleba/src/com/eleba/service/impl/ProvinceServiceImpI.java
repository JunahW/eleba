package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.ProvinceMapper;
import com.eleba.pojo.Province;
import com.eleba.pojo.ProvinceExample;
import com.eleba.service.ProvinceService;
@Service
public class ProvinceServiceImpI implements ProvinceService{

	@Autowired
	private ProvinceMapper provinceMapper;
	
	@Override
	public List<Province> selectProvince() {
		return  provinceMapper.selectByExample(new ProvinceExample());
	}

	
	
}
