package com.stone.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.model.User;
import com.stone.webapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/testTransaction")
	@ResponseBody
	public JSONObject testTransaction() throws Exception{
		userService.testTransaction();
		return new JSONObject();
	}
	
	@RequestMapping("/testCriteria")
	@ResponseBody
	public JSONArray testCriteria() throws Exception{
		List<User> data = userService.testCriteria();
		return (JSONArray) JSON.toJSON(data);
	}
	
}
