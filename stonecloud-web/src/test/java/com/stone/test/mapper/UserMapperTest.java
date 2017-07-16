package com.stone.test.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stone.test.Basic;
import com.stone.webapp.mapper.UserMapper;

public class UserMapperTest extends Basic {

	@Autowired // 自动注入,默认按名称
	private UserMapper userMapper;

//	@Transactional // 标明此方法需使用事务
//	@Rollback(true) // 标明使用完此方法后事务不回滚,true时为回滚
	@Test // 标明是测试方法
	public void test(){
		System.out.println(userMapper.selectAll().size());
	}
}
