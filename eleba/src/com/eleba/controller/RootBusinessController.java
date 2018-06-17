package com.eleba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eleba.bean.PageBean;
import com.eleba.pojo.Business;
import com.eleba.pojo.User;
import com.eleba.service.AdminBusinessService;
import com.eleba.service.AdminUserService;
import com.github.pagehelper.PageHelper;

/**
 * 用户管理controller
 * 
 * @author asus2016
 *
 */
@Controller
@RequestMapping(value = "/root/business")
public class RootBusinessController {
	@Autowired
	private AdminBusinessService adminBusinessService;
	@Autowired
	private AdminUserService adminUserService;

	@RequestMapping(value = "/list")
	public String list(Business business, PageBean<Business> pageBean, Model model) {

		PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSize());
		List<Business> list = adminBusinessService.selectBusiness(business);
		int totalCount = adminBusinessService.getTotalCountByBusiness(business);
		pageBean.setTotalCount(totalCount);

		model.addAttribute("list", list);
		model.addAttribute("pageBean", pageBean);
		// 设置回显
		model.addAttribute("business", business);

		return "/root/business/list";
	}

	/**
	 * 查询申请入驻的商家
	 * 
	 * @Description: TODO @param @param business @param @param
	 *               pageBean @param @param model @param @return @return
	 *               String @throws
	 */
	@RequestMapping(value = "/listActiveUsers")
	public String listActiveUser(Business business, PageBean<Business> pageBean, Model model) {
		business.setState((byte) 2);
		PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSize());
		List<Business> list = adminBusinessService.selectBusiness(business);
		int totalCount = adminBusinessService.getTotalCountByBusiness(business);
		pageBean.setTotalCount(totalCount);

		model.addAttribute("list", list);
		model.addAttribute("pageBean", pageBean);

		return "/root/business/list";
	}

	@RequestMapping(value = "/freeze")
	public String freezeUser(String bid) {
		adminBusinessService.updateBusiness2Freeze(bid);
		return "redirect:/root/business/list.action";

	}

	@RequestMapping(value = "/active")
	public String activeUser(String bid) {
		adminBusinessService.updateBusiness2Active(bid);
		return "redirect:/root/business/list.action";

	}

	@RequestMapping(value = "/selectByBid")
	public String selectBusinessByBid(String bid, Model model) {
		Business business = adminBusinessService.selectBusinessByBid(bid);
		System.out.println("==================" + bid);
		User user = adminUserService.selectUserByUid(business.getBossid());

		model.addAttribute("business", business);
		model.addAttribute("boss", user);
		return "/root/business/detail";

	}

}
