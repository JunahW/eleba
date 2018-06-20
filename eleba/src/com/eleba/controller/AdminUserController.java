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
import com.eleba.pojo.Business;
import com.eleba.pojo.User;
import com.eleba.service.AdminBusinessService;
import com.eleba.service.AdminUserService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.github.pagehelper.PageHelper;

/**
 * 商家用户controller
 * 
 * @author asus2016
 *
 */
@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private AdminBusinessService adminBusinessService;

	@Autowired
	private SessionProvider sessionProvider;

	/**
	 * 商家登录 @Description: TODO @param @param user @param @param model @param @param
	 * request @param @param response @param @return @return String @throws
	 */
	@RequestMapping(value = "/login")
	public String login(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		List<User> users = adminUserService.selectUserByUsernameAndPassword(user);
		/**
		 * 用户类型为1，代表商家
		 */
		if (null != users && users.size() >= 1) {
			User existUser = users.get(0);
			if (existUser.getType() == 1) {
				if (existUser.getState() == 1) {
					/**
					 * 判断店铺是否激活
					 */
					Business business = new Business();
					business.setBossid(user.getUid());
					List<Business> selectBusiness = adminBusinessService.selectBusiness(business);
					if (null != selectBusiness && selectBusiness.size() >= 1) {
						business = selectBusiness.get(0);
						if (business.getState() == 1) {
							sessionProvider.setAttribute(request, response, Constants.ADMIN_SESSION, existUser);
							return "redirect:/admin/home.jsp";
						} else {
							model.addAttribute("msg", "店铺审核未通过");
						}
					} else {
						model.addAttribute("msg", "未申请入驻");
					}

				} else {
					model.addAttribute("msg", "您的账户被冻结或为审核通过");
				}
			} else {
				model.addAttribute("msg", "对不起，您没有该权限！");
			}
		} else {
			model.addAttribute("msg", "您的账号和密码不匹配");
		}
		model.addAttribute("user", user);
		return "/admin/index";
	}

	/**
	 * 退出登录 @Description: TODO @param @param session @param @return @param @throws
	 * Exception @return String @throws
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// session过期
		session.invalidate();
		return "redirect:/admin/index.jsp";
	}
}
