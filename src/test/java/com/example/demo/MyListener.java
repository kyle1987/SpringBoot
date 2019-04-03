package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
	private Logger logger = LoggerFactory.getLogger(getClass());
 
	@EventListener // 注意此处
	public void handleDemoEvent(MyEvent event) {
		logger.info("发布的data为:{}", event.getData());
	}
}