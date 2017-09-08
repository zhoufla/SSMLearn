package com.zhou.service;

import java.sql.SQLException;
import java.util.List;

import com.zhou.dao.IMessageDAO;
import com.zhou.dao.MessageDAOiBatisImpl;

/**
 * 维护相关的业务功能
 * 
 * @author zhou
 *
 */
public class MaintainService implements Service {
	private IMessageDAO dao;

	/**
	 * 删除单条
	 * 
	 * @param Id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteOne(String Id) throws SQLException {
		if (Id == null || "".equals(Id.trim()))
			return false;
		dao = new MessageDAOiBatisImpl();
		return dao.delete(Integer.valueOf(Id));
	}

	/**
	 * 批量删除
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteBatch(List<Integer> list) throws SQLException {
		if (list == null || list.isEmpty())
			return false;
		dao = new MessageDAOiBatisImpl();
		return dao.deleteBatch(list);
	}
}
