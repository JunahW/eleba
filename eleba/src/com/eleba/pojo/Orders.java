package com.eleba.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Orders implements Serializable {

	/**
	 * `oid` varchar(32) NOT NULL COMMENT '订单号', 
	 * `ordertime` datetime DEFAULT NULLCOMMENT '订单时间', 
	 * `total` double DEFAULT NULL COMMENT '总计', 
	 * `state` int(11) DEFAULT NULL COMMENT '状态', 
	 * `address` int(11) DEFAULT NULL COMMENT '地址',
	 * `name` varchar(20) DEFAULT NULL COMMENT '名字', 
	 * `uid` varchar(32) DEFAULT NULL COMMENT '用户id'
	 */
	private static final long serialVersionUID = 1L;
	
	private String oid;
	private Date ordertime;
	private Double total;
	
	private Integer state;
	private String address;
	private String name;
	
	private User user;
	private ArrayList<OrderItem> oList=new ArrayList<>();
	
	public Orders() {
		super();
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<OrderItem> getoList() {
		return oList;
	}

	public void setoList(ArrayList<OrderItem> oList) {
		this.oList = oList;
	}
	
	


}
