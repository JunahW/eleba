package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Business;

/**
 * 用户管理接口
 * 
 * @author asus2016
 *
 */
public interface AdminBusinessService {
	/**
	 * 展示商家 @Description: TODO @param @param business @param @return @return
	 * List<Business> @throws
	 */
	List<Business> selectBusiness(Business business);

	/**
	 * 
	 * @Description: 冻结商家@param @param id @param @return @return int @throws
	 */
	int updateBusiness2Freeze(String bid);

	/**
	 * 激活商家 @Description: TODO @param @param id @param @return @return int @throws
	 */
	int updateBusiness2Active(String bid);

	/**
	 * 通过商家限制条件查找总条数 @Description: TODO @param @return @return int @throws
	 */
	int getTotalCountByBusiness(Business business);

	/**
	 * 通过bid查找商家 @Description: TODO @param @param bid @param @return @return
	 * Business @throws
	 */
	Business selectBusinessByBid(String bid);

}
