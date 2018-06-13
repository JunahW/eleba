package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.ProductMapper;
import com.eleba.pojo.Product;
import com.eleba.pojo.ProductExample;
import com.eleba.service.AdminProductService;

@Service
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public int addProduct(Product product) {
		return productMapper.insert(product);
	}

	@Override
	public List<Product> listProduct() {
		ProductExample example = new ProductExample();
		return productMapper.selectByExample(example);
	}

	@Override
	public void deleteProduct(String pid) {
		productMapper.deleteByPrimaryKey(pid);

	}

	@Override
	public void updateProduct(Product product) {
		productMapper.updateByExample(product, new ProductExample());

	}

	@Override
	public Product selectProductById(String pid) {
		return productMapper.selectByPrimaryKey(pid);
	}

}
