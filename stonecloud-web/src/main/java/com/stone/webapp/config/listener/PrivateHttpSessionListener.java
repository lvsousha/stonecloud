package com.stone.webapp.config.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrivateHttpSessionListener implements HttpSessionListener {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		log.info(se.getSession().getCreationTime()+":session 创建");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		log.info(se.getSession().getCreationTime()+":session 销毁");
	}

}
