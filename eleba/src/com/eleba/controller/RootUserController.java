package com.eleba.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eleba.bean.PageBean;
import com.eleba.pojo.User;
import com.eleba.service.AdminUserService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理controller
 * 
 * @author asus2016
 *
 */
@Controller
@RequestMapping(value = "/root/user")
public class RootUserController {
	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private SessionProvider sessionProvider;

	@RequestMapping(value = "/list")
	public String list(User user, PageBean<User> pageBean, Model model) {

		PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSize());
		List<User> list = adminUserService.selectUser(user);
		int totalCount = adminUserService.getTotalCountByUser(user);
		pageBean.setTotalCount(totalCount);

		model.addAttribute("list", list);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("user", user);

		return "/root/user/list";
	}

	@RequestMapping(value = "/freeze")
	public String freezeUser(String uid) {
		adminUserService.updateUser2Freeze(uid);
		return "redirect:/root/user/list.action";

	}

	@RequestMapping(value = "/active")
	public String activeUser(String uid) {
		adminUserService.updateUser2Active(uid);
		return "redirect:/root/user/list.action";

	}

	@RequestMapping(value = "login")
	public String login(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		List<User> users = adminUserService.selectUserByUsernameAndPassword(user);
		if (null != users && users.size() >= 1) {
			User existUser = users.get(0);
			if (existUser.getType() == 2) {
				sessionProvider.setAttribute(request, response, Constants.ROOT_SESSION, existUser);
				return "redirect:/root/home.jsp";
			} else {
				model.addAttribute("msg", "对不起，您没有该权限！");
			}
		} else {
			model.addAttribute("msg", "您的账号和密码不匹配");
		}
		model.addAttribute("user", user);
		return "/root/index";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// session过期
		session.invalidate();

		return "redirect:/root/index.jsp";
	}
}
