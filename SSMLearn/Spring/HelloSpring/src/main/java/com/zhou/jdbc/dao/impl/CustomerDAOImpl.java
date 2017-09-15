package com.zhou.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zhou.jdbc.dao.ICustomerDAO;
import com.zhou.jdbc.model.Customer;

public class CustomerDAOImpl implements ICustomerDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (CUST_ID,NAME,AGE) VALUES(?,?,?)";
		Connection conn = null;
		boolean flag = false;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCust_id());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					flag = false;
				}
			}
		}
		return flag;
	}

	@Override
	public Customer queryCustomerById(int id) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setName(rs.getString("NAME"));
				customer.setCust_id(rs.getInt("CUST_ID"));
				customer.setAge(rs.getInt("AGE"));
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
