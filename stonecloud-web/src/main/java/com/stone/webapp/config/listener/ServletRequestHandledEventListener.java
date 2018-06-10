package com.stone.webapp.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent>{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onApplicationEvent(ServletRequestHandledEvent event) {
		String url = event.getRequestUrl();
		if(url.indexOf("static") == -1){
			log.debug(event.getDescription());
		}
//		logger.info(event.getStatusCode());
		
	}

}
