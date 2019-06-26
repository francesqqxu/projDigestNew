package com.chinasofti.projectDigest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.projectDigest.dao.TUserMapper;
import com.chinasofti.projectDigest.pojo.TUser;
import com.chinasofti.projectDigest.service.MyBatisUserService;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService{
    
	 @Autowired
	 private TUserMapper tUserMapper = null;
	 
	 @Override 
	 public TUser getUser(Integer id) {
		 return tUserMapper.selectByPrimaryKey(id);
	 }
	
}
