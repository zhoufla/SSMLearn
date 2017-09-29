package com.zhou.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhou.spring.tx.dao.IBookShopDAO;

@Service("bookShopService")
@Transactional
public class BookShopServiceImpl implements IBookShopService {

	@Autowired
	private IBookShopDAO bookShopDAO;
	
	@Transactional
	@Override
	public void purchase(String username, String bookid, int num) {
		// 查询单价
		double price = bookShopDAO.findPriceById(bookid);
		// 更新库存
		bookShopDAO.updateBookStock(bookid, num);
		// 更新余额
		bookShopDAO.updateUserAccount(username, price * num);
	}

}
