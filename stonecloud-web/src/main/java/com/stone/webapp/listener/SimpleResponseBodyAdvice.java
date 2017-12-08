package com.stone.webapp.listener;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSONObject;

@ControllerAdvice
public class SimpleResponseBodyAdvice implements ResponseBodyAdvice<JSONObject>{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		log.info(returnType);
		return true;
	}

	@Override
	public JSONObject beforeBodyWrite(JSONObject body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		log.info(body);
		body.put("message", "在SimpleResponseBodyAdvice中修改的");
		return body;
	}

}
