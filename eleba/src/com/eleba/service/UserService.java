package com.eleba.service;

import java.util.List;
import com.eleba.pojo.User;

public interface UserService {

	User selectUsersByUserName(String username);

	User selectUserByTelephone(String telephone);

	int addUser(User user);

	List<User> selectUser(User user);

	int updateUser(User user);

	int deleteUser(User user);

	// 检验用户登录
	List<User> checkLogin(User user);

	int activeUser(User user);

}
