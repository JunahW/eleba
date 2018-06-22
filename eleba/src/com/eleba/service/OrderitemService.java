package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Orderitem;

public interface OrderitemService {

	int addOrderitem(Orderitem orderitem);

	List<Orderitem> selectOrderItems(String oid);

}
