package com.eleba.pojo;

import java.io.Serializable;

public class Addr implements Serializable {

	/**
	 * `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID', 
	 * `buyerid` varchar(40) NOT NULL COMMENT '用户ID', 
	 * `name` varchar(80) NOT NULL COMMENT '收货人', 
	 * `city` varchar(255) DEFAULT NULL, '城市'
	 * `addr` varchar(400) NOT NULL COMMENT '收货地址',
	 * `phone` varchar(60) NOT NULL COMMENT '手机号或是固定电话号', 
	 * `isdef` int(1) NOT NULL COMMENT '是否默认',
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String buyerId;
	private String name;
	
	private String city;
	private String addr;
	private String phone;
	
	private Integer isDef=0;

	public Addr() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsDef() {
		return isDef;
	}

	public void setIsDef(Integer isDef) {
		this.isDef = isDef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
