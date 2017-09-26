package com.zhou.factory;

import java.util.HashMap;
import java.util.Map;

import com.zhou.entity.Person;

public class MyStaticFactory {
	private static Map<String ,Person> map = new HashMap<>();

	static {
		map.put("zhou", new Person("周先生",22));
		map.put("wu", new Person("吴女士",22));
	}
	
	public static Person getPerson(String name) {
		return map.get(name);
	}
}
