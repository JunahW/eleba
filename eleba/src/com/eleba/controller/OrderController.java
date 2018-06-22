package com.eleba.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.bean.BuyCart;
import com.eleba.pojo.Addr;
import com.eleba.pojo.Orderitem;
import com.eleba.pojo.Orders;
import com.eleba.pojo.User;
import com.eleba.service.AddrService;
import com.eleba.service.AdminProductService;
import com.eleba.service.OrderitemService;
import com.eleba.service.OrdersService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.eleba.utils.UUIDUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = "/buyer")
@Controller
public class OrderController {

	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private OrderitemService orderitemService;

	@Autowired
	private AdminProductService adminProductService;

	@Autowired
	private AddrService addrService;

	@Autowired
	private OrdersService ordersService;

	/**
	 * 结算 @Description: TODO @param @param request @param @param
	 * response @param @param model @param @return @return String @throws
	 */
	@RequestMapping(value = "/submit")
	public String trueBuy(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ObjectMapper oMapper = new ObjectMapper();
		oMapper.setSerializationInclusion(Include.NON_NULL);
		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (Constants.BUYCART_COOKIE.equals(c.getName())) {
					// 如果有了 就使用此购物车
					String value = c.getValue();
					try {
						buyCart = oMapper.readValue(value, BuyCart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

		if (null != buyCart) {
			List<Orderitem> items = buyCart.getItems();
			for (Orderitem orderitem : items) {
				orderitem.setProduct(adminProductService.selectProductById(orderitem.getProduct().getPid()));
				orderitem.setSubtotal(orderitem.getCount() * orderitem.getProduct().getPrice());
			}

			User user = (User) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
			List<Addr> addrs = addrService.selectAddr(user);

			Orders orders = new Orders();
			orders.setOid(UUIDUtils.getOrderId());
			orders.setTotal(buyCart.getProductPrice());
			orders.setOrderitems(items);
			// 设置订单所属的商家
			orders.setBid(items.get(0).getProduct().getBid());
			/**
			 * 将订单放入session中
			 */
			sessionProvider.setAttribute(request, response, Constants.ORDERS_SESSION, orders);

			model.addAttribute("addrs", addrs);
			// 清空购物车
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);

			return "/user/pay";
		}
		return "redirect:/eleba/business/list.action";
	}

	@RequestMapping(value = "/orders")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {

		User user = (User) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
		List<Orders> orderList = ordersService.selectOrders(user);

		model.addAttribute("orderList", orderList);

		System.out.println(orderList);

		return "/user/order";
	}

	/**
	 * 付款 @Description: TODO @param @param request @param @param
	 * response @param @param model @param @return @return String @throws
	 */
	@RequestMapping(value = "/pay")
	public String pay(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 获取当前用户
		User user = (User) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);

		Orders orders = (Orders) sessionProvider.getAttribute(request, response, Constants.ORDERS_SESSION);
		// 设置状态0表示下单
		orders.setState(0);

		orders.setUid(user.getUid());
		/**
		 * 将订单存入数据库
		 */
		ordersService.insertOrders(orders);

		String oid = orders.getOid();

		List<Orderitem> orderitems = orders.getOrderitems();
		for (Orderitem orderitem : orderitems) {
			orderitem.setOid(oid);
			orderitemService.addOrderitem(orderitem);
		}
		// 清空订单
		sessionProvider.setAttribute(request, response, Constants.ORDERS_SESSION, null);

		List<Orders> orderList = ordersService.selectOrders(user);
		model.addAttribute("orderList", orderList);
		return "/user/order";

	}

	@RequestMapping(value = "/detail")
	public String detail(String oid, Model model) {
		List<Orderitem> itemList = orderitemService.selectOrderItems(oid);
		model.addAttribute("itemList", itemList);
		return "/user/order_detail";
	}

}
