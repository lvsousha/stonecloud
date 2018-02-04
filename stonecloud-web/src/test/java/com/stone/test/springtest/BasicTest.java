package com.stone.test.springtest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BasicTest extends Basic {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Transactional // 标明此方法需使用事务
//	@Rollback(true) // 标明使用完此方法后事务不回滚,true时为回滚
	@Test // 标明是测试方法
	public void test(){
		jdbcTemplate.queryForList("select * from User");
	}
}
