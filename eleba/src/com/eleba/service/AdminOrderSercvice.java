package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Orders;

public interface AdminOrderSercvice {

	List<Orders> selectOrders(String bid);

	int getTotalOrdersCountByBid(String bid);

	int updateState(String oid);

}
