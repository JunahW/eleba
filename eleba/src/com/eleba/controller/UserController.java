package com.eleba.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.eleba.pojo.User;
import com.eleba.service.UserService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.eleba.utils.UUIDUtils;

/**
 * 这是普通用户管理模块
 * 
 * @author sunwei
 *
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

	@Value("${user_pic}")
	private String userPicPath;

	@Autowired
	private UserService userService;

	@Autowired
	private SessionProvider sessionProvider;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @param ufile
	 * @return
	 */
	@RequestMapping(value = "/register")
	public String register(User user, MultipartFile ufile, Model model) {

		/**
		 * 校验用户的用户名和手机号是够被注册
		 */
		User existUser = userService.selectUsersByUserName(user.getUsername());
		User existUser2 = userService.selectUserByTelephone(user.getTelephone());
		if (null != existUser && 0 == existUser.getType()) {
			model.addAttribute("usernameMsg", "用户名已经存在");
			return "/user/user_register";
		}
		if (null != existUser2 && 0 == existUser2.getType()) {
			model.addAttribute("telephoneMsg", "手机号已经存在");
			return "/user/user_register";
		}

		if (null != existUser&&1==existUser.getType()) {
			model.addAttribute("usernameMsg", "用户名已经存在");
			return "/user/shop_person_register";
		}
		if (null != existUser2&&1==existUser2.getType()) {
			model.addAttribute("telephoneMsg", "手机号已经存在");
			return "/user/shop_person_register";
		}

		if (null != ufile && ufile.getOriginalFilename() != "") {
			String picName = ufile.getOriginalFilename();
			// 上传图片
			String newName = UUIDUtils.getId() + picName.substring(picName.indexOf("."));
			user.setImgurl(newName);
			File picFile = new File(userPicPath, newName);
			if (!picFile.exists()) {
				try {
					picFile.createNewFile();
					ufile.transferTo(picFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		userService.addUser(user);
		if (user.getType() == 1) {
			model.addAttribute("msg", "");
			return "/user/shop_success";
		}
		model.addAttribute("msg", "注册成功，快去邮箱激活吧");
		return "/user/success";

	}

	// 登陆提交
	// userid：用户账号，pwd：密码
	@RequestMapping(value = "/login")
	public String login(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userService.selectUser(user);
		if (null != users && users.size() >= 1) {
			User existUser = users.get(0);
			if (existUser.getType() == 0) {
				sessionProvider.setAttribute(request, response, Constants.BUYER_SESSION, existUser);
				return "redirect:/business/list.action";
			} else {
				model.addAttribute("msg", "对不起，您没有该权限！");
			}
		} else {
			model.addAttribute("msg", "您的账号和密码不匹配");
		}
		model.addAttribute("user", user);
		return "/user/login";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// session过期
		session.invalidate();

		return "redirect:/business/list.action";
	}

	/**
	 * 激活用户 @Description: TODO @param @param user @param @param
	 * model @param @return @return String @throws
	 */
	@RequestMapping(value = "/active")
	public String active(User user, Model model) {
		userService.activeUser(user);
		model.addAttribute("msg", "激活成功，开启吃货模式");
		return "/user/success";
	}

	@RequestMapping(value = "find")
	public String selectUser(User user) {
		userService.selectUser(user);
		return "redirect:index";
	}

	@RequestMapping(value = "update")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:index";
	}

	@RequestMapping(value = "delete")
	public String deleteUser(User user) {
		userService.deleteUser(user);
		return "redirect:index";
	}

}
