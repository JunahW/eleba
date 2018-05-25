package com.eleba.pojo;

import java.io.Serializable;

public class Province implements Serializable {

	/**
	 *  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	 *  `code` char(6) NOT NULLCOMMENT '省份编码',
	 *  `name` varchar(40) NOT NULL COMMENT '省份名称', PRIMARY KEY
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String code;
	private String name;
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
	public Province() {
		super();
	}
	

}
