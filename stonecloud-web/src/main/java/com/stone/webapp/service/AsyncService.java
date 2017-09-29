package com.stone.webapp.service;

import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	private Logger log = Logger.getLogger(this.getClass());

	@Async
	public void test() {
		log.info("start");
		try {
			Thread.sleep(5000);
			log.info("异步执行的流程");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("end");
	}

	@Async
	public Future<String> asyncMethodWithReturnType() {
		try {
			Thread.sleep(5000);
			log.info("hello world");
			return new AsyncResult<String>("hello world !!!!");
		} catch (InterruptedException e) {
			//
		}

		return null;
	}

	@Async
	public void testAsyncAnnotationForMethodsWithReturnType() {
		try {
			Future<String> future = asyncMethodWithReturnType();
			while (true) { /// 这里使用了循环判断，等待获取结果信息
				if (future.isDone()) { // 判断是否执行完毕
					log.info("Result from asynchronous process - " + future.get());
					break;
				}
			}
		} catch (Exception e) {
			log.error("e");
		}

	}

}
