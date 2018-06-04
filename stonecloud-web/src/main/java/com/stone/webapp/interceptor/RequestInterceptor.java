package com.stone.webapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
		log.debug("在进入Controller之后执行——"+handler.getClass().getName());
//		Enumeration<String> attributes = request.getAttributeNames();
//		while(attributes.hasMoreElements()){
//			System.out.println(attributes.nextElement().toString());
//		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)throws Exception {
//		logger.info(model.getViewName());
//		handler.getClass().
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("在进入Controller之前执行——"+handler.getClass().getName());
		return true;
	}

}
