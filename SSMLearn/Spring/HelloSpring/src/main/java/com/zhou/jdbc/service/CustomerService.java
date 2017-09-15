package com.zhou.jdbc.service;

import com.zhou.jdbc.dao.ICustomerDAO;
import com.zhou.jdbc.model.Customer;

public class CustomerService {

	private ICustomerDAO dao;

	public boolean insert(Customer customer) {
		return dao.insert(customer);
	}

	public Customer queryCustomerById(int id) {
		return dao.queryCustomerById(id);
	}

	public ICustomerDAO getDao() {
		return dao;
	}

	public void setDao(ICustomerDAO dao) {
		this.dao = dao;
	}

}
