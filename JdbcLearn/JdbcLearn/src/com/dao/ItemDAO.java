package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.Item;

public interface ItemDAO {

	/**
	 * 修改
	 * 
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public boolean updateItem(Item item) throws SQLException;

	/**
	 * 删除
	 * 
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteItem(Item item) throws SQLException;

	/**
	 * 新增
	 * 
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public boolean insertItem(Item item) throws SQLException;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Item> queryAllItems() throws SQLException;

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Item queryItemById(int id) throws SQLException;

}
