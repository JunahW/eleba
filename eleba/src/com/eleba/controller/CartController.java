package com.eleba.controller;

import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eleba.bean.BuyCart;
import com.eleba.pojo.Addr;
import com.eleba.pojo.Orderitem;
import com.eleba.pojo.Orders;
import com.eleba.pojo.Product;
import com.eleba.pojo.User;
import com.eleba.service.AddrService;
import com.eleba.service.AdminProductService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.eleba.utils.UUIDUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 购物车controller
 * 
 * @author asus2016
 *
 */
@RequestMapping(value = "/cart")
@Controller
public class CartController {

	@Autowired
	private AdminProductService adminProductService;
	@Autowired
	private AddrService addrService;
	@Autowired
	private SessionProvider sessionProvider;

	/**
	 * 购买按钮
	 * 
	 * @parameter count @parameter pid @parameter request @parameter
	 *            response @parameter model @parameter @return String @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/addCart")
	public BuyCart buyCart(@RequestParam(value = "count", defaultValue = "1") Integer count, String pid,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
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
		// 如果没有 创建购物车
		if (null == buyCart) {
			buyCart = new BuyCart();
		}
		// 获取product
		Product product = adminProductService.selectProductById(pid);
		// 创建购物项
		Orderitem orderitem = new Orderitem();

		orderitem.setItemid(UUIDUtils.getId());
		// 数量 1 2 3 -1
		orderitem.setCount(count);
		orderitem.setProduct(product);
		// 添加购物项
		buyCart.addItem(orderitem);
		// 流
		StringWriter str = new StringWriter();
		// 对象转Json 写的过程 Json是字符串流
		try {
			oMapper.writeValue(str, buyCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 购物车装进Cookie中 对象转Json
		Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
		// expiry 秒
		cookie.setMaxAge(60 * 20);
		// 路径
		// 默认 /shopping
		cookie.setPath("/");
		// 发送
		response.addCookie(cookie);
		// 装购物车装满
		List<Orderitem> items = buyCart.getItems();
		for (Orderitem item : items) {
			// 小计
			double subtotal = item.getCount() * item.getProduct().getPrice();
			item.setSubtotal(subtotal);
		}

		return null;
	}

	/**
	 * 返回购物车 @Description: TODO @param @param request @param @param
	 * response @param @param model @param @return @return BuyCart @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/showCart")
	public BuyCart showBuyCart(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ObjectMapper oMapper = new ObjectMapper();
		oMapper.setSerializationInclusion(Include.NON_NULL);

		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车

		// buyCart_cookie
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
		if (null == buyCart) {
			buyCart = new BuyCart();
		}
		List<Orderitem> items = buyCart.getItems();
		for (Orderitem orderitem : items) {
			orderitem.setProduct(adminProductService.selectProductById(orderitem.getProduct().getPid()));
			orderitem.setSubtotal(orderitem.getCount() * orderitem.getProduct().getPrice());
		}

		return buyCart;
	}

	// 清空购物车
	@ResponseBody
	@RequestMapping(value = "/clearCart")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) {

		Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		return null;
	}

	// 删除一个购物项
	@RequestMapping(value = "/shopping/deleteItem")
	public String deleteItem(HttpServletRequest request, String pid, HttpServletResponse response, String itemid) {
		// springmvc
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
			// 创建购物项
			Orderitem orderitem = new Orderitem();
			buyCart.deleteItem(orderitem);

			// 流
			StringWriter str = new StringWriter();
			// 对象转Json 写的过程 Json是字符串流
			try {
				oMapper.writeValue(str, buyCart);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 购物车装进Cookie中 对象转Json
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
			// expiry 秒
			cookie.setMaxAge(60 * 20);
			// 路径
			cookie.setPath("/");
			// 发送
			response.addCookie(cookie);

		}
		return "redirect:/shopping/buyCart.shtml";
	}

}
