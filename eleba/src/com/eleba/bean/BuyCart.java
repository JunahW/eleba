package com.eleba.bean;

import java.util.ArrayList;
import java.util.List;
import com.eleba.pojo.Orderitem;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 购物车
 * 
 * @author asus2016
 *
 */
public class BuyCart {

	// 购物项 集合
	List<Orderitem> items = new ArrayList<Orderitem>();

	// 添加方法
	public void addItem(Orderitem item) {
		// 判断是否重复
		if (items.contains(item)) {
			for (Orderitem it : items) {
				if (it.equals(item)) {
					int result = it.getCount() + item.getCount();
					it.setCount(result);
				}
			}

		} else {
			items.add(item);
		}
	}

	// 删除一个
	public void deleteItem(Orderitem item) {
		items.remove(item);
	}

	// 商品金额
	@JsonIgnore
	public Double getProductPrice() {
		Double result = 0.00;
		for (Orderitem item : items) {
			result += item.getProduct().getPrice() * item.getCount();
		}
		return result;
	}

	// 清空购物车
	public void clearCart() {
		items.clear();
	}

	public List<Orderitem> getItems() {
		return items;
	}

	public void setItems(List<Orderitem> items) {
		this.items = items;
	}

}
