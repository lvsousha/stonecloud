package com.stone.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stone.webapp.mapper.UserMapper;
import com.stone.webapp.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void insertUser(User user){
		userMapper.insertUser(user);
	}
	
	public void insertUserByMybatisPlus(User user){
		userMapper.insert(user);
		System.out.println("IN");
	}
	
	public Integer countUserByMybatisPlus(){
		return userMapper.selectCount(new EntityWrapper<User>());
	}
	
}
