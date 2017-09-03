package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Items;
import util.DbHelper;

/**
 * 商品的业务逻辑类
 * 
 * @author zhou
 *
 */
public class ItemsDAO {

	/**
	 * 获取所有商品信息
	 * 
	 * @return
	 */
	public List<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Items> list = new ArrayList<>();

		try {
			conn = DbHelper.getConnection();
			String sql = "select * from items";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setCity(rs.getString("city"));
				item.setName(rs.getString("name"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getDouble("price"));
				item.setPicture(rs.getString("picture"));
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 根据ID获取制定商品信息
	 * 
	 * @param id
	 *            商品ID
	 * @return
	 */
	public Items getItemByID(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbHelper.getConnection();
			String sql = "select * from items where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setCity(rs.getString("city"));
				item.setName(rs.getString("name"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getDouble("price"));
				item.setPicture(rs.getString("picture"));
				return item;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据id列表获取Item对象
	 * 
	 * @param list
	 * @return
	 */
	public List<Items> getViewList(List<String> list) {
		List<Items> result = new ArrayList<>();
		for (String str : list) {
			result.add(getItemByID(Integer.valueOf(str)));
		}
		return result;
	}
	/*
	 * public static void main(String[] args) { LinkedList<Integer> list = new
	 * LinkedList<>(); list.add(0); list.add(1); list.add(2); list.add(3);
	 * list.removeFirst(); System.out.println(list.get(0)); String str = "1";
	 * System.out.println(Arrays.toString(str.split(","))); }
	 */
}
