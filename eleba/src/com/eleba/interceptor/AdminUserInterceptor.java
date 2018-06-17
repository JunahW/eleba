package com.eleba.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eleba.pojo.User;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;

public class AdminUserInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionProvider sessionProvider;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@SuppressWarnings("null")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println(request.getRequestURI());
		if (request.getRequestURI().startsWith(Constants.ADMIN_INTERCEPT)) {
			if (request.getRequestURI().equals("/eleba/admin/user/login.action")) {
				return true;
			} else {
				User user = (User) sessionProvider.getAttribute(request, response, Constants.ADMIN_SESSION);
				if (null != user && 1 == user.getType()) {

					return true;
				}
			}

		}
		response.sendRedirect("/eleba/admin/index.jsp");
		return false;
	}

}
