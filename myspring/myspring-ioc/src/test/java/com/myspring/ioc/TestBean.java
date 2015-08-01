package com.myspring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.ioc.service.TestService;

public class TestBean {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String classPathFile="applicationContext.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(classPathFile);
		
		TestService testService=(TestService)context.getBean("testService");
		
		testService.test();
		
	}

}
