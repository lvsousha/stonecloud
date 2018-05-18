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
		System.out.println("in");
	}
	
	public void insertUserByMybatisPlus(User user){
		userMapper.insert(user);
		System.out.println("IN");
	}
	
	public Integer countUserByMybatisPlus(){
		return userMapper.selectCount(new EntityWrapper<User>());
	}
	
	public User updateName(){
		User user = userMapper.selectById(11);
		user.setName("zcl");
		user.setPassword("123456");
		userMapper.update(user,new EntityWrapper<User>().eq("name", "updateName"));
		System.out.println("IN");
		return user;
	}
	
	public User updateEmail(){
		User user = userMapper.selectById(11);
		user.setEmail("updateEmail2");
		userMapper.updateById(user);
		System.out.println(userMapper.selectCount(new EntityWrapper<User>().eq("name", "updateName")));
		System.out.println("IN");
		return user;
	}
	
}
