package com.stone.webapp.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stone.webapp.model.User;

public interface UserMapper extends BaseMapper<User>{

	public List<User> selectAll();
	public User selectUser(Integer id);
	public void insertUser(User user);
}
