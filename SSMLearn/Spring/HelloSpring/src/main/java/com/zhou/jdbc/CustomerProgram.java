package com.zhou.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.jdbc.service.CustomerService;

public class CustomerProgram {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("customer.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		CustomerService service = context.getBean("customerService", CustomerService.class);
		// 执行业务逻辑
		/*Customer customer = new Customer();
		customer.setAge(22);
		customer.setCust_id(10);
		customer.setName("成龙");
		service.insert(customer);*/
		System.out.println(service.queryCustomerById(2));
		
	}

}
