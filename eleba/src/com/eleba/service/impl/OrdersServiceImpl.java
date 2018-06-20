package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.OrdersMapper;
import com.eleba.pojo.Orders;
import com.eleba.pojo.OrdersExample;
import com.eleba.pojo.OrdersExample.Criteria;
import com.eleba.pojo.User;
import com.eleba.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public List<Orders> selectOrders(User user) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(user.getUid());

		return ordersMapper.selectByExample(example);
	}

}
