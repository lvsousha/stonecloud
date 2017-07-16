package com.stone.webapp.mapper;

import java.util.List;

import com.stone.webapp.model.User;

public interface UserMapper {

	public List<User> selectAll();
	public User selectUser(Integer id);
}
