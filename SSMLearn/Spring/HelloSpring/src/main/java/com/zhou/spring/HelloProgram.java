package com.zhou.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.spring.helloworld.HelloWorldService;


public class HelloProgram {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloWorldService helloService = context.getBean("HelloWorldService", HelloWorldService.class);
		// 3、执行业务逻辑
		// helloService.sayHello();
		helloService.getHelloWorld().sayHello();
	}
}
