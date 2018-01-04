package com.stone.webapp.listener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.alibaba.fastjson.JSONObject;

@ControllerAdvice
public class SimpleRequestBodyAdvice implements RequestBodyAdvice{

	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		if(methodParameter.getMethod().getReturnType() == JSONObject.class){
			return true;
		}
		return false;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		log.info(body);
		return body;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		// TODO Auto-generated method stub
		log.info(inputMessage.getClass());
		StringBuffer sb = new StringBuffer();
		byte[] b = new byte[1024];
		InputStream is = inputMessage.getBody();
		int i = is.read(b);
		while(i != -1){
			sb.append(new String(b));
			i = is.read(b);
		}
		try {
			log.info(sb.toString());
			Class<?> message = Class.forName("org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver$EmptyBodyCheckingHttpInputMessage");
			for(Field field : message.getDeclaredFields()){
				if(field.getName().equals("body")){
					field.setAccessible(true);
					field.set(inputMessage, new ByteArrayInputStream(sb.toString().getBytes()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputMessage;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		log.info(body);
		return body;
	}
	

}
