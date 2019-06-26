package com.chinasofti.projectDigest.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.chinasofti.projectDigest.pojo.TProjdigest;
import com.chinasofti.projectDigest.pojo.TProjdigestExample;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisProjDigestDaoTest {
	
	@Autowired
	private TProjdigestMapper tProjdigestMapper;
	
	
		
	@Test
	public void insert() {
		
		TProjdigest   projDigest = new TProjdigest();
		
		//projDigest.setBusinessBrief("bussinessBrief");
		//projDigest.setBusinessFunc("businessFunc");
		
		
		
		//int num = tProjdigestMapper.insert(projDigest);
		//assertEquals(1, num);
		
	}
	
	@Test
	public void findProjDiget() {
		
		TProjdigestExample  tProjdigestExample = new TProjdigestExample();
		tProjdigestExample.setOrderByClause("proj_outcome_id  asc");
		
		List<TProjdigest> tProjdigests = tProjdigestMapper.selectByExample(tProjdigestExample);
		//assertEquals(2, tProjdigests.size());
	}

}
