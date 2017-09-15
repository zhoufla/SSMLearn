package com.zhou.impl;

import com.zhou.itf.HelloService;
import com.zhou.itf.ServiceDAO;

public class HelloServiceImpl implements HelloService {
	private ServiceDAO serviceDAO;

	@Override
	public void sayHello() {
		System.out.println("Hello !");
	}

	@Override
	public void save(String arg) {
		System.out.println("Service层接收参数：" + arg);
		serviceDAO.save(arg);
	}

	/**
	 * 设值注入
	 * 
	 * @param serviceDAO
	 */
	public void setServiceDAO(ServiceDAO dao) {
		this.serviceDAO = dao;
	}

	public HelloServiceImpl(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}

	public HelloServiceImpl() {
	}
}
