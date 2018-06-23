package com.eleba.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eleba.pojo.User;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;

public class UserInterceptor implements HandlerInterceptor {
	@Autowired
	private SessionProvider sessionProvider;

	// 方法前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("=======================" + request.getRequestURI());

		if (request.getRequestURI().startsWith(Constants.USER_INTERCEPT)) {
			User user = (User) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
			if (null != user && 0 == user.getType()) {
				return true;
			}
		}

		response.sendRedirect("/eleba/user/login.jsp");
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
