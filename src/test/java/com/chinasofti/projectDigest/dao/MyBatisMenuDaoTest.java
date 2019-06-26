package com.chinasofti.projectDigest.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinasofti.projectDigest.pojo.TMenu;
import com.chinasofti.projectDigest.pojo.TMenuExample;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisMenuDaoTest {
	
	@Autowired
	private TMenuMapper tMenuMapper;
	
	@Test
	public void  selectMenuByPid(){
		
		Integer pid = 0;
		
		TMenuExample  tMenuExample =  new TMenuExample();
		tMenuExample.createCriteria().andPidEqualTo(pid);
		
		List<TMenu> tMenu = tMenuMapper.selectByExample(tMenuExample);
		
		//assertEquals(2,tMenu.size());
	}
	
	

}
