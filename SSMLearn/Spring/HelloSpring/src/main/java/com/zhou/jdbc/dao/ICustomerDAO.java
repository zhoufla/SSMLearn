package com.zhou.jdbc.dao;

import com.zhou.jdbc.model.Customer;

public interface ICustomerDAO {
	public boolean insert(Customer customer);

	public Customer queryCustomerById(int id);
}
