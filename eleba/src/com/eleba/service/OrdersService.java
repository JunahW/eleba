package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Orders;
import com.eleba.pojo.User;

public interface OrdersService {

	List<Orders> selectOrders(User user);

}
