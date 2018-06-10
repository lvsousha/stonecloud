package com.stone.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.stone.webapp.config.ResultMsg;
import com.stone.webapp.service.AsyncService;

@Controller
@RequestMapping("/async")
public class AsyncController {
	
	@Autowired
	private AsyncService asyncService;
	
	@RequestMapping("/test")
	@ResponseBody
	public ResultMsg test(){
		asyncService.test();
		return ResultMsg.getSuccess(new JSONObject());
	}
	
	@RequestMapping("/asyncReturn")
	@ResponseBody
	public ResultMsg asyncReturn(){
		asyncService.testAsyncAnnotationForMethodsWithReturnType();
		return ResultMsg.getSuccess(new JSONObject());
	}

}
