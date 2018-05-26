package com.eleba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.UserMapper;
import com.eleba.pojo.User;
import com.eleba.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser() {

		User user=new User();
		user.setUid("002");
		user.setUsername("jun");
		
		return userMapper.insertUser(user);
	}

}
