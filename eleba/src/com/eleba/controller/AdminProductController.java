package com.eleba.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.eleba.bean.PageBean;
import com.eleba.pojo.Product;
import com.eleba.service.AdminProductService;
import com.eleba.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

/**
 * 商家管理用户模块
 * 
 * @author asus2016
 *
 */
@Controller
@RequestMapping(value = "/admin/product")
public class AdminProductController {

	@Autowired
	private AdminProductService adminProductService;
	@Value("${product_pic}")
	private String productPicPath;

	@RequestMapping(value = "list")
	public String listProduct(Model model, PageBean<Product> pageBean, Product product) {
		PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSize());
		List<Product> listProduct = adminProductService.listProduct(product);
		int totalCount = adminProductService.getTotalCountByProduct(product);
		pageBean.setTotalCount(totalCount);

		model.addAttribute("listProduct", listProduct);
		model.addAttribute("pageBean", pageBean);
		// 设置回显
		model.addAttribute("product", product);

		return "admin/product/list";
	}

	@RequestMapping(value = "/add")
	public String addProduct(Product product, MultipartFile pfile) {
		String pid = UUIDUtils.getId();
		product.setPid(pid);

		String picName = pfile.getOriginalFilename();
		if (null != picName && picName != "") {

			// 上传图片
			String newName = UUIDUtils.getId() + picName.substring(picName.indexOf("."));
			product.setPimage(newName);
			File picFile = new File(productPicPath, newName);
			if (!picFile.exists()) {
				try {
					picFile.createNewFile();
					pfile.transferTo(picFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		adminProductService.addProduct(product);
		return "/admin/product/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(String pid) {
		adminProductService.deleteProduct(pid);
		return "/admin/product/list";
	}

	@RequestMapping(value = "/update")
	public String update(Product product) {
		adminProductService.updateProduct(product);
		return "/admin/product/list";
	}

}
