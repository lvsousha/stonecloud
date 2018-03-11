package com.stone.webapp.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.webapp.dao.UserDao;
import com.stone.webapp.model.User;

@Service
public class UserService {

	@Autowired
	private Logger log;
	@Autowired
	private UserDao userDao;
	
	public void testTransaction() throws Exception{
		User user = userDao.findById(1l);
		log.info(user.getNickName());
	}
	
}
