package com.eleba.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.eleba.pojo.User;
@Repository
public interface UserMapper {
	User getUser(User user);
	int insertUser(User user);
	User selectUser(User user);
	ArrayList<User> selectUsers(User user);

}
