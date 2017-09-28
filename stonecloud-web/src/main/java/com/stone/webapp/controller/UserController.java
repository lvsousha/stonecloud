package com.stone.webapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.model.User;
import com.stone.webapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public JSONObject insertUser(){
		User user = new User();
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setName("zhengchanglin");
		userService.insertUser(user);
		return new JSONObject();
	}

}
