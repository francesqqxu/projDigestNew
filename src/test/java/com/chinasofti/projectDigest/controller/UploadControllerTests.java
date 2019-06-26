package com.chinasofti.projectDigest.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.chinasofti.projectDigest.ProjectDigestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadControllerTests {

	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setupMockMvc() {
		
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webContext)
				.build();
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void  homePage() throws Exception{
		/*
		 * mockMvc.perform(mockMvc.get("/multiUpload"))
		 * .andExpect(MockMvcResultMatchers.status().isOk())
		 * .andExpect(MockMvcResultMatchers.view().name("multiUpload"));
		 */
		/*
		 * mockMvc.perform( MockMvcRequestBuilders.get("/multiUpload"))
		 * .andExpect(MockMvcResultMatchers.status().isOk());
		 */		
	
	}

}
