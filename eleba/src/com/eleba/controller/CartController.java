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
import com.eleba.bean.BuyCart;
import com.eleba.pojo.Orderitem;
import com.eleba.pojo.Product;
import com.eleba.service.AddrService;
import com.eleba.service.AdminProductService;
import com.eleba.utils.Constants;
import com.eleba.utils.SessionProvider;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 购物车controller
 * 
 * @author asus2016
 *
 */
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
	@RequestMapping(value = "/user/buyCart")
	public String buyCart(Integer count, String pid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// springmvc
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
		// 如果有了 就使用此购物车
		// 如果没有 创建购物车
		if (null == buyCart) {
			// 购物车 //最后一款
			buyCart = new BuyCart();
		}
		// 获取product
		Product product = adminProductService.selectProductById(pid);
		// 创建购物项
		Orderitem orderitem = new Orderitem();

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
		cookie.setMaxAge(60 * 60 * 24);
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

		model.addAttribute("buyCart", buyCart);

		return "product/cart";
	}

	// 清空购物车
	@RequestMapping(value = "/shopping/clearCart.shtml")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) {

		Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		return "redirect:/shopping/buyCart";
	}

	// 删除一个购物项
	@RequestMapping(value = "/shopping/deleteItem")
	public String deleteItem(HttpServletRequest request, Integer skuId, HttpServletResponse response, String itemid) {
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
					String value = c.getValue();//
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 购物车装进Cookie中 对象转Json
			Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
			// 关闭浏览器 也要有Cookie
			// 默认是 -1 关闭浏览器 就没了
			// 消灭 0 马上就没有
			// expiry 秒
			cookie.setMaxAge(60 * 60 * 24);
			// 路径
			/// shopping/buyCart.shtml
			// 默认 /shopping
			// /shopping
			// /buyer/*.shtml
			cookie.setPath("/");
			// 发送
			response.addCookie(cookie);

		}
		return "redirect:/shopping/buyCart.shtml";
	}

	// 结算
	@RequestMapping(value = "/buyer/trueBuy.shtml")
	public String trueBuy(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
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
					String value = c.getValue();//
					//
					try {
						buyCart = oMapper.readValue(value, BuyCart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		// 判断购物车中是否有商品
		if (null != buyCart) {
			// 判断购物车中的商品是否还有库存
			List<Orderitem> items = buyCart.getItems();
			if (null != items && items.size() > 0) {
				// 判断清理前后
				// 修改Cookie中的购物车数据
				// 流
				StringWriter str = new StringWriter();
				// 对象转Json 写的过程 Json是字符串流
				try {
					oMapper.writeValue(str, buyCart);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 购物车装进Cookie中 对象转Json
				Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
				// 关闭浏览器 也要有Cookie
				// 默认是 -1 关闭浏览器 就没了
				// 消灭 0 马上就没有
				// expiry 秒
				cookie.setMaxAge(60 * 60 * 24);
				// 路径
				/// shopping/buyCart.shtml
				// 默认 /shopping
				// /shopping
				// /buyer/*.shtml
				cookie.setPath("/");
				// 发送
				response.addCookie(cookie);
			}
		}
		return null;
	}

}
