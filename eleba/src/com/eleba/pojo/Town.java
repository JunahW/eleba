package com.eleba.pojo;

import java.io.Serializable;

public class Town implements Serializable {

	/**
	 * `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键', 
	 * `code` char(6) NOT NULL COMMENT '区县编码', 
	 * `name` varchar(40) NOT NULL COMMENT '区县名称', 
	 * `city` char(6) NOT NULL COMMENT '所属城市编码'
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String name;
	private String city;
	public Town() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
}
