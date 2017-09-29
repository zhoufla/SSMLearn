package com.zhou.spring.tx.dao;

public interface IBookShopDAO {
	/**
	 * 根据ID获取书的单价
	 * 
	 * @param bookId
	 * @return
	 */
	public double findPriceById(String bookId);

	/**
	 * 使bookID对应的库存减num
	 * 
	 * @param bookId
	 * @param num
	 */
	public void updateBookStock(String bookId, int num);

	/**
	 * 更新账户余额
	 * 
	 * @param username
	 * @param price
	 */
	public void updateUserAccount(String username, double price);

}
