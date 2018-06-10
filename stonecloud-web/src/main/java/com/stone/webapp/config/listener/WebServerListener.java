package com.stone.webapp.config.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebServerListener implements ServletContextListener{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 监听web容器启动
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    	
    	log.info("启动项目的执行，web容器启动===" +springContext);

    }
    /**
     * 监听web容器关闭
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	log.info("web容器关闭");

    }
}
