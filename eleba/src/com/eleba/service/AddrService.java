package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Addr;
import com.eleba.pojo.User;

public interface AddrService {

	int addAddr(Addr addr);

	List<Addr> selectAddr(User user);

	int deleteAddr(Addr addr);

	int updateAddr(Addr addr);

}
