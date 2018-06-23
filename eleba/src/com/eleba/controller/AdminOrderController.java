package com.eleba.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.bean.PageBean;
import com.eleba.pojo.Business;
import com.eleba.pojo.Orderitem;
import com.eleba.pojo.Orders;
import com.eleba.pojo.Product;
import com.eleba.service.AdminOrderItemService;
import com.eleba.service.AdminOrderSercvice;
import com.eleba.service.AdminProductService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value = "/admin/order")
public class AdminOrderController {

	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private AdminOrderSercvice adminOrderSercvice;

	@Autowired
	private AdminProductService adminProductService;

	@Autowired
	private AdminOrderItemService adminOrderItemService;

	@RequestMapping(value = "list")
	public String listOrder(HttpServletRequest request, HttpServletResponse response, Model model,
			PageBean<Orders> pageBean) {
		Business business = (Business) sessionProvider.getAttribute(request, response, Constants.SHOP_SESSION);

		PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSize());
		List<Orders> orderList = adminOrderSercvice.selectOrders(business.getBid());
		int totalCount = adminOrderSercvice.getTotalOrdersCountByBid(business.getBid());
		pageBean.setTotalCount(totalCount);

		model.addAttribute("pageBean", pageBean);
		model.addAttribute("orderList", orderList);

		return "/admin/order/list";
	}

	/**
	 * 修改订单，发货 @Description: TODO @param @param oid @param @return @return
	 * String @throws
	 */
	@RequestMapping(value = "/updateState")
	public String update(String oid) {
		adminOrderSercvice.updateState(oid);
		return "redirect:/admin/order/list.action";
	}

	@RequestMapping(value = "/orderDetail")
	public String orderDetail(String oid, Model model) {
		List<Orderitem> itemList = adminOrderItemService.selectOrderItemByOid(oid);
		Product product = null;
		for (Orderitem orderitem : itemList) {
			product = adminProductService.selectProductById(orderitem.getPid());
			orderitem.setProduct(product);
		}

		model.addAttribute("itemList", itemList);

		return "/admin/order/orderItem";
	}

}
