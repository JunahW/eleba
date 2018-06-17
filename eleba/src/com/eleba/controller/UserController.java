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
	public String register(User user, MultipartFile ufile) {

		String picName = ufile.getOriginalFilename();
		if (null != picName && picName != "") {

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
		return "/index";
	}

	// 登陆提交
	// userid：用户账号，pwd：密码
	@RequestMapping(value = "login")
	public String login(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userService.selectUser(user);
		if (null != users && users.size() >= 1) {
			User existUser = users.get(0);
			if (existUser.getType() == 1) {
				sessionProvider.setAttribute(request, response, Constants.BUYER_SESSION, existUser);
				return "redirect:/user/home.jsp";
			} else {
				model.addAttribute("msg", "对不起，您没有该权限！");
			}
		} else {
			model.addAttribute("msg", "您的账号和密码不匹配");
		}
		model.addAttribute("user", user);
		return "/user/index";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// session过期
		session.invalidate();

		return "redirect:/user/index.jsp";
	}

	@RequestMapping(value = "/active")
	public String active(User user) {

		userService.activeUser(user);
		return "";

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
