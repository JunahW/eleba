package com.eleba.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderItem implements Serializable {

	/**
	 * itemid` varchar(32) NOT NULL COMMENT '订单项id', 
	 * `count` int(11) DEFAULT NULL COMMENT '数量', 
	 * `subtotal` double DEFAULT NULL COMMENT '小计', 
	 * `pid` varchar(32) DEFAULT NULL COMMENT '商品id',
	 * `oid` varchar(32) DEFAULT NULL COMMENT '订单id',
	 */
	private static final long serialVersionUID = 1L;
	
	private String itemId;
	private Integer count;
	private Double subtotal;
	
	private ArrayList<Product>  pList =new ArrayList<>();
	private Orders order;
	
	public OrderItem() {
		super();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public ArrayList<Product> getpList() {
		return pList;
	}

	public void setpList(ArrayList<Product> pList) {
		this.pList = pList;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
}
