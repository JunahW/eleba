package com.eleba.service;

import java.util.List;

import com.eleba.pojo.User;

public interface UserService {
	int addUser(User user);
	List<User> selectUser(User user);
	int deleteUser(User user);
	int updateUser(User user);
}
