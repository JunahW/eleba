package com.eleba.service;

import java.util.List;
import com.eleba.pojo.Orderitem;

public interface AdminOrderItemService {
	/**
	 * 添加商品
	 * 
	 * @parameter OrderItem @parameter @return int @throws
	 */
	int addOrderItem(Orderitem OrderItem);

	/**
	 * 查找商品列表
	 * 
	 * @parameter @return @return List<OrderItem> @throws
	 */

	List<Orderitem> listOrderItem(String oid);

	/**
	 * 通过id查找商品
	 * 
	 * @parameter @param pid @parameter @return @return OrderItem @throws
	 */
	Orderitem selectOrderItemById(String itemid);

}
