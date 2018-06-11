package com.stone.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.config.BasicConfigBean;
import com.stone.webapp.config.ResultMsg;
import com.stone.webapp.config.exception.ApiException;
import com.stone.webapp.mapper.UserMapper;
import com.stone.webapp.model.User;
import com.stone.webapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BasicConfigBean configBean;
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public ResultMsg insertUser(HttpServletRequest request) throws Exception{
		log.info("insertUser");
		User user = new User();
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setName("zhengchanglin");
		userService.insertUser(user);
		return ResultMsg.buildSuccess(user);
	}
	
	@RequestMapping("/mybatis-plus/insertUser")
	@ResponseBody
	public ResultMsg insertUserByMybatisPlus(HttpServletRequest request) throws Exception{
		log.info("insertUser");
		User user = new User();
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setName("zhengchanglin");
		userService.insertUserByMybatisPlus(user);
		return ResultMsg.buildSuccess(user);
	}
	
	@RequestMapping("/mybatis-plus/countUser")
	@ResponseBody
	public ResultMsg countUserByMybatisPlus(HttpServletRequest request) throws Exception{
		log.info("countUser");
		JSONObject obj = new JSONObject();
		Integer size = userService.countUserByMybatisPlus();
		obj.put("size", size);
		return ResultMsg.buildSuccess(obj);
	}
	
	@RequestMapping("/mybatis-plus/updateName")
	@ResponseBody
	public ResultMsg updateName(HttpServletRequest request) throws Exception{
		log.info("countUser");
		User user = userService.updateName();
		return ResultMsg.buildSuccess(user);
	}
	
	@RequestMapping("/mybatis-plus/updateEmail")
	@ResponseBody
	public ResultMsg updateEmail(HttpServletRequest request) throws Exception{
		log.info("countUser");
		User user = userService.updateEmail();
		return ResultMsg.buildSuccess(user);
	}
	
	@RequestMapping("/mybatis-plus/selectUser")
	@ResponseBody
	public ResultMsg selectUser(HttpServletRequest request) throws Exception{
		log.info("selectUser");
		log.info(configBean.getName());
		List<User> users = userMapper.selectAll();
		Boolean flag = true;
		if(flag){
			throw new Exception("Exception");
		}
		return ResultMsg.buildSuccess(users);
	}

}
