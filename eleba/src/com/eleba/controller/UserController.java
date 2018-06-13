package com.eleba.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eleba.pojo.User;
import com.eleba.service.UserService;
import com.eleba.utils.UUIDUtils;

import sun.print.resources.serviceui;

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

	/**
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
			System.out.println(newName);
		}

		System.out.println(user);
		userService.addUser(user);

		return "/index";
	}

	// 登陆页面
	@RequestMapping("/login")
	public String login(Model model) throws Exception {

		return "index";
	}

	// 登陆提交
	// userid：用户账号，pwd：密码
	@RequestMapping("/loginsubmit")
	public String loginsubmit(HttpSession session, User user, Model model) throws Exception {
		List<User> users = userService.checkLogin(user);

		if (null != users && users.size() >= 1) {
			user = users.get(0);
			if (user.getState() == 1) {
				session.setAttribute("activeUser", user);
				System.out.println("11111");
				return "home";
			} else {

			}
		} else {
			model.addAttribute("msg", "");
		}

		model.addAttribute("user", user);
		// 向session记录用户身份信息
		return "index";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// session过期
		session.invalidate();

		return "/home";
	}

	@RequestMapping(value = "/active")
	public String active(User user) {

		userService.activeUser(user);
		return "";

	}
	
	@RequestMapping(value = "find")
	public String selectUser(User user){
		 userService.selectUser(user);
		 return "redirect:index";
	}
	
	@RequestMapping(value = "update")
	public String updateUser(User user){
		 userService.updateUser(user);
		 return "redirect:index";
	}
	
	@RequestMapping(value = "delete")
	public String deleteUser(User user){
		 userService.deleteUser(user);
		 return "redirect:index";
	}
	
	
	
}
