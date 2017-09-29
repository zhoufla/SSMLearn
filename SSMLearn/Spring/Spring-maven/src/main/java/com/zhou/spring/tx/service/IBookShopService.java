package com.zhou.spring.tx.service;

public interface IBookShopService {
	/**
	 * 
	 * @param username 用户
	 * @param bookid 书号
	 * @param num 数量
	 */
	public void purchase(String username ,String bookid,int num);

}
