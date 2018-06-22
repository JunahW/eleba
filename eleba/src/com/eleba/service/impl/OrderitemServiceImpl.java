package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.OrderitemMapper;
import com.eleba.pojo.Orderitem;
import com.eleba.pojo.OrderitemExample;
import com.eleba.pojo.OrderitemExample.Criteria;
import com.eleba.service.OrderitemService;

@Service
public class OrderitemServiceImpl implements OrderitemService {

	@Autowired
	private OrderitemMapper orderitemMapper;

	@Override
	public int addOrderitem(Orderitem orderitem) {
		return orderitemMapper.insertSelective(orderitem);
	}

	@Override
	public List<Orderitem> selectOrderItems(String oid) {

		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOidEqualTo(oid);
		return orderitemMapper.selectByExample(example);
	}

}
