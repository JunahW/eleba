package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.UserMapper;
import com.eleba.pojo.User;
import com.eleba.pojo.UserExample;
import com.eleba.pojo.UserExample.Criteria;
import com.eleba.service.AdminUserService;
import com.eleba.utils.MD5Utils;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectUser(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (null != user.getUsername() && !"".equals(user.getUsername().trim())) {
			criteria.andUsernameLike("%" + user.getUsername() + "%");
		}
		return userMapper.selectByExample(example);
	}

	@Override
	public int updateUser2Freeze(String uid) {
		User user = new User();
		user.setUid(uid);
		user.setState(0);
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int updateUser2Active(String uid) {
		User user = new User();
		user.setUid(uid);
		user.setState(1);
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int getTotalCountByUser(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (null != user.getUsername() && !"".equals(user.getUsername().trim())) {
			criteria.andUsernameLike("%" + user.getUsername() + "%");
		}
		return userMapper.countByExample(example);
	}

	@Override
	public User selectUserByUid(String bossid) {
		return userMapper.selectByPrimaryKey(bossid);
	}

	@Override
	public List<User> selectUserByUsernameAndPassword(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		/**
		 * 
		 * 密码加密 开发阶段注释掉
		 */
		// user.setPassword(MD5Utils.md5(user.getPassword()));

		criteria.andPasswordEqualTo(user.getPassword());
		if (null != user.getUsername() && !"".equals(user.getUsername())) {
			criteria.andUsernameEqualTo(user.getUsername());
		} else if (null != user.getTelephone() && !"".equals(user.getTelephone())) {
			criteria.andTelephoneEqualTo(user.getTelephone());
		}

		List<User> loginUsers = userMapper.selectByExample(example);
		return loginUsers;
	}

}
