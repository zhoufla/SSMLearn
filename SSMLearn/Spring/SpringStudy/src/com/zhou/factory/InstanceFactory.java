package com.zhou.factory;

import java.util.HashMap;
import java.util.Map;

import com.zhou.entity.Person;

public class InstanceFactory {

	private Map<String, Person> map = null;

	public InstanceFactory() {
		System.out.println("_____________实例化工厂");
		map = new HashMap<>();
		map.put("zhou", new Person("周先生", 22));
		map.put("wu", new Person("吴女士", 22));
	}

	public Person getPerson(String name) {
		return map.get(name);
	}

}
