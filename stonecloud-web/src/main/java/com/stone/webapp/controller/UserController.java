package com.stone.webapp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.model.User;
import com.stone.webapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public JSONObject insertUser(HttpServletRequest request) throws Exception{
		log.info("insertUser");
		User user = new User();
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setName("zhengchanglin");
		userService.insertUser(user);
		return JSON.parseObject(JSON.toJSONString(user));
	}
	
	@RequestMapping("/mybatis-plus/insertUser")
	@ResponseBody
	public JSONObject insertUserByMybatisPlus(HttpServletRequest request) throws Exception{
		log.info("insertUser");
		User user = new User();
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setName("zhengchanglin");
		userService.insertUserByMybatisPlus(user);
		return JSON.parseObject(JSON.toJSONString(user));
	}
	
	@RequestMapping("/mybatis-plus/countUser")
	@ResponseBody
	public JSONObject countUserByMybatisPlus(HttpServletRequest request) throws Exception{
		log.info("countUser");
		JSONObject obj = new JSONObject();
		Integer size = userService.countUserByMybatisPlus();
		obj.put("size", size);
		return obj;
	}
	
	@RequestMapping("/mybatis-plus/updateName")
	@ResponseBody
	public JSONObject updateName(HttpServletRequest request) throws Exception{
		log.info("countUser");
		User user = userService.updateName();
		return JSON.parseObject(JSON.toJSONString(user));
	}
	
	@RequestMapping("/mybatis-plus/updateEmail")
	@ResponseBody
	public JSONObject updateEmail(HttpServletRequest request) throws Exception{
		log.info("countUser");
		User user = userService.updateEmail();
		return JSON.parseObject(JSON.toJSONString(user));
	}

}
