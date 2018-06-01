package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Product;

public interface AdminProductService {
	int addProduct(Product product);
	List<Product> listProduct();
	void deleteProduct(String pid);
	void updateProduct(Product product);
}
