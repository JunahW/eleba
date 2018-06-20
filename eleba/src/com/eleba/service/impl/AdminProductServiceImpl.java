package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.ProductMapper;
import com.eleba.pojo.Product;
import com.eleba.pojo.ProductExample;
import com.eleba.pojo.ProductExample.Criteria;
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
	public List<Product> listProduct(Product product) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andBidEqualTo(product.getBid());
		if (null != product.getPname() && !"".equals(product.getPname())) {
			criteria.andPnameLike("%" + product.getPname() + "%");
		}

		return productMapper.selectByExample(example);
	}

	@Override
	public void deleteProduct(String pid) {
		productMapper.deleteByPrimaryKey(pid);

	}

	@Override
	public void updateProduct(Product product) {
		productMapper.updateByPrimaryKeySelective(product);

	}

	@Override
	public Product selectProductById(String pid) {
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public int getTotalCountByProduct(Product product) {

		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		if (null != product.getPname() && !"".equals(product.getPname())) {
			criteria.andPnameLike("%" + product.getPname() + "%");
		}
		return productMapper.countByExample(example);
	}

}
