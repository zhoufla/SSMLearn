package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Item;
import com.util.DbcpUtil;

public class ItemDAODbcpImpl implements ItemDAO{

	/**
	 * 修改
	 * 
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public boolean updateItem(Item item) throws SQLException {
		Connection conn = DbcpUtil.getConnection();
		PreparedStatement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update items set name = ?,city = ?,price = ? ,number = ?, picture = ? ");
		sql.append("where id = ? ");

		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1, item.getName());
		stmt.setString(2, item.getCity());
		stmt.setDouble(3, item.getPrice());
		stmt.setInt(4, item.getNumber());
		stmt.setString(5, item.getPicture());
		stmt.setInt(6, item.getId());
		stmt.execute();

		stmt.close();
		stmt = null;
		return true;
	}

	/**
	 * 删除
	 * 
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteItem(Item item) throws SQLException {
		Connection conn = DbcpUtil.getConnection();
		PreparedStatement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from items where id = ?");
		stmt = conn.prepareStatement(sql.toString());
		stmt.setInt(1, item.getId());
		stmt.execute();

		stmt.close();
		stmt = null;
		return true;
	}

	/**
	 * 新增
	 * 
	 * @param item
	 * @return
	 * @throws SQLException
	 */
	public boolean insertItem(Item item) throws SQLException {
		Connection conn = DbcpUtil.getConnection();
		PreparedStatement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into items values(?,?,?,?,?,?)");
		stmt = conn.prepareStatement(sql.toString());
		stmt.setInt(1, item.getId());
		stmt.setString(2, item.getName());
		stmt.setString(3, item.getCity());
		stmt.setDouble(4, item.getPrice());
		stmt.setInt(5, item.getNumber());
		stmt.setString(6, item.getPicture());
		stmt.execute();

		stmt.close();
		stmt = null;
		return true;
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Item> queryAllItems() throws SQLException {
		List<Item> list = new ArrayList<>();
		Connection conn = DbcpUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id,name,city,price,number,picture from items where 1=1 ");
		stmt = conn.prepareStatement(sql.toString());
		rs = stmt.executeQuery();
		while (rs.next()) {
			Item item = new Item();
			item.setId(rs.getInt("id"));
			item.setCity(rs.getString("city"));
			item.setName(rs.getString("name"));
			item.setNumber(rs.getInt("number"));
			item.setPicture(rs.getString("picture"));
			item.setPrice(rs.getDouble("price"));
			list.add(item);
		}

		rs.close();
		rs = null;
		stmt.close();
		stmt = null;

		return list;
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Item queryItemById(int id) throws SQLException {
		Item item = new Item();
		Connection conn = DbcpUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id,name,city,price,number,picture from items where 1=1 ");
		sql.append("and id = ? ");
		stmt = conn.prepareStatement(sql.toString());
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		while (rs.next()) {
			item.setId(rs.getInt("id"));
			item.setCity(rs.getString("city"));
			item.setName(rs.getString("name"));
			item.setNumber(rs.getInt("number"));
			item.setPicture(rs.getString("picture"));
			item.setPrice(rs.getDouble("price"));
		}
		return item;
	}

}
