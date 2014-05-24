package com.mumoo.dao;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class UserDaoTest {

	@Autowired
	public UserDao userDao;
	@Test
    public void getCountTotalUser() throws Exception {
     
		
		 Assert.assertNotNull(userDao.getCountTotalUser());
		
    }
}
