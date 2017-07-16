package com.stone.test.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.stone.test.Basic;
import com.stone.webapp.mapper.UserMapper;
import com.stone.webapp.model.User;
import com.stone.webapp.service.UserService;

public class UserMapperTest extends Basic {

	@Autowired // 自动注入,默认按名称
	private UserMapper userMapper;
	@Autowired
	private UserService userService;

	@Test // 标明是测试方法
	public void test(){
		System.out.println(userMapper.selectAll().size());
		User user = new User();
		Date date = new Date();
		System.out.println(date);
		user.setName("test");
		user.setCreated(date);
		userService.insertUser(user);
		System.out.println(userMapper.selectAll().size());
	}
}
