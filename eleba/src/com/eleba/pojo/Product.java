package com.eleba.pojo;

import java.util.Date;

public class Product {
    private String pid;

    private String pname;

    private Double price;

    private String pimage;

    private Date pdate;

    private String pdesc;

    private Integer pflag;

    private String bid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage == null ? null : pimage.trim();
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
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", pimage=" + pimage + ", pdate="
				+ pdate + ", pdesc=" + pdesc + ", pflag=" + pflag + ", bid=" + bid + "]";
	}
    
}