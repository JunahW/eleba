package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Product;

public interface AdminProductService {
	/**
	 * 添加商品
	 * 
	 * @parameter product @parameter @return int @throws
	 */
	int addProduct(Product product);

	/**
	 * 查找商品列表
	 * 
	 * @parameter @return @return List<Product> @throws
	 */

	List<Product> listProduct(Product product);

	/**
	 * 删除商品
	 * 
	 * @parameter @param pid @return void @throws
	 */
	void deleteProduct(String pid);

	/**
	 * 修改商品
	 * 
	 * @parameter @param product @return void @throws
	 */
	void updateProduct(Product product);
	
	/**
	 * 通过商家限制条件查找总条数 @Description: TODO @param @return @return int @throws
	 */
	int getTotalCountByProduct(Product product);


	/**
	 * 通过id查找商品
	 * 
	 * @parameter @param pid @parameter @return @return Product @throws
	 */
	Product selectProductById(String pid);
}
