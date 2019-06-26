package com.chinasofti.projectDigest.service;

import java.util.List;

import com.chinasofti.projectDigest.pojo.TMenu;

public interface MyBatisMenuService {

	   public List<TMenu> getMenuByPid(int pid);
}
