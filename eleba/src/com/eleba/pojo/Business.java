package com.eleba.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Business implements Serializable {

	/**
	 * `bid` varchar(100) NOT NULL COMMENT '商家id',
	 * `name` varchar(100) DEFAULT NULLCOMMENT '商家名称', 
	 * `bossid` varchar(100) DEFAULT NULL COMMENT '老板id',
	 * `createtime` datetime DEFAULT NULL COMMENT '入驻时间', 
	 * `state` tinyint(4) DEFAULT'0' COMMENT '状态 0位激活 1已激活',
	 * `statetime` datetime DEFAULT NULL COMMENT '激活时间',
	 * `telephone` varchar(100) DEFAULT NULL COMMENT '商家电话', 
	 * `desc` varchar(225)DEFAULT NULL COMMENT '简介',
	 * `notice` varchar(225) DEFAULT NULL COMMENT '公告',
	 * `imgurl` varchar(255) DEFAULT NULL COMMENT '图片路径', 
	 * `sort` int(11) DEFAULT NULL COMMENT '排序'
	 */
	
	private String bid;
	private String name;
	private String bossid;
	
	private Date createTime;
	private Integer state;
	private Date stateTime;
	
	private String telephone;
	private String desc;
	private String notice;
	
	private String ingUrl;
	private Integer sort;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBossid() {
		return bossid;
	}
	public void setBossid(String bossid) {
		this.bossid = bossid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getStateTime() {
		return stateTime;
	}
	public void setStateTime(Date stateTime) {
		this.stateTime = stateTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getIngUrl() {
		return ingUrl;
	}
	public void setIngUrl(String ingUrl) {
		this.ingUrl = ingUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Business() {
		super();
	}
	
}
