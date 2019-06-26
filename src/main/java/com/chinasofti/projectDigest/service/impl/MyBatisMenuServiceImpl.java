package com.chinasofti.projectDigest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.projectDigest.dao.TMenuMapper;
import com.chinasofti.projectDigest.pojo.TMenu;
import com.chinasofti.projectDigest.pojo.TMenuExample;
import com.chinasofti.projectDigest.service.MyBatisMenuService;

@Service
public class MyBatisMenuServiceImpl implements MyBatisMenuService{
	
	@Autowired
	private TMenuMapper tMenuMapper;
	
	@Override
	public List<TMenu> getMenuByPid(int pid){
		
		TMenuExample  tMenuExample =  new TMenuExample();
		tMenuExample.createCriteria().andPidEqualTo(pid);
		
		return tMenuMapper.selectByExample(tMenuExample);
	}

}
