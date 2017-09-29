package com.stone.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.service.AsyncService;

@Controller
@RequestMapping("/async")
public class AsyncController {
	
	@Autowired
	private AsyncService asyncService;
	
	@RequestMapping("/test")
	@ResponseBody
	public JSONObject test(){
		asyncService.test();
		return new JSONObject();
	}
	
	@RequestMapping("/asyncReturn")
	@ResponseBody
	public JSONObject asyncReturn(){
		asyncService.testAsyncAnnotationForMethodsWithReturnType();
		return new JSONObject();
	}

}
