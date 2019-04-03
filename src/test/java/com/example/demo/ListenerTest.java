package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.DemoApplication;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ListenerTest implements ApplicationContextAware {
	private static Logger logger = LoggerFactory.getLogger(ListenerTest.class);
 
	private ApplicationContext context = null;
 
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
 
	@Test
	public void listener() {
		context.publishEvent(new MyEvent(this, "测试"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}