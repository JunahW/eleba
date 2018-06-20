package com.eleba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eleba.pojo.Business;
import com.eleba.pojo.Product;
import com.eleba.service.AdminBusinessService;
import com.eleba.service.AdminProductService;

@RequestMapping(value = "/product")
@Controller
public class ProductController {
	@Autowired
	private AdminProductService adminProductService;

	@Autowired
	private AdminBusinessService adminBusinessService;

	@Value("${p_img_server}")
	private String productImgServer;
	@Value("${b_img_server}")
	private String businessImgServer;

	@RequestMapping(value = "/list")
	public String list(Product product, Model model, String bid) {
		product.setBid(bid);
		List<Product> list = adminProductService.listProduct(product);
		Business business = adminBusinessService.selectBusinessByBid(bid);

		model.addAttribute("list", list);
		model.addAttribute("product", product);
		model.addAttribute("b", business);
		model.addAttribute("productImgServer", productImgServer);
		model.addAttribute("businessImgServer", businessImgServer);

		return "/user/shop";

	}

}
