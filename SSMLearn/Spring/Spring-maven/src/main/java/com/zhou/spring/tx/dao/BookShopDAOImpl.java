package com.zhou.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zhou.spring.tx.exception.BookStockException;
import com.zhou.spring.tx.exception.UserAccountException;

@Repository("bookShopDAO")
public class BookShopDAOImpl implements IBookShopDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double findPriceById(String bookId) {
		String sql = "SELECT PRICE FROM BOOK WHERE BOOKID = ?";
		double price = jdbcTemplate.queryForObject(sql, Double.class, bookId);
		return price;
	}

	@Override
	public void updateUserAccount(String username, double price) {
		String sql = "SELECT ACCOUNT FROM USERACCOUNT WHERE USERNAME = ?";
		double account = jdbcTemplate.queryForObject(sql, Double.class, username);
		if (account < price)
			throw new UserAccountException("账户余额不足！");
		sql = "UPDATE USERACCOUNT SET ACCOUNT = ? WHERE USERNAME = ? ";
		jdbcTemplate.update(sql, account - price, username);
	}

	@Override
	public void updateBookStock(String bookId, int num) {
		String sql = "SELECT AMOUNT FROM BOOKSTOCK WHERE BOOKID = ?";
		int amount = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
		if (amount < num)
			throw new BookStockException("书店库存不足！");
		sql = "UPDATE BOOKSTOCK SET AMOUNT = ? WHERE BOOKID = ? ";
		jdbcTemplate.update(sql, amount - num, bookId);
	}

}
