package com.eleba.service;

import java.util.List;

import com.eleba.pojo.Addr;

public interface AddrService {

	int addAddr(Addr addr);
	List<Addr> selectAddr();
	int deleteAddr(Addr addr);
	int updateAddr(Addr addr);
	
}
