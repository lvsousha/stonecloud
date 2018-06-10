package com.stone.webapp.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class SimpleResponseBodyAdvice implements ResponseBodyAdvice<Object>{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		Class<?> clazz = returnType.getClass();
		log.info(clazz.getName());
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
//		log.info(body);
		log.info(body.getClass().getName());
//		body.put("message", "在SimpleResponseBodyAdvice中修改的");
		return body;
	}

}
