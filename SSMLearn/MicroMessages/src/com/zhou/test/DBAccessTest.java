package com.zhou.test;

import org.junit.Test;

import com.zhou.util.DBAccess;

public class DBAccessTest {

	@Test
	public void test() {
		System.out.println(DBAccess.getSqlSession()==null);
	}

}
