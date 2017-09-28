package com.zhou.spring.jdbctemplate.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.zhou.spring.jdbctemplate.entity.Customer;

public class JDBCTest {
	private ApplicationContext context;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate; 

	@Test
	public void testDataSource() {
		context = new ClassPathXmlApplicationContext("spring-jdbctemplate/beans-jdbctemplate.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);
	}

	@Test
	public void testUpdate() {
		context = new ClassPathXmlApplicationContext("spring-jdbctemplate/beans-jdbctemplate.xml");
		jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

		String sql = "INSERT INTO CUSTOMER (CUST_ID,NAME,AGE) VALUES(?,?,?)";

		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] { 4, "李小龙", 23 });
		list.add(new Object[] { 5, "王晓飞", 26 });
		// jdbcTemplate.update(sql, 4,"李小龙",23);

		// 批量更新
		jdbcTemplate.batchUpdate(sql, list);

	}

	@Test
	public void testQuery() {
		context = new ClassPathXmlApplicationContext("spring-jdbctemplate/beans-jdbctemplate.xml");
		jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "SELECT CUST_ID,NAME,AGE FROM CUSTOMER";
		RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
		List<Customer> result = null;
		
		result = jdbcTemplate.query(sql, rowMapper);
		
		System.out.println(Arrays.toString(result.toArray()));
	}
	
	
	@Test
	public void testNamedJdbcTemplate() {
		context = new ClassPathXmlApplicationContext("spring-jdbctemplate/beans-jdbctemplate.xml");
		namedJdbcTemplate = context.getBean("namedJdbcTemplate", NamedParameterJdbcTemplate.class);

		String sql = "INSERT INTO CUSTOMER (CUST_ID,NAME,AGE) VALUES(:cust_id,:name,:age)";
		
		Customer customer = new Customer();
		customer.setAge(22);
		customer.setCust_id(11);
		customer.setName("Kobe");
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(customer);
		namedJdbcTemplate.update(sql, paramSource );
	}

}
 