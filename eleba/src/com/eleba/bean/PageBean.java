package com.eleba.bean;

import java.util.List;

/**
 * 分页bean
 * 
 * @author asus2016
 *
 * @param <E>
 */
public class PageBean<E> {
	private List<E> list;
	private Integer currPage = 1;
	private Integer pageSize = 10;
	private Integer totalPage;
	private Integer totalCount;

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		this.totalPage=(int) Math.ceil(totalCount * 1.0 / pageSize);
		return totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public PageBean() {
	}

	public PageBean(List<E> list, Integer currPage, Integer pageSize, Integer totalCount) {
		super();
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

}
