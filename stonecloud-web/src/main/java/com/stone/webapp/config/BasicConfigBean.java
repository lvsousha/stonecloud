package com.stone.webapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:config/config.properties","classpath:config/${profiles.active}/basicConfig.properties"})
public class BasicConfigBean {
	
	@Value("${config.basic.name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
