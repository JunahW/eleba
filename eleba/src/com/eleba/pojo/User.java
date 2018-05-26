package com.eleba.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * `uid` varchar(32) NOT NULL COMMENT '用户id', 
	 * `username` varchar(20) DEFAULT NULL COMMENT '用户名称', 
	 * `password` varchar(20) DEFAULT NULL COMMENT '用户密码',
	 * `name` varchar(20) DEFAULT NULL COMMENT '真实名称', 
	 * `email` varchar(30) DEFAULT NULL COMMENT '邮箱', 
	 * `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
	 * `birthday` date DEFAULT NULL COMMENT '生日', 
	 * `sex` tinyint(4) DEFAULT NULL COMMENT '性别 1男生 0女生', 
	 * `state` int(11) DEFAULT NULL COMMENT '状态'0 未激活, 
	 * `code`varchar(64) DEFAULT NULL COMMENT '验证码', 
	 * `type` tinyint(11) DEFAULT '0'COMMENT '用户类型 0普通 1商家 2管理员', 
	 * `imgurl` varchar(255) DEFAULT NULL COMMENT '图片路径', 
	 */
	private String uid;
	private String username;
	private String password;
	
	private String name;
	private String email;
	private String telephone;
	
	private Date date;
	private Integer sex;
	private Integer state=0;
	
	private String code;
	private Integer type;
	private String imgurl;

	
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User() {
		super();
	}
	
}
