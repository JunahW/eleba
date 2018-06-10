package com.eleba.service.impl;

import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.UserMapper;
import com.eleba.pojo.User;
import com.eleba.pojo.UserExample;
import com.eleba.pojo.UserExample.Criteria;
import com.eleba.service.UserService;
import com.eleba.utils.MD5Utils;
import com.eleba.utils.MailUtils;
import com.eleba.utils.UUIDUtils;

/**
 * 普通用户管理业务层
 * 
 * @author sunwei
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		user.setUid(UUIDUtils.getId());
		user.setCode(UUIDUtils.getCode());
		try {
			MailUtils.sendMail(user.getEmail(),user.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userMapper.insert(user);
	}

	@Override
	public List<User> selectUser(User user) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andNameEqualTo(user.getName());
		criteria.andPasswordEqualTo(user.getPassword());
		return userMapper.selectByExample(userExample);
	}

	@Override
	public int deleteUser(User user) {
		return userMapper.deleteByPrimaryKey(user.getUid());
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	/*
	 * 检验用户登录业务
	 * 
	 */
	public List<User> checkLogin(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();

		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(MD5Utils.md5(user.getPassword()));

		List<User> users = userMapper.selectByExample(example);

		return users;
	}

	@Override
	public int activeUser(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(user.getCode());

		User activeUser = new User();
		activeUser.setState(1);
		return userMapper.updateByExampleSelective(activeUser, example);
	}

}
