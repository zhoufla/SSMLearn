package com.zhou.spring.jdbctemplate.entity;

public class Customer {
	private String name;
	private int age;
	private int cust_id;

	public Customer() {
	}
	
	@Override
	public String toString() {
		return this.getCust_id()+"-"+this.getName()+":"+this.getAge()+"岁";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

}
