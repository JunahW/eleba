package com.eleba.test;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eleba.dao.UserMapper;
import com.eleba.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-*.xml")
public class TestUserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testInsetUser() {
		
		User user=new User();
		user.setUid("003");
		user.setUsername("翁俊河");
		userMapper.insertUser(user);
		
	}
	
	@Test
	public  void testOut() {
		System.out.println(1111);

	}

}
