package com.eleba.service;

import java.util.List;

import com.eleba.pojo.User;

/**
 * 用户管理接口
 * 
 * @author asus2016
 *
 */
public interface AdminUserService {
	/**
	 * 
	 * @Description: 展示用户 @param @param user @param @return @return
	 *               List<User> @throws
	 */
	List<User> selectUser(User user);

	/**
	 * 
	 * @Description: 冻结用户 @param @param id @param @return @return int @throws
	 */
	int updateUser2Freeze(String uid);

	/**
	 * 激活用户 @Description: TODO @param @param id @param @return @return int @throws
	 */
	int updateUser2Active(String uid);

	/**
	 * 通过用户限制条件查找总条数 @Description: TODO @param @return @return int @throws
	 */
	int getTotalCountByUser(User user);

	/**
	 * 根据id获取商家 @Description: TODO @param @param bossid @param @return @return
	 * User @throws
	 */
	User selectUserByUid(String bossid);

	/**
	 * 用户登录验证 @Description: TODO @param @param user @param @return @return
	 * User @throws
	 */
	List<User> selectUserByUsernameAndPassword(User user);

}
