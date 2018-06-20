package com.eleba.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.eleba.bean.PageBean;
import com.eleba.pojo.Business;
import com.eleba.pojo.User;
import com.eleba.service.AdminBusinessService;
import com.eleba.service.UserService;
import com.eleba.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

@RequestMapping(value = "/business")
@Controller
public class BusinessController {
	@Autowired
	AdminBusinessService adminBusinessService;
	@Autowired
	private UserService userService;
	@Value("${business_pic}")
	private String businessPicPath;

	@Value("${b_img_server}")
	private String businessImgServer;

	@RequestMapping(value = "/list")
	public String list(Business business, PageBean<Business> pageBean, Model model) {
		// 设置每页显示20条
		pageBean.setPageSize(20);
		PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSize());
		List<Business> list = adminBusinessService.selectBusiness(business);

		int totalCount = adminBusinessService.getTotalCountByBusiness(business);

		pageBean.setTotalCount(totalCount);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("list", list);
		model.addAttribute("business", business);
		model.addAttribute("businessImgServer", businessImgServer);

		return "/user/index";

	}

	/**
	 * 商家入驻 @Description:  @param @param business @param @param
	 * user @param @param bfile @param @param model @param @return @return
	 * String @throws
	 */
	@RequestMapping(value = "/register")
	public String registerBusiness(Business business, User user, MultipartFile bfile, Model model) {

		String picName = bfile.getOriginalFilename();
		if (null != picName && picName != "") {
			// 上传图片
			String newName = UUIDUtils.getId() + picName.substring(picName.indexOf("."));
			business.setImgurl(newName);
			File picFile = new File(businessPicPath, newName);
			if (!picFile.exists()) {
				try {
					picFile.createNewFile();
					bfile.transferTo(picFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		List<User> selectUsers = userService.selectUser(user);
		if (null != selectUsers && selectUsers.size() >= 1) {
			User existUser = selectUsers.get(0);
			if (existUser.getState() == 1) {
				if (existUser.getType() == 1) {
					// 将商家添加至数据库
					adminBusinessService.addBusiness(business);
					return "/user/success";
				} else {
					model.addAttribute("msg", "对不起，您没有该权限");
				}

			} else {
				model.addAttribute("msg", "用户还未激活");
			}

		} else {
			model.addAttribute("msg", "该用户不存在");
		}

		return "/user/shop_register";
	}

	/**
	 * 注销登录 @Description: @param @param session @param @return @param @throws
	 * Exception @return String @throws
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// session过期
		session.invalidate();
		return "redirect:/user/business/list.action";
	}

}
