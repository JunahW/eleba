package com.eleba.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;

public class UserInterceptor implements HandlerInterceptor {
	@Autowired
	private SessionProvider sessionProvider;

	// 常量
	private static final String INTERCEPTOR_URL = "/buy/";

	// 方法前 /buyer/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getRequestURI().startsWith(INTERCEPTOR_URL)) {
			Object user = sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
			if (user != null) {
				return true;
			}
		}

		response.sendRedirect("/eleba/user/login.action");
		return false;
	}

	// 方法后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	// 页面渲染后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
