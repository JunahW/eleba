package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.BusinessMapper;
import com.eleba.pojo.Business;
import com.eleba.pojo.BusinessExample;
import com.eleba.pojo.BusinessExample.Criteria;
import com.eleba.service.AdminBusinessService;

@Service
public class AdminBusinessServiceImpl implements AdminBusinessService {

	@Autowired
	private BusinessMapper businessMapper;

	@Override
	public List<Business> selectBusiness(Business business) {
		BusinessExample example = new BusinessExample();
		Criteria criteria = example.createCriteria();
		if (null != business.getName() && !"".equals(business.getName().trim())) {
			criteria.andNameLike("%" + business.getName() + "%");
		}
		if (null != business.getState()) {
			criteria.andStateEqualTo(business.getState());
		}
		return businessMapper.selectByExample(example);
	}

	@Override
	public int updateBusiness2Freeze(String bid) {
		Business business = new Business();
		business.setBid(bid);
		business.setState((byte) 0);
		return businessMapper.updateByPrimaryKeySelective(business);
	}

	@Override
	public int updateBusiness2Active(String bid) {
		Business business = new Business();
		business.setBid(bid);
		business.setState((byte) 1);
		return businessMapper.updateByPrimaryKeySelective(business);
	}

	@Override
	public int getTotalCountByBusiness(Business business) {
		BusinessExample example = new BusinessExample();
		Criteria criteria = example.createCriteria();
		if (null != business.getName() && !"".equals(business.getName().trim())) {
			criteria.andNameLike("%" + business.getName() + "%");
		}
		if (null != business.getState() && 2 == business.getState()) {
			criteria.andStateEqualTo((byte) 2);
		}
		return businessMapper.countByExample(example);
	}

	@Override
	public Business selectBusinessByBid(String bid) {
		return businessMapper.selectByPrimaryKey(bid);
	}

	@Override
	public int addBusiness(Business business) {
		return businessMapper.insertSelective(business);
	}

}
