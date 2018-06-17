package com.eleba.utils;

/**
 * 业务常量
 * 
 * @author lx
 *
 */
public interface Constants {

	/**
	 * 图片服务器
	 */
	public static final String IMAGE_URL = "http://localhost:8080/eleba/";
	/**
	 * 用户Session
	 */
	public static final String BUYER_SESSION = "buyer_session";
	/**
	 * 购物车Cookie
	 */
	public static final String BUYCART_COOKIE = "buyCart_cookie";
	/**
	 * 用户Session
	 */
	public static final String ROOT_SESSION = "root_session";
	/**
	 * 用户Session
	 */
	public static final String ADMIN_SESSION = "admin_session";
	/**
	 * 拦截路径
	 */
	public static final String ROOT_INTERCEPT = "/eleba/root/";
	public static final String ADMIN_INTERCEPT = "/eleba/admin/";
	public static final String USER_INTERCEPT = "/eleba/buyer/";
}
