package com.eleba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eleba.dao.AddrMapper;
import com.eleba.pojo.Addr;
import com.eleba.pojo.AddrExample;
import com.eleba.pojo.AddrExample.Criteria;
import com.eleba.pojo.User;
import com.eleba.service.AddrService;

@Service
public class AddrServiceImpl implements AddrService {

	@Autowired
	private AddrMapper addrMapper;

	@Override
	public int addAddr(Addr addr) {
		return addrMapper.insert(addr);
	}

	@Override
	public List<Addr> selectAddr(User user) {
		AddrExample example = new AddrExample();
		Criteria criteria = example.createCriteria();
		criteria.andBuyeridEqualTo(user.getUid());

		return addrMapper.selectByExample(example);
	}

	@Override
	public int deleteAddr(Addr addr) {

		return addrMapper.deleteByPrimaryKey(addr.getId());
	}

	@Override
	public int updateAddr(Addr addr) {
		return addrMapper.updateByPrimaryKey(addr);
	}
}
