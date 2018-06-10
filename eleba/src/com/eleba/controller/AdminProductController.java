package com.eleba.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eleba.pojo.Product;
import com.eleba.service.AdminProductService;
import com.eleba.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
/**
 * 商家管理用户模块
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
	public ModelAndView listProduct(ModelAndView mv, @RequestParam(required = true, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		PageHelper.startPage(1, 10);
		List<Product> listProduct = adminProductService.listProduct();
		mv.addObject("listProduct", listProduct);
		// mv.addObject("page", p);
		mv.setViewName("admin/product/list");

		return mv;
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
			System.out.println(newName);
		}

		adminProductService.addProduct(product);
		return "forward:/admin/product/list.action";
	}
	
	@RequestMapping(value="/delete")
	public String delete(String pid) {
		adminProductService.deleteProduct(pid);
		return "forward:/admin/product/list.action";
	}
	
	@RequestMapping(value="/update")
	public String update(Product product) {
		adminProductService.updateProduct(product);
		return "forward:/admin/product/list.action";
	}

}
