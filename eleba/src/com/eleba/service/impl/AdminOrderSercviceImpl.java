package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.OrdersMapper;
import com.eleba.pojo.Orders;
import com.eleba.pojo.OrdersExample;
import com.eleba.pojo.OrdersExample.Criteria;
import com.eleba.service.AdminOrderSercvice;

@Service
public class AdminOrderSercviceImpl implements AdminOrderSercvice {
	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public List<Orders> selectOrders(String bid) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andBidEqualTo(bid);
		example.setOrderByClause("`state` ASC");

		return ordersMapper.selectByExample(example);
	}

	@Override
	public int getTotalOrdersCountByBid(String bid) {
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		criteria.andBidEqualTo(bid);

		return ordersMapper.countByExample(example);
	}

	@Override
	public int updateState(String oid) {
		Orders orders = new Orders();
		orders.setOid(oid);
		orders.setState(2);

		return ordersMapper.updateByPrimaryKeySelective(orders);

	}

}
