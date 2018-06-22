package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.OrderitemMapper;
import com.eleba.pojo.Orderitem;
import com.eleba.pojo.OrderitemExample;
import com.eleba.pojo.OrderitemExample.Criteria;
import com.eleba.service.AdminOrderItemService;

@Service
public class AdminOrderItemServiceImpl implements AdminOrderItemService {

	@Autowired
	private OrderitemMapper orderitemMapper;

	@Override
	public int addOrderItem(Orderitem OrderItem) {
		return orderitemMapper.insertSelective(OrderItem);
	}

	@Override
	public List<Orderitem> listOrderItem(String oid) {
		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOidEqualTo(oid);
		return orderitemMapper.selectByExample(example);
	}

	@Override
	public Orderitem selectOrderItemById(String itemid) {
		return orderitemMapper.selectByPrimaryKey(itemid);
	}

	@Override
	public List<Orderitem> selectOrderItemByOid(String oid) {

		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOidEqualTo(oid);
		
		return orderitemMapper.selectByExample(example);
	}

}
