package com.stone.webapp.service;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.stone.webapp.model.User;

@Service
public class AsyncService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Async
	public void insertUser(User user){
		log.info("start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("end");
	}
	
}
