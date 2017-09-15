package com.zhou.impl;

import com.zhou.itf.ServiceDAO;

public class ServiceDAOImpl implements ServiceDAO{

	@Override
	public boolean save(String arg) {
		System.out.println("DAO层：保存信息'"+arg+"'");
		return false;
	}

}
