package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.UserMapper;
import com.eleba.pojo.User;
import com.eleba.pojo.UserExample;
import com.eleba.pojo.UserExample.Criteria;
import com.eleba.service.UserService;

/**
 * 普通用户管理业务层
 * @author sunwei
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}
	
	@Override
	public List<User> selectUser(User user){
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andNameEqualTo(user.getName());
		criteria.andPasswordEqualTo(user.getPassword());
		return userMapper.selectByExample(userExample);
	}
	
	@Override
	public int deleteUser(User user){
		return userMapper.deleteByPrimaryKey(user.getUid());
	}
	
	@Override 
	public int updateUser(User user){
		return userMapper.updateByPrimaryKey(user);
	}
	

}
