package com.eleba.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {

	/**
	 * `pid` varchar(32) NOT NULL, 
	 * `pname` varchar(50) DEFAULT NULL, 
	 * `price` double DEFAULT NULL, 
	 * `pimage` varchar(200) DEFAULT NULL, 
	 * `pdate` date DEFAULT NULL,
	 * `pdesc` varchar(255) DEFAULT NULL, 
	 * `pflag` int(11) DEFAULT NULL, 
	 * `bid`varchar(255) DEFAULT NULL
	 */
	private static final long serialVersionUID = 1L;
	
	private String pid;
	private String pname;
	private Double price;
	
	private String pimge;
	private Date pdate;
	private String pdesc;
	
	private Integer pflag;
	private Business business;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPimge() {
		return pimge;
	}
	public void setPimge(String pimge) {
		this.pimge = pimge;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getPflag() {
		return pflag;
	}
	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public Product() {
		super();
	}
	

}
