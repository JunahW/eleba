package com.eleba.pojo;

import java.io.Serializable;

public class Orderitem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemid;

	private Integer count;

	private Double subtotal;

	private Product product;

	private String pid;

	public String getPid() {
		this.pid=product.getPid();
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	private String oid;

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid == null ? null : itemid.trim();
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderitem other = (Orderitem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.getPid().equals(other.product.getPid()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orderitem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", product=" + product
				+ ", oid=" + oid + "]";
	}

}