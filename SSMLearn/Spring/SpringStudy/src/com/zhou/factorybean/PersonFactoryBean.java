package com.zhou.factorybean;

import org.springframework.beans.factory.FactoryBean;

import com.zhou.entity.Person;

public class PersonFactoryBean<T> implements FactoryBean<T> {
	private String name;

	@SuppressWarnings("unchecked")
	@Override
	public T getObject() throws Exception {
		T t = (T) new Person(name,23);
		return t;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public void setName(String name) {
		this.name = name;
	}

}
