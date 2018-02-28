package com.stone.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.webapp.dao.UserDao;
import com.stone.webapp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void testTransaction() throws Exception{
		User user = userDao.get(1l);
		user.setUserName("3");
		userDao.update(user);
		throw new RuntimeException();
	}
	
}
